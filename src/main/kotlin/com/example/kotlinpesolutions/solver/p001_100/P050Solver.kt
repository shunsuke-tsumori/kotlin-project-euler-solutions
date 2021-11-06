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
class P050Solver(
    private val primeCalculator: PrimeCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        var maxLength = 0
        var maxLengthPrime = 0
        val bound = 1_000_000
        val primeList = primeCalculator.primeListBelow(bound.toLong())

        for (i in primeList.indices) {
            var candidate = 0
            for (j in i until primeList.size) {
                candidate += primeList[j].toInt()
                if (candidate > bound) {
                    break
                }
                if (primeCalculator.isPrime(candidate) && j - i + 1 > maxLength) {
                    maxLength = j - i + 1
                    maxLengthPrime = candidate
                }
            }
        }

        return maxLengthPrime.toString()
    }
}
