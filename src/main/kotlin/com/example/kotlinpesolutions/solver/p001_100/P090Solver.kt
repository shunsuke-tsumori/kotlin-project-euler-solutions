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
class P090Solver(
    private val listCalculator: ListCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        val combinations1 = listCalculator.combinations(listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), 6)
        val combinations2 = listCalculator.combinations(listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), 6)

        var count = 0
        for (combination1 in combinations1) {
            for (combination2 in combinations2) {
                if (isMatch(combination1, combination2)) {
                    count++
                }
            }
        }

        return count.toString()
    }

    private fun isMatch(combination1: List<Int>, combination2: List<Int>): Boolean {
        if (combination1.compare(combination2) <= 0) {
            return false
        }

        val squares = (1..9).map { it * it }
        for (square in squares) {
            if (!isAnyMatch(combination1, combination2, square)) {
                return false
            }
        }
        return true
    }

    private fun isAnyMatch(combination1: List<Int>, combination2: List<Int>, square: Int): Boolean {
        for (n1 in combination1) {
            for (n2 in combination2) {
                if (n1 * 10 + n2 == square || n2 * 10 + n1 == square) {
                    return true
                }
                if (n1 == 9 && (60 + n2 == square || n2 * 10 + 6 == square)) {
                    return true
                }
                if (n2 == 9 && (60 + n1 == square || n1 * 10 + 6 == square)) {
                    return true
                }

                if (n1 == 6 && (90 + n2 == square || n2 * 10 + 9 == square)) {
                    return true
                }
                if (n2 == 6 && (90 + n1 == square || n1 * 10 + 9 == square)) {
                    return true
                }
            }
        }
        return false
    }

    // assert self.size == other.size
    private fun List<Int>.compare(other: List<Int>): Int {
        for (i in this.indices) {
            if (this[i] > other[i]) {
                return 1
            }
            if (this[i] < other[i]) {
                return -1
            }
        }
        return 0
    }
}
