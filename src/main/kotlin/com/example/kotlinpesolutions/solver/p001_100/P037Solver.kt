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
class P037Solver(
    private val primeCalculator: PrimeCalculator,
    private val listCalculator: ListCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        return solve().toString()
    }

    private fun solve(): Int {
        val head = listOf(2, 3, 5, 7)
        val body = listOf(1, 3, 7, 9)
        val tail = listOf(3, 7)

        // 23, 37, 53, 73は既知とする
        var count = 4
        var bodyLength = 1
        var sum = 186
        while (true) {
            val bodyPatterns = listCalculator.duplicateCombinations(body, bodyLength)
            for (b in bodyPatterns) {
                for (h in head) {
                    for (t in tail) {
                        val numberList = listOf(h).plus(b).plus(t)
                        if (isTruncatable(numberList)) {
                            val value = numberList.reduce { v, e -> v * 10 + e }
                            sum += value
                            count++
                            if (count == 11) {
                                return sum
                            }
                        }
                    }
                }
            }
            bodyLength++
        }
    }

    private fun isTruncatable(numberList: List<Int>): Boolean {
        for (i in 1..numberList.size) {
            val num1 = numberList.subList(0, i).reduce { acc, e -> acc * 10 + e }
            if (!primeCalculator.isPrime(num1)) {
                return false
            }
            val num2 = numberList.subList(i - 1, numberList.size).reduce { acc, e -> acc * 10 + e }
            if (!primeCalculator.isPrime(num2)) {
                return false
            }
        }
        return true
    }
}
