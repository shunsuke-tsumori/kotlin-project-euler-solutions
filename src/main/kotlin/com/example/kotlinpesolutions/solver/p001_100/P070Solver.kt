/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.NumericalCalculator
import com.example.kotlinpesolutions.library.StringCalculator
import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.stereotype.Component

@Component
class P070Solver(
    private val numericalCalculator: NumericalCalculator,
    private val stringCalculator: StringCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        val bound = 10_000_000
        var minRatio = 100.0
        var minProducer = 0
        for (n in 2 until bound) {
            val phi = numericalCalculator.totient(n)
            if (stringCalculator.isPermutation(n.toString(), phi.toString())) {
                val ratio = n.toDouble() / phi
                if (ratio < minRatio) {
                    minRatio = ratio
                    minProducer = n
                }
            }
        }
        return minProducer.toString()
    }
}
