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
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class StringCalculationProcessorTest(
    @Autowired private val stringCalculationProcessor: StringCalculationProcessor
) {

    @Test
    @DisplayName("isPalindrome('101')")
    fun test_isPalindrome_t1() {
        assertTrue(stringCalculationProcessor.isPalindrome("101"))
    }

    @Test
    @DisplayName("isPalindrome('1001')")
    fun test_isPalindrome_t2() {
        assertTrue(stringCalculationProcessor.isPalindrome("1001"))
    }

    @Test
    @DisplayName("isPalindrome('201')")
    fun test_isPalindrome_f1() {
        assertFalse(stringCalculationProcessor.isPalindrome("201"))
    }

    @Test
    @DisplayName("isPalindrome('2001')")
    fun test_isPalindrome_f2() {
        assertFalse(stringCalculationProcessor.isPalindrome("2001"))
    }

    @Test
    @DisplayName("isPalindrome('1021')")
    fun test_isPalindrome_f3() {
        assertFalse(stringCalculationProcessor.isPalindrome("1021"))
    }
}
