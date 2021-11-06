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
class P046Solver(
    private val primeCalculator: PrimeCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        var i = 9
        val oddPrimeList = mutableListOf(3, 5, 7)
        while (true) {
            if (!primeCalculator.isPrime(i)) {
                if (!isMatchGoldbachConjecture(i, oddPrimeList)) {
                    return i.toString()
                }
            } else {
                oddPrimeList.add(i)
            }
            i += 2
        }
    }

    private fun isMatchGoldbachConjecture(number: Int, oddPrimeList: MutableList<Int>): Boolean {
        for (oddPrime in oddPrimeList) {
            var i = 1
            while (true) {
                val primeAndTwiceASquare = 2 * i * i + oddPrime
                if (primeAndTwiceASquare > number) {
                    break
                }
                if (primeAndTwiceASquare == number) {
                    return true
                }
                i++
            }
        }
        return false
    }
}
