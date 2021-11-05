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
class P035Solver(
    private val primeCalculator: PrimeCalculator,
    private val listCalculator: ListCalculator
) : ProjectEulerSolver {
    override fun run(): String {

        return (13 +
                countNDigitsCircularPrimes(3) +
                countNDigitsCircularPrimes(4) +
                countNDigitsCircularPrimes(5) +
                countNDigitsCircularPrimes(6)).toString()
    }

    private fun countNDigitsCircularPrimes(n: Int): Int {
        if (n < 3) {
            throw IllegalArgumentException("n >= 3 とします")
        }
        val digitList = listOf(1, 3, 7, 9)
        val combinations = listCalculator.duplicateCombinations(digitList, n)
        var sum = 0
        combinations.forEach { c ->
            if (isProduceCircularPrime(c)) {
                sum += 1
            }
        }
        return sum
    }

    private fun isProduceCircularPrime(a: List<Int>): Boolean {
        val aList = a.toList()
        for (i in a.indices) {
            val circularList = aList.subList(i, a.size) + aList.subList(0, i)
            if (!primeCalculator.isPrime(toNumber(circularList))) {
                return false
            }
        }
        return true
    }

    private fun toNumber(a: List<Int>): Int {
        return a.reduce { sum, element -> sum * 10 + element }
    }

}
