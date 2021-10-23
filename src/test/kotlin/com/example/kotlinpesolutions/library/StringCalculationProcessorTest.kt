/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.library

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class StringCalculationProcessorTest(
    @Autowired private val stringCalculationProcessor: StringCalculationProcessor
) {

    @Test
    fun test_isPalindrome1() {
        assertTrue(stringCalculationProcessor.isPalindrome("101"))
    }

    @Test
    fun test_isPalindrome2() {
        assertTrue(stringCalculationProcessor.isPalindrome("1001"))
    }

    @Test
    fun test_isPalindrome3() {
        assertFalse(stringCalculationProcessor.isPalindrome("201"))
    }

    @Test
    fun test_isPalindrome4() {
        assertFalse(stringCalculationProcessor.isPalindrome("2001"))
    }

    @Test
    fun test_isPalindrome5() {
        assertFalse(stringCalculationProcessor.isPalindrome("1021"))
    }
}
