/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class SolversTest(
    @Autowired private val p001Solver: P001Solver,
    @Autowired private val p002Solver: P002Solver,
    @Autowired private val p003Solver: P003Solver,
    @Autowired private val p004Solver: P004Solver,
    @Autowired private val p005Solver: P005Solver,
    @Autowired private val p006Solver: P006Solver,
    @Autowired private val p007Solver: P007Solver,
    @Autowired private val p008Solver: P008Solver,
    @Autowired private val p009Solver: P009Solver,
    @Autowired private val p010Solver: P010Solver,
    @Autowired private val p011Solver: P011Solver,
    @Autowired private val p012Solver: P012Solver,
    @Autowired private val p013Solver: P013Solver,
    @Autowired private val p014Solver: P014Solver,
    @Autowired private val p015Solver: P015Solver,
    @Autowired private val p016Solver: P016Solver,
    @Autowired private val p017Solver: P017Solver,
    @Autowired private val p018Solver: P018Solver,
    @Autowired private val p019Solver: P019Solver,
    @Autowired private val p020Solver: P020Solver,
    @Autowired private val p021Solver: P021Solver,
    @Autowired private val p022Solver: P022Solver,
    @Autowired private val p067Solver: P067Solver,
) {
    @Test
    @DisplayName("233168")
    fun p001() {
        assertEquals(233168, p001Solver.run())
    }

    @Test
    @DisplayName("4613732")
    fun p002() {
        assertEquals(4613732, p002Solver.run())
    }

    @Test
    @DisplayName("6857")
    fun p003() {
        assertEquals(6857, p003Solver.run())
    }

    @Test
    @DisplayName("906609")
    fun p004() {
        assertEquals(906609, p004Solver.run())
    }

    @Test
    @DisplayName("232792560")
    fun p005() {
        assertEquals(232792560, p005Solver.run())
    }

    @Test
    @DisplayName("25164150")
    fun p006() {
        assertEquals(25164150, p006Solver.run())
    }

    @Test
    @DisplayName("104743")
    fun p007() {
        assertEquals(104743, p007Solver.run())
    }

    @Test
    @DisplayName("23514624000")
    fun p008() {
        assertEquals(23514624000, p008Solver.run())
    }

    @Test
    @DisplayName("31875000")
    fun p009() {
        assertEquals(31875000, p009Solver.run())
    }

    @Test
    @DisplayName("142913828922")
    fun p010() {
        assertEquals(142913828922, p010Solver.run())
    }

    @Test
    @DisplayName("70600674")
    fun p011() {
        assertEquals(70600674, p011Solver.run())
    }

    @Test
    @DisplayName("76576500")
    fun p012() {
        assertEquals(76576500, p012Solver.run())
    }

    @Test
    @DisplayName("5537376230")
    fun p013() {
        assertEquals(5537376230, p013Solver.run())
    }

    @Test
    @DisplayName("837799")
    fun p014() {
        assertEquals(837799, p014Solver.run())
    }

    @Test
    @DisplayName("137846528820")
    fun p015() {
        assertEquals(137846528820, p015Solver.run())
    }

    @Test
    @DisplayName("1366")
    fun p016() {
        assertEquals(1366, p016Solver.run())
    }

    @Test
    @DisplayName("21124")
    fun p017() {
        assertEquals(21124, p017Solver.run())
    }

    @Test
    @DisplayName("1074")
    fun p018() {
        assertEquals(1074, p018Solver.run())
    }

    @Test
    @DisplayName("171")
    fun p019() {
        assertEquals(171, p019Solver.run())
    }

    @Test
    @DisplayName("648")
    fun p020() {
        assertEquals(648, p020Solver.run())
    }

    @Test
    @DisplayName("31626")
    fun p021() {
        assertEquals(31626, p021Solver.run())
    }

    @Test
    @DisplayName("871198282")
    fun p022() {
        assertEquals(871198282, p022Solver.run())
    }

    @Test
    @DisplayName("7273")
    fun p067() {
        assertEquals(7273, p067Solver.run())
    }
}
