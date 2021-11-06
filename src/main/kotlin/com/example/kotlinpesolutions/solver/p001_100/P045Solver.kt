/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.HexagonalCalculator
import com.example.kotlinpesolutions.library.PentagonalCalculator
import com.example.kotlinpesolutions.library.TriangleCalculator
import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.stereotype.Component

@Component
class P045Solver(
    private val triangleCalculator: TriangleCalculator,
    private val pentagonalCalculator: PentagonalCalculator,
    private val hexagonalCalculator: HexagonalCalculator,
) : ProjectEulerSolver {
    override fun run(): String {
        var n = 144
        while (true) {
            val hex = hexagonalCalculator.hexagonal(n)
            if (triangleCalculator.isTriangle(hex) && pentagonalCalculator.isPentagonal(hex)) {
                return hex.toString()
            }
            n++
        }
    }
}
