/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.NumericalCalculator
import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.math.RoundingMode

@Component
class P033Solver(
    private val numericalCalculator: NumericalCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        var numerator = 1
        var denomitor = 1
        for (i in 1..9) {
            for (j in 1..9) {
                for (k in 1..9) {
                    @Suppress
                    if (isMatch(10 * i + k, 10 * j + k, i, j)) {
                        numerator *= i
                        denomitor *= j
                    }
                    if (isMatch(10 * k + i, 10 * j + k, i, j)) {
                        numerator *= i
                        denomitor *= j
                    }
                    if (isMatch(10 * i + k, 10 * k + j, i, j)) {
                        numerator *= i
                        denomitor *= j
                    }
                    if (isMatch(10 * k + i, 10 * k + j, i, j)) {
                        numerator *= i
                        denomitor *= j
                    }
                }
            }
        }
        val gcd = numericalCalculator.gcd(numerator.toLong(), denomitor.toLong())
        return (denomitor / gcd.toInt()).toString()
    }

    private fun isMatch(n: Int, d: Int, i: Int, j: Int): Boolean {
        if (n >= d) {
            return false
        }
        val a =
            BigDecimal.valueOf(i.toLong()).divide(BigDecimal.valueOf(j.toLong()), 10, RoundingMode.HALF_UP)
        val b =
            BigDecimal.valueOf(n.toLong()).divide(BigDecimal.valueOf(d.toLong()), 10, RoundingMode.HALF_UP)
        return a == b
    }
}
