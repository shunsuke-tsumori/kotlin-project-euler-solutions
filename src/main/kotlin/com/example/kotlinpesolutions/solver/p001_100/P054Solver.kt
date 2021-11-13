/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.stream.Collectors

@Component
class P054Solver : ProjectEulerSolver {
    override fun run(): String {
        val games = readGames()
        var count = 0
        for (game in games) {
            if (is1Wins(game)) {
                count++
            }
        }
        return count.toString()
    }

    private fun is1Wins(game: Pair<List<Card>, List<Card>>): Boolean {
        val score1 = score(game.first)
        val score2 = score(game.second)
        return if (score1.first.roleValue > score2.first.roleValue) {
            true
        } else if (score1.first.roleValue == score2.first.roleValue) {
            if (score1.second > score2.second) {
                true
            } else if (score1.second == score2.second) {
                is1WinCompareHighest(game.first, game.second)
            } else {
                false
            }
        } else {
            false
        }
    }

    private fun is1WinCompareHighest(first: List<Card>, second: List<Card>): Boolean {
        val sorted1 = first.sortedBy { c -> c.number.value }.reversed()
        val sorted2 = second.sortedBy { c -> c.number.value }.reversed()
        for (i in sorted1.indices) {
            if (sorted1[i].number.value != sorted2[i].number.value) {
                return sorted1[i].number.value > sorted2[i].number.value
            }
        }
        throw Exception("決着付かず")
    }

    private fun score(hand: List<Card>): Pair<PokerHand, Int> {
        val isStraight = isStraight(hand)
        val isFlush = isFlush(hand)
        val highestValue = highestValue(hand)
        val sameKindCount = sameKindCount(hand)

        if (isStraight && isFlush) {
            return if (highestValue == Number.ACE.value) {
                Pair(PokerHand.ROYAL_FLUSH, highestValue)
            } else {
                Pair(PokerHand.STRAIGHT_FLUSH, highestValue)
            }
        }
        val (isFourOfAKind, fourOfAKindValue) = isFourOfAKindAndTheValue(sameKindCount)
        if (isFourOfAKind) {
            return Pair(PokerHand.FOUR_OF_A_KIND, fourOfAKindValue)
        }
        val (isFullHouse, fullHouseValue) = isFullHouseAndTheValue(sameKindCount)
        if (isFullHouse) {
            return Pair(PokerHand.FULL_HOUSE, fullHouseValue)
        }
        if (isFlush) {
            return Pair(PokerHand.FLUSH, highestValue)
        }
        if (isStraight) {
            return Pair(PokerHand.STRAIGHT, highestValue)
        }
        val (isThreeOfAKind, threeOfAKindValue) = isThreeOfAKindAndTheValue(sameKindCount)
        if (isThreeOfAKind) {
            return Pair(PokerHand.THREE_OF_A_KIND, threeOfAKindValue)
        }
        val (isTwoPair, twoPairValue) = isTwoPairAndTheValue(sameKindCount)
        if (isTwoPair) {
            return Pair(PokerHand.TWO_PAIRS, twoPairValue)
        }
        val (isOnePair, onePairValue) = isOnePairAndTheValue(sameKindCount)
        if (isOnePair) {
            return Pair(PokerHand.ONE_PAIR, onePairValue)
        }
        return Pair(PokerHand.HIGH_CARD, highestValue)
    }

    private fun highestValue(hand: List<Card>): Int {
        return hand.maxOf { card -> card.number.value }
    }

    private fun isStraight(hand: List<Card>): Boolean {
        val values = hand.map { it.number.value }.sorted()
        for (i in 1 until values.size) {
            if (values[i - 1] + 1 != values[i]) {
                return false
            }
        }
        return true
    }

    private fun isFlush(hand: List<Card>): Boolean {
        return hand.all { card -> card.mark == hand[0].mark }
    }

