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
import kotlin.math.floor
import kotlin.math.sqrt

@Component
class P086Solver(
    private val numericalCalculator: NumericalCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        val bound = 1_000_000
        var m = 1
        while (true) {
            val count = countPatterns(m)
            if (count > bound) {
                return m.toString()
            }
            m++
        }
    }

    // like p75
    private fun countPatterns(maxSideL: Int): Int {
        val mMax = floor(sqrt(maxSideL * 2.0)).toInt()
        var count = 0
        for (m in 1..mMax) {
            for (n in 1 until m) {
                if ((m + n) % 2 == 1 && numericalCalculator.gcd(m, n) == 1) {
                    val abOrC1 = m * m - n * n
                    val abOrC2 = 2 * m * n
                    for (i in 1..maxSideL / abOrC1) {
                        count += countPatterns(abOrC2 * i, abOrC1 * i)
                    }
                    for (i in 1..maxSideL / abOrC2) {
                        count += countPatterns(abOrC1 * i, abOrC2 * i)
                    }
                }
            }
        }
        return count
    }

    private fun countPatterns(ab: Int, c: Int): Int {
        return if (ab > 2 * c) {
            0
        } else if (c >= ab) {
            ab / 2
        } else if (ab % 2 == 0) {
            1 + c - ab / 2
        } else {
            c - ab / 2
        }
    }
}
