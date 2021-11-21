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
class P044Solver(
    private val polygonCalculator: PolygonCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        var minDistance = Long.MAX_VALUE
        var i = 2
        while (true) {
            val pI = polygonCalculator.pentagonal(i)
            // pI - p(I-1) > mimDistance
            if (3 * i - 2 > minDistance) {
                break
            }
            for (j in i - 1 downTo 1) {
                val pJ = polygonCalculator.pentagonal(j)
                val distance = pI - pJ
                if (distance > minDistance) {
                    break
                }
                if (polygonCalculator.isPentagonal(distance)
                    && polygonCalculator.isPentagonal(pI + pJ)
                ) {
                    if (distance < minDistance) {
                        minDistance = distance
                    }
                    break
                }
            }
            i++
        }

        return minDistance.toString()
    }
}
