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
class P039Solver : ProjectEulerSolver {
    override fun run(): String {
        val pMax = 1000
        var nMax = 0
        var maximiser = 0

        for (p in 1..pMax) {
            var count = 0
            for (a in 1..p / 3) {
                for (b in a..p / 2) {
                    val c = p - a - b
                    if (a * a + b * b == c * c) {
                        count++
                    }
                }
            }
            if (count > nMax) {
                nMax = count
                maximiser = p
            }
        }

        return maximiser.toString()
    }
}
