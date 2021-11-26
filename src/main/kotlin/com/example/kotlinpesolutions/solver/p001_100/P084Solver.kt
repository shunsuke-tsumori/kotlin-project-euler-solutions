/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.stereotype.Component
import java.security.SecureRandom

@Component
class P084Solver : ProjectEulerSolver {
    override fun run(): String {
        val (dice1, dice2, communityChests, chances, countMap) = GameResources()
        var currentSquare = Square.GO
        for (i in 1..SAMPLE_COUNT) {
            currentSquare = oneTurn(currentSquare, dice1, dice2, communityChests, chances)
            countMap[currentSquare] = countMap[currentSquare]!! + 1
        }
//        for ((k, v) in countMap) {
//            val percent = 100.0 * v / SAMPLE_COUNT
//            println("$k, $percent%")
//        }
        val sortedCount = countMap.toList().sortedBy { it.second }.reversed()
        var ans = ""
        for (i in 0..2) {
            ans += "%02d".format(sortedCount[i].first.ordinal)
        }
        return ans
    }

    // ゾロ目かつ効果ありマスの場合の細かいルールが不明。。。
    private fun oneTurn(
        from: Square,
        dice1: Dice,
        dice2: Dice,
        communityChests: CommunityChests,
        chances: Chances
    ): Square {
        var currentSquare = from
        for (i in 1..3) {
            val dice1Num = dice1.roll()
            val dice2Num = dice2.roll()
            currentSquare = Square.values()[(dice1Num + dice2Num + currentSquare.ordinal) % Square.values().size]
            if (dice1Num == dice2Num && i == 3) {
                currentSquare = Square.JAIL
                break
            } else if (Square.isCommunityChest(currentSquare)) {
                val card = communityChests.draw()
                val nextSquare = moveByCommunityChestsCard(card, currentSquare)
                if (currentSquare != nextSquare) {
                    currentSquare = nextSquare
                    break
                }
            } else if (Square.isChance(currentSquare)) {
                val card = chances.draw()
                val nextSquare =moveByChanceCard(card, currentSquare)
                if (currentSquare != nextSquare) {
                    currentSquare = nextSquare
                    break
                }
            }
            if (currentSquare == Square.G2J) {
                currentSquare = Square.JAIL
            }
            if (dice1Num != dice2Num) {
                break
            }
        }
        return currentSquare
    }

    private fun moveByChanceCard(
        card: Chances.ChanceCard,
        currentSquare: Square
    ): Square {
        return when (card) {
            Chances.ChanceCard.ADVANCE_TO_GO -> Square.GO
            Chances.ChanceCard.GO_TO_JAIL -> Square.JAIL
            Chances.ChanceCard.GO_TO_C1 -> Square.C1
            Chances.ChanceCard.GO_TO_E3 -> Square.E3
            Chances.ChanceCard.GO_TO_H2 -> Square.H2
            Chances.ChanceCard.GO_TO_R1 -> Square.R1
            Chances.ChanceCard.GO_TO_NEXT_R1, Chances.ChanceCard.GO_TO_NEXT_R2 -> nextR(currentSquare)
            Chances.ChanceCard.GO_TO_NEXT_U -> nextU(currentSquare)
            Chances.ChanceCard.GO_BACK_3_SQUARES -> goBack3Squares(currentSquare)
            else -> currentSquare
        }
    }

    private fun goBack3Squares(currentSquare: Square): Square {
        val backSquares = 3
        return Square.values()[(Square.values().size + currentSquare.ordinal - backSquares) % Square.values().size]
    }

    private fun nextU(currentSquare: Square): Square {
        return when (currentSquare) {
            Square.U1, Square.C2, Square.C3, Square.R2, Square.D1, Square.CC2, Square.D2, Square.D3, Square.FP, Square.E1, Square.CH2, Square.E2, Square.E3, Square.R3, Square.F1, Square.F2 -> Square.U2
            else -> Square.U1
        }
    }

