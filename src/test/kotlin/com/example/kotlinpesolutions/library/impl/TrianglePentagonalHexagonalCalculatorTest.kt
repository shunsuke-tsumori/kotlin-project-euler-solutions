/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.library.impl

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class TrianglePentagonalHexagonalCalculatorTest(
    @Autowired private val target: TrianglePentagonalHexagonalCalculator
) {
    @Test
    fun test_isTriangle() {
        for (i in 1..1000) {
            assertTrue(target.isTriangle(target.triangle(i)))
        }
    }

    @Test
    fun test_isPentagonal() {
        for (i in 1..1000) {
            assertTrue(target.isPentagonal(target.pentagonal(i)))
        }
    }

    @Test
    fun test_isHexagonal() {
        for (i in 1..1000) {
            assertTrue(target.isHexagonal(target.hexagonal(i)))
        }
    }
}
