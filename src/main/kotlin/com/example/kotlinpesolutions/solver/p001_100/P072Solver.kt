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
class P072Solver(
    private val numericalCalculator: NumericalCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        var sum = 0L
        for (i in 2..1_000_000) {
            sum += numericalCalculator.totient(i)
        }
        return sum.toString()
    }
}
