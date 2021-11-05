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
}
