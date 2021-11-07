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
class P056Solver : ProjectEulerSolver {
    override fun run(): String {
        var maxSum = 0L
        for (a in 1L until 100) {
            for (b in 1 until 100) {
                val power = BigInteger.valueOf(a).pow(b)
                val sum = digitalSum(power)
                if (sum > maxSum) {
                    maxSum = sum
                }
            }
        }
        return maxSum.toString()
    }

    private fun digitalSum(power: BigInteger): Long {
        return power
            .toString()
            .map { d -> d.digitToInt().toLong() }
            .reduce { sum, elem -> sum + elem }
    }
}
