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
class P058Solver(
    private val primeCalculator: PrimeCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        var nPrimes = 0
        var n = 0
        do {
            n++
            for (i in 0..6 step 2) {
                val value = (2 * n + 1) * (2 * n + 1) - i * n
                if (primeCalculator.isPrime(value)) {
                    nPrimes++
                }
            }
        } while (nPrimes * 10 >= 4 * n + 1)
        return (2 * n + 1).toString()
    }
}
