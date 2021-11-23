/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.stereotype.Component

@Component
class P095Solver : ProjectEulerSolver {
    override fun run(): String {
        var maxLength = 0
        var maxProducer = 0
        for (n in 2..UPPER_BOUND) {
            val length = countAmicableChains(n, listOf(n))
            if (length > maxLength) {
                maxLength = length
                maxProducer = n
            }
        }
        return maxProducer.toString()
    }

    private fun countAmicableChains(n: Int, amicableChain: List<Int>): Int {
        val sumDivisors = sumDivisorList[n]
        return if (amicableChain.contains(sumDivisors)) {
            if (sumDivisors == amicableChain[0]) {
                amicableChain.size - amicableChain.indexOf(sumDivisors)
            } else {
                0
            }
        } else if (sumDivisors < amicableChain[0] || sumDivisors > UPPER_BOUND) {
            0
        } else {
            val newChain = amicableChain.toMutableList()
            newChain.add(sumDivisors)
            countAmicableChains(sumDivisors, newChain)
        }
    }

    companion object {
        private const val UPPER_BOUND = 1_000_000
        private var sumDivisorList = calcSumDivisorList()

        private fun calcSumDivisorList(upperBound: Int = UPPER_BOUND): List<Int> {
            val sumDivisorList = mutableListOf(0)
            for (i in 1..upperBound) {
                sumDivisorList.add(1)
            }
            for (i in 2..upperBound) {
                for (j in 2 * i..upperBound step i) {
                    sumDivisorList[j] += i
                }
            }
            return sumDivisorList
        }
    }
}
