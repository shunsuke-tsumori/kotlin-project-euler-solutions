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
class P041Solver(
    private val primeCalculator: PrimeCalculator,
    private val listCalculator: ListCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        var max = 0
        for (n in 2..9) {
            val permutations = makePermutations(n)
            for (nList in permutations) {
                if (isPrime(nList)) {
                    val value = nList.reduce { num, e -> num * 10 + e }
                    if (value > max) {
                        max = value
                    }
                }
            }
        }
        return max.toString()
    }

    // nList.size >= 2
    private fun isPrime(nList: List<Int>): Boolean {
        val firstPlace = listOf(1, 3, 7, 9)
        if (!firstPlace.contains(nList[nList.size - 1])) {
            return false
        }
        val value = nList.reduce { num, e -> num * 10 + e }
        return primeCalculator.isPrime(value)
    }

    private fun makePermutations(n: Int): List<List<Int>> {
        val nList = mutableListOf<Int>()
        for (i in 1..n) {
            nList.add(i)
        }
        return listCalculator.permutations(nList)
    }
}
