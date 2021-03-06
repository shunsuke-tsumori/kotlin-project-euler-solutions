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
class P006Solver : ProjectEulerSolver {
    override fun run(): String {
        val max = 100
        var sum = 0L
        //(Σ_i i)^2 - Σ_i (i^2) = 2 * Σ_i≠j (i*j)
        for (i in 1..max) {
            for (j in i + 1..max) {
                sum += 2 * i * j
            }
        }
        return sum.toString()
    }
}
