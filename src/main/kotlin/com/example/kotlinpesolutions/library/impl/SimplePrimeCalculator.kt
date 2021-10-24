/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.library.impl

import com.example.kotlinpesolutions.library.PrimeCalculator
import org.springframework.stereotype.Component

@Component
class SimplePrimeCalculator : PrimeCalculator {
    override fun primeListBelow(bound: Long): List<Long> {
        if (bound < 2) {
            return listOf()
        }
        val primeList = mutableListOf(2L)
        for (i in 3..bound step 2) {
            if (!isDividedByAny(primeList, i)) {
                primeList.add(i)
            }
        }
        return primeList
    }

    override fun findNthPrime(n: Int): Long {
        if (n < 1) {
            throw IllegalArgumentException("n must be positive")
        }
        val primeList = mutableListOf<Long>()
        primeList.add(2)
        var currentNum = 3L

        while (primeList.size < n) {
            if (!isDividedByAny(primeList, currentNum)) {
                primeList.add(currentNum)
            }
            currentNum += 2
        }
        return primeList[n - 1]
    }


    private fun isDividedByAny(primeList: List<Long>, target: Long): Boolean {
        for (prime in primeList) {
            if (prime * prime > target) {
                break
            }
            if (target % prime == 0L) {
                return true
            }
        }
        return false
    }
}
