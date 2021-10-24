package com.example.kotlinpesolutions.library

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */
@SpringBootTest
internal class CommonAlgorithmNumericalCalculatorTest(
    @Autowired private val commonAlgorithmNumericalCalculator: CommonAlgorithmNumericalCalculator
) {
    @Test
    fun test_gcd1() {
        assertEquals(3L, commonAlgorithmNumericalCalculator.gcd(15L, 6L))
    }

    @Test
    fun test_gcd2() {
        assertEquals(6L, commonAlgorithmNumericalCalculator.gcd(18L, 6L))
    }

    @Test
    fun test_gcd3() {
        assertEquals(1L, commonAlgorithmNumericalCalculator.gcd(17L, 6L))
    }

    @Test
    fun test_gcd4() {
        assertEquals(3L, commonAlgorithmNumericalCalculator.gcd(6L, 15L))
    }

    @Test
    fun test_gcd5() {
        assertEquals(6L, commonAlgorithmNumericalCalculator.gcd(6L, 6L))
    }
}
