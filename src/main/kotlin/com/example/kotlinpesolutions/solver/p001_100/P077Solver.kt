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
class P077Solver(
    private val primeCalculator: PrimeCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        val bound = 5000
        val searchRange = 200_000
        val primeList = primeCalculator.primeListBelow(searchRange.toLong())

        for (n in 2..searchRange) {
            val patterns = Array(n + 1) { 0 }
            patterns[0] = 1
            for (p in primeList) {
                for (j in p.toInt()..n) {
                    patterns[j] += patterns[j - p.toInt()]
                }
            }
            if (patterns[n] > bound) {
                return n.toString()
            }
        }
        return "not found in $searchRange"
    }
}
