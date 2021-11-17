/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.ListCalculator
import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.stereotype.Component

@Component
class P068Solver(
    private val listCalculator: ListCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        var max = ""
        val permutations = listCalculator.permutations(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
        for (permutation in permutations) {
            if (isMagic(permutation)) {
                val digits = toDigits(permutation)
                if (digits.length == 16 && isRight(permutation) && digits > max) {
                    max = digits
                }
            }
        }
        return max
    }

    private fun isRight(permutation: List<Int>): Boolean {
        for (i in 6..9) {
            if (permutation[5] > permutation[i]) {
                return false
            }
        }
        return true
    }

    private fun toDigits(permutation: List<Int>): String {
        val stringBuilder = StringBuilder()
        for (i in 0..4) {
            stringBuilder.append(permutation[i + 5]).append(permutation[i]).append(permutation[(i + 1) % 5])
        }
        return stringBuilder.toString()
    }

    private fun isMagic(permutation: List<Int>): Boolean {
        val sum = permutation[0] + permutation[1] + permutation[5]
        for (i in 1..4) {
            val otherSum = permutation[i] + permutation[(i + 1) % 5] + permutation[i + 5]
            if (sum != otherSum) {
                return false
            }
        }
        return true
    }
}
