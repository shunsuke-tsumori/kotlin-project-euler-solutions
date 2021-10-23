/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.library

import org.springframework.stereotype.Component

/**
 * a kind of utility class for strings
 */
@Component
class StringCalculationProcessor {
    fun isPalindrome(string: String): Boolean {
        val length = string.length
        for (i in 0..(length / 2)) {
            if (string[i] != string[length - 1 - i]) {
                return false
            }
        }
        return true
    }
}
