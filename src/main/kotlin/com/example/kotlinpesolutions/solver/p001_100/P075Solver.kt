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
class P075Solver(
    private val numericalCalculator: NumericalCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        val bound = 1_500_000
        val mMax = floor(sqrt(bound / 2.0)).toInt()
        val lToWaysMap = mutableMapOf<Long, Int>()
        for (m in 1L..mMax) {
            for (n in 1L until m) {
                if ((m + n) % 2 != 1L) {
                    continue
                }
                if (numericalCalculator.gcd(m, n) != 1L) {
                    continue
                }
                val a = m * m - n * n
                val b = 2 * m * n
                val c = m * m + n * n
                val l = a + b + c
                if (l <= bound) {
                    for (i in 1..bound / l) {
                        val il = i * l
                        if (lToWaysMap.keys.contains(il)) {
                            lToWaysMap[il] = lToWaysMap[il]!! + 1
                        } else {
                            lToWaysMap[il] = 1
                        }
                    }
                }
            }
        }
        return lToWaysMap.values.filter { it == 1 }.size.toString()
    }
}
