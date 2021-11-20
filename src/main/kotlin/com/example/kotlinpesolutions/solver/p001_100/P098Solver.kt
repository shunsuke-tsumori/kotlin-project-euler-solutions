/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.StringCalculator
import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.floor
import kotlin.math.sqrt

@Component
class P098Solver(
    private val stringCalculator: StringCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        val words = readWords()
        val anagramPairs = mutableListOf<Pair<String, String>>()
        for (i in 0..words.size - 2) {
            for (j in i + 1 until words.size) {
                if (stringCalculator.isPermutation(words[i], words[j])) {
                    anagramPairs.add(Pair(words[i], words[j]))
                }
            }
        }
        var max = 0
        for (anagramPair in anagramPairs) {
            val charList = anagramPair.first.map { it }.toSet().toList()
            val maxOfThePair = maxSquareOf(anagramPair, charList, 0, mapOf())
            if (maxOfThePair > max) {
                max = maxOfThePair
            }
        }
        return max.toString()
    }

    private fun maxSquareOf(
        anagramPair: Pair<String, String>,
        charList: List<Char>,
        idx: Int,
        charToNum: Map<Char, Int>
    ): Int {
        if (idx == charList.size) {
            val firstValue = anagramPair.first.map { c -> charToNum[c]!! }.reduce { sum, elem -> sum * 10 + elem }
            if (isSquare(firstValue)) {
                val secondValue = anagramPair.second.map { c -> charToNum[c]!! }.reduce { sum, elem -> sum * 10 + elem }
                if (isSquare(secondValue)) {
                    return maxOf(firstValue, secondValue)
                }
            }
            return 0
        } else {
            var max = 0
            for (i in 1..9) {
                if (charToNum.values.contains(i)) {
                    continue
                }
                val nextCharToNum = charToNum.toMutableMap()
                nextCharToNum[charList[idx]] = i
                val value = maxSquareOf(anagramPair, charList, idx + 1, nextCharToNum)
                if (value > max) {
                    max = value
                }
            }
            return max
        }
    }
}

private fun isSquare(n: Int): Boolean {
    val sqrt = floor(sqrt(n.toDouble())).toInt()
    return sqrt * sqrt == n
}

private fun readWords(): List<String> {
    val resourceStream = ClassPathResource("params/p98.txt").inputStream
    val reader = BufferedReader(InputStreamReader(resourceStream))
    val line = reader.readLine()!!
    reader.close()

    return line
        .split(",")
        .map { n -> n.replace("\"", "") }
}

