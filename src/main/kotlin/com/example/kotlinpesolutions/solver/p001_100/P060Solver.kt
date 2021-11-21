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
class P060Solver(
    private val primeCalculator: PrimeCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        val bound = 10000
        val primeList = primeCalculator.primeListBelow(bound.toLong()).map { it.toInt() }
        val candidatePrimeList = primeList.toMutableList()
        candidatePrimeList.remove(2)
        candidatePrimeList.remove(5)
        var min = Int.MAX_VALUE
        for (lowestIndex in candidatePrimeList.indices) {
            val answerCreek = getCreek(candidatePrimeList, setOf(candidatePrimeList[lowestIndex]), lowestIndex + 1)
            if (answerCreek.size == CREEK_SIZE) {
                val value = answerCreek.sum()
                if (value < min) {
                    min = value
                }
            }
        }
        return min.toString()
    }

    //TODO refactor and optimize
    private fun getCreek(candidatePrimeList: List<Int>, creekSet: Set<Int>, lowestIndex: Int): Set<Int> {
        if (creekSet.size == CREEK_SIZE) {
            return creekSet
        }
        for (index in lowestIndex until candidatePrimeList.size) {
            var isMatch = true
            val p = candidatePrimeList[index]
            for (reservedPrime in creekSet) {
                isMatch = isMatchPrimes(reservedPrime, p)
                if (!isMatch) {
                    break
                }
            }
            if (isMatch) {
                val nextSet = creekSet.toMutableSet()
                nextSet.add(p)
                val creek = getCreek(candidatePrimeList, nextSet, index + 1)
                if (creek.size == CREEK_SIZE) {
                    return creek
                }
            }
        }
        return setOf()
    }

    private fun isMatchPrimes(p1: Int, p2: Int): Boolean {
        val concat1 = (p1.toString() + p2.toString()).toLong()
        if (!primeCalculator.isPrime(concat1)) {
            return false
        }
        val concat2 = (p2.toString() + p1.toString()).toLong()
        if (!primeCalculator.isPrime(concat2)) {
            return false
        }
        return true
    }

    companion object {
        private const val CREEK_SIZE = 5
    }
}
