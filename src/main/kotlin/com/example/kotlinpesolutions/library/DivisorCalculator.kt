/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.library

interface DivisorCalculator {
    fun divisorSet(n: Long): Set<Long>
    fun divisorNumber(n: Long): Int
    fun primeFactorization(n: Long): Map<Long, Int>
    fun sumProperDivisors(n: Int): Int
}
