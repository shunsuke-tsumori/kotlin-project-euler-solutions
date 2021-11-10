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

@Component
class P069Solver(
    private val numericalCalculator: NumericalCalculator,
) : ProjectEulerSolver {
    override fun run(): String {
        var maxN = 0
        var maxNOverTotient = 0.0
        val bound = 1_000_000
        for (n in 2..bound) {
            val totient = numericalCalculator.totient(n)
            val nOverTotient = n.toDouble() / totient
            if (maxNOverTotient < nOverTotient) {
                maxNOverTotient = nOverTotient
                maxN = n
            }
        }
        return maxN.toString()
    }
}
