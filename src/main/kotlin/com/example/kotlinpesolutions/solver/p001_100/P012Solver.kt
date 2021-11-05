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
class P012Solver(
    private val divisorCalculator: DivisorCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        val bound = 500
        var triangle = 1L
        var diff = 1
        while (divisorCalculator.divisorNumber(triangle) <= bound) {
            diff++
            triangle += diff
        }
        return triangle.toString()
    }
}
