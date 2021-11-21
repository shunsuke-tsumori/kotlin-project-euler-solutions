/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.PolygonCalculator
import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.stereotype.Component

@Component
class P045Solver(
    private val polygonCalculator: PolygonCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        var n = 144
        while (true) {
            val hex = polygonCalculator.hexagonal(n)
            if (polygonCalculator.isTriangle(hex) && polygonCalculator.isPentagonal(hex)) {
                return hex.toString()
            }
            n++
        }
    }
}
