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
class P051Solver(
    private val primeCalculator: PrimeCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        val minDigitCandidateList = listOf(0, 1, 2)
        var n = 1
        while (true) {
            if (n % 5 != 0
                && n.toString().any { minDigitCandidateList.contains(it.digitToInt()) }
                && primeCalculator.isPrime(n)
            ) {
                for (i in 0..2) {
                    if (n.toString().any { i == it.digitToInt() }) {
                        val count = countReplacementPrimes(n, i)
                        if (count == 8) {
                            return n.toString()
                        }
                    }
                }
            }
            n += 2
        }
    }

    private fun countReplacementPrimes(n: Int, replacement: Int): Int {
        var count = 0
        val start = if (n.toString()[0] == replacement.digitToChar()) 1 else 0
        for (i in start..9) {
            val num = n.toString().replace(replacement.toString(), i.toString()).toInt()
            if (primeCalculator.isPrime(num)) {
                count++
            }
        }
        return count
    }
}
