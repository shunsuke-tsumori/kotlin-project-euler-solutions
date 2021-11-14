/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.library

interface StringCalculator {
    fun isPalindrome(string: String): Boolean

    /**
     * is [digitString] [n]-digit pandigital
     */
    fun isPandigital(digitString: String, n: Int): Boolean

    /**
     * ex) SKY is 19+11+25 = 55
     */
    fun alphabeticalValue(string: String): Int

    fun isPermutation(string1: String, string2: String): Boolean
}