    private fun nextR(currentSquare: Square): Square {
        return when (currentSquare) {
            Square.R4, Square.CH3, Square.H1, Square.T2, Square.H2, Square.GO, Square.A1, Square.CC1, Square.A2, Square.T1 -> Square.R1
            Square.R1, Square.B1, Square.CH1, Square.B2, Square.B3, Square.JAIL, Square.C1, Square.U1, Square.C2, Square.C3 -> Square.R2
            Square.R2, Square.D1, Square.CC2, Square.D2, Square.D3, Square.FP, Square.E1, Square.CH2, Square.E2, Square.E3 -> Square.R3
            else -> Square.R4
        }
    }

    private fun moveByCommunityChestsCard(
        card: CommunityChests.CommunityChestCard,
        currentSquare: Square
    ): Square {
        return when (card) {
            CommunityChests.CommunityChestCard.ADVANCE_TO_GO -> Square.GO
            CommunityChests.CommunityChestCard.GO_TO_JAIL -> Square.JAIL
            else -> currentSquare
        }
    }

    private data class GameResources(
        val dice1: Dice = ThisGameDice(),
        val dice2: Dice = ThisGameDice(),
        val communityChests: CommunityChests = CommunityChests(),
        val chances: Chances = Chances(),
        val countMap: MutableMap<Square, Int> = mutableMapOf()
    ) {
        init {
            for (square in Square.values()) {
                countMap[square] = 0
            }
        }
    }

    private interface Dice {
        fun roll(): Int
    }

    private class ThisGameDice(
        private val secureRandom: SecureRandom = SecureRandom()
    ) : Dice {
        override fun roll(): Int {
            return secureRandom.nextInt(DICE_SIDE) + 1
        }
    }

    private class CommunityChests {
        private val cards: ArrayDeque<CommunityChestCard> = ArrayDeque()
        fun draw(): CommunityChestCard {
            val first = cards.first()
            cards.removeFirst()
            cards.addLast(first)
            return first
        }

        init {
            cards.addAll(CommunityChestCard.values())
            cards.shuffle()
        }

        enum class CommunityChestCard {
            ADVANCE_TO_GO, GO_TO_JAIL, NON1, NON2, NON3, NON4, NON5, NON6, NON7, NON8, NON9, NON10,
            NON11, NON12, NON13, NON14
        }
    }

    private class Chances {
        private val cards: ArrayDeque<ChanceCard> = ArrayDeque()
        fun draw(): ChanceCard {
            val first = cards.first()
            cards.removeFirst()
            cards.addLast(first)
            return first
        }

        init {
            cards.addAll(ChanceCard.values())
            cards.shuffle()
        }

        enum class ChanceCard {
            ADVANCE_TO_GO, GO_TO_JAIL, GO_TO_C1, GO_TO_E3, GO_TO_H2, GO_TO_R1,
            GO_TO_NEXT_R1, GO_TO_NEXT_R2, GO_TO_NEXT_U, GO_BACK_3_SQUARES,
            NON1, NON2, NON3, NON4, NON5, NON6
        }
    }

    private enum class Square {
        GO, A1, CC1, A2, T1, R1, B1, CH1, B2, B3,
        JAIL, C1, U1, C2, C3, R2, D1, CC2, D2, D3,
        FP, E1, CH2, E2, E3, R3, F1, F2, U2, F3,
        G2J, G1, G2, CC3, G3, R4, CH3, H1, T2, H2;

        companion object {
            val COMMUNITY_CHEST = listOf(CC1, CC2, CC3)
            val CHANCE = listOf(CH1, CH2, CH3)

            fun isCommunityChest(square: Square): Boolean {
                return COMMUNITY_CHEST.contains(square)
            }

            fun isChance(square: Square): Boolean {
                return CHANCE.contains(square)
            }
        }
    }

    companion object {
        const val DICE_SIDE = 4
        const val SAMPLE_COUNT = 1_000_000
    }
}
