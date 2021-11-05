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
class P043Solver(
    private val listCalculator: ListCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        val permutations = listCalculator.permutations(listOf(0L, 1, 2, 3, 4, 5, 6, 7, 8, 9))
        var sum = 0L
        for (digits in permutations) {
            if (isTheProperty(digits)) {
                val value = digits.reduce { v, e -> v * 10 + e }
                sum += value
            }
        }
        return sum.toString()
    }

    private fun isTheProperty(digits: List<Long>): Boolean {
        val second = digits.subList(1, 4).reduce { v, e -> v * 10 + e }
        if (second % 2 != 0L) {
            return false
        }
        val third = digits.subList(2, 5).reduce { v, e -> v * 10 + e }
        if (third % 3 != 0L) {
            return false
        }
        val fourth = digits.subList(3, 6).reduce { v, e -> v * 10 + e }
        if (fourth % 5 != 0L) {
            return false
        }
        val fifth = digits.subList(4, 7).reduce { v, e -> v * 10 + e }
        if (fifth % 7 != 0L) {
            return false
        }
        val sixth = digits.subList(5, 8).reduce { v, e -> v * 10 + e }
        if (sixth % 11 != 0L) {
            return false
        }
        val seventh = digits.subList(6, 9).reduce { v, e -> v * 10 + e }
        if (seventh % 13 != 0L) {
            return false
        }
        val eighth = digits.subList(7, 10).reduce { v, e -> v * 10 + e }
        if (eighth % 17 != 0L) {
            return false
        }
        return true
    }
}
