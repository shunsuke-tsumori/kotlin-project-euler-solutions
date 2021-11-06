/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.ListCalculator
import com.example.kotlinpesolutions.library.PrimeCalculator
import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.stereotype.Component

@Component
class P049Solver(
    private val primeCalculator: PrimeCalculator,
    private val listCalculator: ListCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        for (a in 1001..9999 step 2) {
            for (diff in 1..4500) {
                val c = a + 2 * diff
                if (c >= 10000) {
                    break
                }
                val b = a + diff
                if (primeCalculator.isPrime(a) && primeCalculator.isPrime(b) && primeCalculator.isPrime(c)) {
                    val permutations = listCalculator.permutations(a.toString().toList())
                    val bList = b.toString().toList()
                    val cList = c.toString().toList()
                    if (permutations.contains(bList) && permutations.contains(cList)) {
                        if (a != 1487 || diff != 3330) {
                            return a.toString() + b.toString() + c.toString()
                        }
                    }
                }
            }
        }
        return "ERROR"
    }
}
