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
class P047Solver(
    private val divisorCalculator: DivisorCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        var i = 1L
        var count = 0
        while (true) {
            val factorMap = divisorCalculator.primeFactorization(i)
            if (factorMap.size == 4) {
                count++
            } else {
                count = 0
            }
            if (count == 4) {
                return (i - 3).toString()
            }
            i++
        }
    }
}
