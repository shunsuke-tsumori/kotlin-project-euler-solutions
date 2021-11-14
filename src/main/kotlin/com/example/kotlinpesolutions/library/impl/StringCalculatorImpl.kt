/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.library.impl

import com.example.kotlinpesolutions.library.StringCalculator
import org.springframework.stereotype.Component

@Component
class StringCalculatorImpl : StringCalculator {
    override fun isPalindrome(string: String): Boolean {
        val length = string.length
        for (i in 0..(length / 2)) {
            if (string[i] != string[length - 1 - i]) {
                return false
            }
        }
        return true
    }

    override fun isPandigital(digitString: String, n: Int): Boolean {
        if (n != digitString.length) {
            return false
        }
        for (i in 1..9) {
            if (!digitString.contains(i.toString())) {
                return false
            }
        }
        return true
    }

    override fun alphabeticalValue(string: String): Int {
        val baseByte = 'A'.code.toByte() - 1
        return string.toByteArray().sumOf { c -> c - baseByte }
    }

    override fun isPermutation(string1: String, string2: String): Boolean {
        if (string1.length != string2.length) {
            return false
        }
        val sorted1 = string1.map { it }.sortedBy { it }
        val sorted2 = string2.map { it }.sortedBy { it }
        for (i in sorted1.indices) {
            if (sorted1[i] != sorted2[i]) {
                return false
            }
        }
        return true
    }
}
