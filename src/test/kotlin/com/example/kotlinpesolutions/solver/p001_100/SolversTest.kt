/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import org.junit.jupiter.api.Assertions.assertEquals
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
    @Autowired private val p023Solver: P023Solver,
    @Autowired private val p024Solver: P024Solver,
    @Autowired private val p025Solver: P025Solver,
    @Autowired private val p026Solver: P026Solver,
    @Autowired private val p027Solver: P027Solver,
    @Autowired private val p028Solver: P028Solver,
    @Autowired private val p029Solver: P029Solver,
    @Autowired private val p030Solver: P030Solver,
    @Autowired private val p031Solver: P031Solver,
    @Autowired private val p032Solver: P032Solver,
    @Autowired private val p033Solver: P033Solver,
    @Autowired private val p034Solver: P034Solver,
    @Autowired private val p035Solver: P035Solver,
    @Autowired private val p036Solver: P036Solver,
    @Autowired private val p037Solver: P037Solver,
    @Autowired private val p038Solver: P038Solver,
    @Autowired private val p039Solver: P039Solver,
    @Autowired private val p040Solver: P040Solver,
    @Autowired private val p041Solver: P041Solver,
    @Autowired private val p042Solver: P042Solver,
    @Autowired private val p043Solver: P043Solver,
    @Autowired private val p044Solver: P044Solver,
    @Autowired private val p045Solver: P045Solver,
    @Autowired private val p046Solver: P046Solver,
    @Autowired private val p047Solver: P047Solver,
    @Autowired private val p048Solver: P048Solver,
    @Autowired private val p049Solver: P049Solver,
    @Autowired private val p050Solver: P050Solver,
    @Autowired private val p052Solver: P052Solver,
    @Autowired private val p053Solver: P053Solver,
    @Autowired private val p054Solver: P054Solver,
    @Autowired private val p055Solver: P055Solver,
    @Autowired private val p056Solver: P056Solver,
    @Autowired private val p057Solver: P057Solver,
    @Autowired private val p058Solver: P058Solver,
    @Autowired private val p059Solver: P059Solver,
    @Autowired private val p063Solver: P063Solver,
    @Autowired private val p067Solver: P067Solver,
    @Autowired private val p069Solver: P069Solver,
    @Autowired private val p071Solver: P071Solver,
    @Autowired private val p073Solver: P073Solver,
    @Autowired private val p074Solver: P074Solver,
    @Autowired private val p076Solver: P076Solver,
    @Autowired private val p078Solver: P078Solver,
    @Autowired private val p079Solver: P079Solver,
    @Autowired private val p081Solver: P081Solver,
    @Autowired private val p092Solver: P092Solver,
    @Autowired private val p097Solver: P097Solver,
    @Autowired private val p099Solver: P099Solver,
) {

    @Test
    @DisplayName("233168")
    fun p001() {
        assertEquals("233168", p001Solver.run())
    }

    @Test
    @DisplayName("4613732")
    fun p002() {
        assertEquals("4613732", p002Solver.run())
    }

    @Test
    @DisplayName("6857")
    fun p003() {
        assertEquals("6857", p003Solver.run())
    }

    @Test
    @DisplayName("906609")
    fun p004() {
        assertEquals("906609", p004Solver.run())
    }

    @Test
    @DisplayName("232792560")
    fun p005() {
        assertEquals("232792560", p005Solver.run())
    }

    @Test
    @DisplayName("25164150")
    fun p006() {
        assertEquals("25164150", p006Solver.run())
    }

    @Test
    @DisplayName("104743")
    fun p007() {
        assertEquals("104743", p007Solver.run())
    }

    @Test
    @DisplayName("23514624000")
    fun p008() {
        assertEquals("23514624000", p008Solver.run())
    }

    @Test
    @DisplayName("31875000")
    fun p009() {
        assertEquals("31875000", p009Solver.run())
    }

    @Test
    @DisplayName("142913828922")
    fun p010() {
        assertEquals("142913828922", p010Solver.run())
    }

    @Test
    @DisplayName("70600674")
    fun p011() {
        assertEquals("70600674", p011Solver.run())
    }

    @Test
    @DisplayName("76576500")
    fun p012() {
        assertEquals("76576500", p012Solver.run())
    }

    @Test
    @DisplayName("5537376230")
    fun p013() {
        assertEquals("5537376230", p013Solver.run())
    }

    @Test
    @DisplayName("837799")
    fun p014() {
        assertEquals("837799", p014Solver.run())
    }

    @Test
    @DisplayName("137846528820")
    fun p015() {
        assertEquals("137846528820", p015Solver.run())
    }

    @Test
    @DisplayName("1366")
    fun p016() {
        assertEquals("1366", p016Solver.run())
    }

    @Test
    @DisplayName("21124")
    fun p017() {
        assertEquals("21124", p017Solver.run())
    }

    @Test
    @DisplayName("1074")
    fun p018() {
        assertEquals("1074", p018Solver.run())
    }

    @Test
    @DisplayName("171")
    fun p019() {
        assertEquals("171", p019Solver.run())
    }

    @Test
    @DisplayName("648")
    fun p020() {
        assertEquals("648", p020Solver.run())
    }

    @Test
    @DisplayName("31626")
    fun p021() {
        assertEquals("31626", p021Solver.run())
    }

    @Test
    @DisplayName("871198282")
    fun p022() {
        assertEquals("871198282", p022Solver.run())
    }

    @Test
    @DisplayName("4179871")
    fun p023() {
        assertEquals("4179871", p023Solver.run())
    }

    @Test
    @DisplayName("2783915460")
    fun p024() {
        assertEquals("2783915460", p024Solver.run())
    }

    @Test
    @DisplayName("4782")
    fun p025() {
        assertEquals("4782", p025Solver.run())
    }

    @Test
    @DisplayName("983")
    fun p026() {
        assertEquals("983", p026Solver.run())
    }

    @Test
    @DisplayName("-59231")
    fun p027() {
        assertEquals("-59231", p027Solver.run())
    }

    @Test
    @DisplayName("669171001")
    fun p028() {
        assertEquals("669171001", p028Solver.run())
    }

    @Test
    @DisplayName("9183")
    fun p029() {
        assertEquals("9183", p029Solver.run())
    }

    @Test
    @DisplayName("443839")
    fun p030() {
        assertEquals("443839", p030Solver.run())
    }

    @Test
    @DisplayName("73682")
    fun p031() {
        assertEquals("73682", p031Solver.run())
    }

    @Test
    @DisplayName("45228")
    fun p032() {
        assertEquals("45228", p032Solver.run())
    }

    @Test
    @DisplayName("100")
    fun p033() {
        assertEquals("100", p033Solver.run())
    }

    @Test
    @DisplayName("40730")
    fun p034() {
        assertEquals("40730", p034Solver.run())
    }

    @Test
    @DisplayName("55")
    fun p035() {
        assertEquals("55", p035Solver.run())
    }

    @Test
    @DisplayName("872187")
    fun p036() {
        assertEquals("872187", p036Solver.run())
    }

    @Test
    @DisplayName("748317")
    fun p037() {
        assertEquals("748317", p037Solver.run())
    }

    @Test
    @DisplayName("932718654")
    fun p038() {
        assertEquals("932718654", p038Solver.run())
    }

    @Test
    @DisplayName("840")
    fun p039() {
        assertEquals("840", p039Solver.run())
    }

    @Test
    @DisplayName("210")
    fun p040() {
        assertEquals("210", p040Solver.run())
    }

    @Test
    @DisplayName("7652413")
    fun p041() {
        assertEquals("7652413", p041Solver.run())
    }

    @Test
    @DisplayName("162")
    fun p042() {
        assertEquals("162", p042Solver.run())
    }

    @Test
    @DisplayName("16695334890")
    fun p043() {
        assertEquals("16695334890", p043Solver.run())
    }

    @Test
    @DisplayName("5482660")
    fun p044() {
        assertEquals("5482660", p044Solver.run())
    }

    @Test
    @DisplayName("1533776805")
    fun p045() {
        assertEquals("1533776805", p045Solver.run())
    }

    @Test
    @DisplayName("5777")
    fun p046() {
        assertEquals("5777", p046Solver.run())
    }

    @Test
    @DisplayName("134043")
    fun p047() {
        assertEquals("134043", p047Solver.run())
    }

    @Test
    @DisplayName("9110846700")
    fun p048() {
        assertEquals("9110846700", p048Solver.run())
    }

    @Test
    @DisplayName("296962999629")
    fun p049() {
        assertEquals("296962999629", p049Solver.run())
    }

    @Test
    @DisplayName("997651")
    fun p050() {
        assertEquals("997651", p050Solver.run())
    }

    @Test
    @DisplayName("142857")
    fun p052() {
        assertEquals("142857", p052Solver.run())
    }

    @Test
    @DisplayName("4075")
    fun p053() {
        assertEquals("4075", p053Solver.run())
    }

    @Test
    @DisplayName("376")
    fun p054() {
        assertEquals("376", p054Solver.run())
    }

    @Test
    @DisplayName("249")
    fun p055() {
        assertEquals("249", p055Solver.run())
    }

    @Test
    @DisplayName("972")
    fun p056() {
        assertEquals("972", p056Solver.run())
    }

    @Test
    @DisplayName("153")
    fun p057() {
        assertEquals("153", p057Solver.run())
    }

    @Test
    @DisplayName("26241")
    fun p058() {
        assertEquals("26241", p058Solver.run())
    }

    @Test
    @DisplayName("129448")
    fun p059() {
        assertEquals("129448", p059Solver.run())
    }

    @Test
    @DisplayName("49")
    fun p063() {
        assertEquals("49", p063Solver.run())
    }

    @Test
    @DisplayName("7273")
    fun p067() {
        assertEquals("7273", p067Solver.run())
    }

    @Test
    @DisplayName("510510")
    fun p069() {
        assertEquals("510510", p069Solver.run())
    }

    @Test
    @DisplayName("428570")
    fun p071() {
        assertEquals("428570", p071Solver.run())
    }

    @Test
    @DisplayName("7295372")
    fun p073() {
        assertEquals("7295372", p073Solver.run())
    }

    @Test
    @DisplayName("402")
    fun p074() {
        assertEquals("402", p074Solver.run())
    }

    @Test
    @DisplayName("190569291")
    fun p076() {
        assertEquals("190569291", p076Solver.run())
    }

    @Test
    @DisplayName("55374")
    fun p078() {
        assertEquals("55374", p078Solver.run())
    }

    @Test
    @DisplayName("73162890")
    fun p079() {
        assertEquals("73162890", p079Solver.run())
    }

    @Test
    @DisplayName("427337")
    fun p081() {
        assertEquals("427337", p081Solver.run())
    }

    @Test
    @DisplayName("8581146")
    fun p092() {
        assertEquals("8581146", p092Solver.run())
    }

    @Test
    @DisplayName("8739992577")
    fun p097() {
        assertEquals("8739992577", p097Solver.run())
    }

    @Test
    @DisplayName("709")
    fun p099() {
        assertEquals("709", p099Solver.run())
    }

}
