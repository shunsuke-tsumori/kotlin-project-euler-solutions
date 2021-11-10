/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.library

interface NumericalCalculator {
    /**
     * greatest common divisor
     */
    fun gcd(a: Long, b: Long): Long
    fun gcd(a: Int, b: Int): Int
}
