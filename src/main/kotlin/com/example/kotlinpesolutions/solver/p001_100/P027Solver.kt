/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.PrimeCalculator
import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.stereotype.Component

@Component
class P027Solver(
    private val primeCalculator: PrimeCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        var max = 0
        var theProduct = 0

        for (a in -999..999) {
            for (b in 2..1000) {
                if (!primeCalculator.isPrime(b)) {
                    continue
                }
                for (n in 0 until b) {
                    val value = n * n + a * n + b
                    if (!primeCalculator.isPrime(value)) {
                        if (n > max) {
                            max = n
                            theProduct = a * b
                        }
                        break
                    }
                }
            }
        }
        return theProduct.toString()
    }
}
