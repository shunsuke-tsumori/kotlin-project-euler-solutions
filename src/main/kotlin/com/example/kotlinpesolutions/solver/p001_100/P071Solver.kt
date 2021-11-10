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

@Component
class P071Solver : ProjectEulerSolver {
    override fun run(): String {
        val bound = 1_000_000
        val value3over7 = 3.0 / 7
        var minDiff = 1.0
        var nOfMin = 0
        for (d in 2..bound) {
            var n = d / 7 * 3
            while (true) {
                val value = n.toDouble() / d
                if (value >= value3over7) {
                    break
                }
                val diff = value3over7 - value
                if (diff < minDiff) {
                    minDiff = diff
                    nOfMin = n
                }
                n++
            }
        }
        return nOfMin.toString()
    }
}
