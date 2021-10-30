/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.library.impl

import com.example.kotlinpesolutions.library.DivisorCalculator
import org.springframework.stereotype.Component
import kotlin.math.pow

@Component
class SimpleDivisorCalculator : DivisorCalculator {
    override fun divisorSet(n: Long): Set<Long> {
        if (n < 1) {
            throw IllegalArgumentException()
        }
        val divisorSet = mutableSetOf<Long>()

        for (i in 1..n / 2) {
            if (n % i == 0L) {
                divisorSet.add(i)
            }
        }
        divisorSet.add(n)

        return divisorSet
    }

    // TODO refactor
    override fun primeFactorization(n: Long): Map<Long, Int> {
        var nSub = n
        val factorialMap = mutableMapOf<Long, Int>()

        val i2 = calcIndex(nSub, 2)
        if (i2 != 0) {
            factorialMap[2L] = i2
            nSub /= 2.0.pow(i2).toLong()
        }
        var current = 3L
        while (nSub > 1) {
            if (current * current > nSub) {
                break
            }
            val iCurrent = calcIndex(nSub, current)
            if (iCurrent != 0) {
                factorialMap[current] = iCurrent
                nSub /= current.toDouble().pow(iCurrent).toLong()
            }
            current += 2
        }
        if (nSub != 1L) {
            factorialMap[nSub] = 1
        }
        return factorialMap
    }

    private fun calcIndex(n: Long, divisor: Long): Int {
        var nSub = n
        var i = 0
        while (nSub % divisor == 0L) {
            i++
            nSub /= divisor
        }
        return i
    }

    override fun divisorNumber(n: Long): Int {
        val factorialMap = primeFactorization(n)
        var nDivisor = 1
        for (prime in factorialMap.keys) {
            nDivisor *= (factorialMap[prime]!! + 1)
        }
        return nDivisor
    }
}
