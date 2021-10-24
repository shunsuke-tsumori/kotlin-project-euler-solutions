/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.q1_100

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class Q5SolverTest(
    @Autowired private val q5Solver: Q5Solver
) {

    @Test
    fun test_calculate() {
        assertEquals(232792560L, q5Solver.calculate())
    }
}
