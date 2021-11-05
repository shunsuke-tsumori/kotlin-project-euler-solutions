/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.DivisorCalculator
import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.stereotype.Component

@Component
class P021Solver(
    private val divisorCalculator: DivisorCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        val max = 10000
        var sum = 0
        for (i in 2..max) {
            val d1 = divisorCalculator.sumProperDivisors(i)
            if (d1 > i) {
                val d2 = divisorCalculator.sumProperDivisors(d1)
                if (d2 == i) {
                    sum += d1
                    sum += d2
                }
            }
        }
        return sum.toString()
    }
}
