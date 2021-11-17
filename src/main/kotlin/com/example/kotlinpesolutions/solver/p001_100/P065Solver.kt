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
import java.math.BigInteger

@Component
class P065Solver : ProjectEulerSolver {
    override fun run(): String {
        var numerator = BigInteger.ONE
        var denominator = BigInteger.ZERO

        for (i in 99 downTo 1) {
            val continuedFractionNumAddedNumerator = numerator.times(continuedFractionNumber(i).toBigInteger()) + denominator
            denominator = numerator
            numerator = continuedFractionNumAddedNumerator
        }
        val swp = denominator
        denominator = numerator
        numerator = swp
        numerator += BigInteger.TWO.times(denominator)
        return numerator.toString().map { it.digitToInt() }.sum().toString()
    }

    fun continuedFractionNumber(n: Int): Int {
        if (n % 3 == 2) {
            return 2 * (n + 1) / 3
        }
        return 1
    }
}