    private fun sameKindCount(hand: List<Card>): Map<Number, Int> {
        val counter = mutableMapOf<Number, Int>()
        for (n in Number.values()) {
            val count = hand.filter { c -> c.number == n }.size
            if (count > 0) {
                counter[n] = count
            }
        }
        return counter
    }

    private fun isFourOfAKindAndTheValue(sameKindCount: Map<Number, Int>): Pair<Boolean, Int> {
        for (kind in sameKindCount.keys) {
            if (sameKindCount[kind] == 4) {
                return Pair(true, kind.value)
            }
        }
        return Pair(false, 0)
    }

    private fun isThreeOfAKindAndTheValue(sameKindCount: Map<Number, Int>): Pair<Boolean, Int> {
        for (kind in sameKindCount.keys) {
            if (sameKindCount[kind] == 3) {
                return Pair(true, kind.value)
            }
        }
        return Pair(false, 0)
    }

    private fun isFullHouseAndTheValue(sameKindCount: Map<Number, Int>): Pair<Boolean, Int> {
        if (sameKindCount.size != 2) {
            return Pair(false, 0)
        }
        return isThreeOfAKindAndTheValue(sameKindCount)
    }

    // 2ペア以下の役であることを仮定する。
    private fun isTwoPairAndTheValue(sameKindCount: Map<Number, Int>): Pair<Boolean, Int> {
        if (sameKindCount.size != 3) {
            return Pair(false, 0)
        }
        val theValue = sameKindCount.filter { count -> count.value == 2 }.maxOf { count -> count.key.value }
        return Pair(true, theValue)
    }

    // 1ペア以下の役であることを仮定する。
    private fun isOnePairAndTheValue(sameKindCount: Map<Number, Int>): Pair<Boolean, Int> {
        for (kind in sameKindCount.keys) {
            if (sameKindCount[kind] == 2) {
                return Pair(true, kind.value)
            }
        }
        return Pair(false, 0)
    }

    private fun readGames(): List<Pair<List<Card>, List<Card>>> {
        val resourceStream = ClassPathResource("params/p54.txt").inputStream
        val reader = BufferedReader(InputStreamReader(resourceStream))
        val games = reader
            .lines()
            .map { l ->
                val hands = l.split(" ").map { display -> Card(display) }
                Pair(hands.subList(0, 5), hands.subList(5, 10))
            }
            .collect(Collectors.toList())
        reader.close()
        return games
    }

    private data class Card constructor(private val display: String) {
        val number: Number
        val mark: Mark

        init {
            number = value(display[0])
            mark = mark(display[1])
        }

        private fun value(char: Char): Number {
            return when (char) {
                '2' -> Number.TWO
                '3' -> Number.THREE
                '4' -> Number.FOUR
                '5' -> Number.FIVE
                '6' -> Number.SIX
                '7' -> Number.SEVEN
                '8' -> Number.EIGHT
                '9' -> Number.NINE
                'T' -> Number.TEN
                'J' -> Number.JACK
                'Q' -> Number.QUEEN
                'K' -> Number.KING
                'A' -> Number.ACE
                else -> throw Exception("不正な文字")
            }
        }

        private fun mark(char: Char): Mark {
            return when (char) {
                'S' -> Mark.SPADE
                'H' -> Mark.HEART
                'D' -> Mark.DIAMOND
                'C' -> Mark.CLUB
                else -> throw Exception("不正な文字")
            }
        }
    }

    private enum class Number(
        val value: Int
    ) {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(14),
    }

    private enum class Mark {
        SPADE, HEART, DIAMOND, CLUB
    }

    private enum class PokerHand(
        val roleValue: Int
    ) {
        HIGH_CARD(1),
        ONE_PAIR(2),
        TWO_PAIRS(3),
        THREE_OF_A_KIND(4),
        STRAIGHT(5),
        FLUSH(6),
        FULL_HOUSE(7),
        FOUR_OF_A_KIND(8),
        STRAIGHT_FLUSH(9),
        ROYAL_FLUSH(10)
    }
}
