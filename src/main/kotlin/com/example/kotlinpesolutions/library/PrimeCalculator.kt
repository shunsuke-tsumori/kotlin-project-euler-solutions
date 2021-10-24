/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.library

interface PrimeCalculator {
    /**
     * returns list of primes whose value is less than or equal to [bound]
     */
    fun primeListBelow(bound: Long): List<Long>

    /**
     * returns the n-th prime
     */
    fun findNthPrime(n: Int): Long
}
