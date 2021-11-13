/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.library.impl

import com.example.kotlinpesolutions.library.DivisorCalculator
import com.example.kotlinpesolutions.library.NumericalCalculator
import org.springframework.stereotype.Component

@Component
class CommonAlgorithmNumericalCalculator(
    private val divisorCalculator: DivisorCalculator
) : NumericalCalculator {
    override fun gcd(a: Long, b: Long): Long {
        return euclideanAlgorithm(a, b)
    }

    override fun gcd(a: Int, b: Int): Int {
        return euclideanAlgorithm(a.toLong(), b.toLong()).toInt()
    }

    override fun totient(n: Int): Int {
        var phi = n
        val factors = divisorCalculator.primeFactorization(n.toLong()).keys.map { f -> f.toInt() }
        for (factor in factors) {
            phi = phi / factor * (factor - 1)
        }
        return phi
    }

    private fun euclideanAlgorithm(a: Long, b: Long): Long {
        var a1 = a
        var a2 = b
        if (a < b) {
            a1 = b
            a2 = a
        }
        val c = a1 % a2
        if (c == 0L) {
            return a2
        }
        return euclideanAlgorithm(a2, c)
    }
}
