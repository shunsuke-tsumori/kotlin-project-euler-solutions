/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions

import com.example.kotlinpesolutions.solver.p001_100.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class SolverDispatcher(
    private val p001Solver: P001Solver,
    private val p002Solver: P002Solver,
    private val p003Solver: P003Solver,
    private val p004Solver: P004Solver,
    private val p005Solver: P005Solver,
    private val p006Solver: P006Solver,
    private val p007Solver: P007Solver,
    private val p008Solver: P008Solver,
    private val p009Solver: P009Solver,
    private val p010Solver: P010Solver,
    private val p011Solver: P011Solver,
    private val p012Solver: P012Solver,
    private val p013Solver: P013Solver,
    private val p014Solver: P014Solver,
    private val p015Solver: P015Solver,
    private val p016Solver: P016Solver,
    private val p017Solver: P017Solver,
    private val p018Solver: P018Solver,
    private val p019Solver: P019Solver,
    private val p020Solver: P020Solver,
    private val p021Solver: P021Solver,
    private val p022Solver: P022Solver,
    private val p023Solver: P023Solver,
    private val p024Solver: P024Solver,
    private val p025Solver: P025Solver,
    private val p026Solver: P026Solver,
    private val p027Solver: P027Solver,
    private val p028Solver: P028Solver,
    private val p029Solver: P029Solver,
    private val p030Solver: P030Solver,
    private val p031Solver: P031Solver,
    private val p032Solver: P032Solver,
    private val p033Solver: P033Solver,
    private val p034Solver: P034Solver,
    private val p035Solver: P035Solver,
    private val p036Solver: P036Solver,
    private val p037Solver: P037Solver,
    private val p038Solver: P038Solver,
    private val p039Solver: P039Solver,
    private val p040Solver: P040Solver,
    private val p041Solver: P041Solver,
    private val p042Solver: P042Solver,
    private val p043Solver: P043Solver,
    private val p044Solver: P044Solver,
    private val p045Solver: P045Solver,
    private val p046Solver: P046Solver,
    private val p047Solver: P047Solver,
    private val p048Solver: P048Solver,
    private val p049Solver: P049Solver,
    private val p050Solver: P050Solver,
    private val p067Solver: P067Solver,
    private val p092Solver: P092Solver,
    private val p097Solver: P097Solver,
    @Value("\${problem}") val problem: Int
) {
    fun run() {
        println("problem: $problem")
        when (problem) {
            1 -> println(p001Solver.run())
            2 -> println(p002Solver.run())
            3 -> println(p003Solver.run())
            4 -> println(p004Solver.run())
            5 -> println(p005Solver.run())
            6 -> println(p006Solver.run())
            7 -> println(p007Solver.run())
            8 -> println(p008Solver.run())
            9 -> println(p009Solver.run())
            10 -> println(p010Solver.run())
            11 -> println(p011Solver.run())
            12 -> println(p012Solver.run())
            13 -> println(p013Solver.run())
            14 -> println(p014Solver.run())
            15 -> println(p015Solver.run())
            16 -> println(p016Solver.run())
            17 -> println(p017Solver.run())
            18 -> println(p018Solver.run())
            19 -> println(p019Solver.run())
            20 -> println(p020Solver.run())
            21 -> println(p021Solver.run())
            22 -> println(p022Solver.run())
            23 -> println(p023Solver.run())
            24 -> println(p024Solver.run())
            25 -> println(p025Solver.run())
            26 -> println(p026Solver.run())
            27 -> println(p027Solver.run())
            28 -> println(p028Solver.run())
            29 -> println(p029Solver.run())
            30 -> println(p030Solver.run())
            31 -> println(p031Solver.run())
            32 -> println(p032Solver.run())
            33 -> println(p033Solver.run())
            34 -> println(p034Solver.run())
            35 -> println(p035Solver.run())
            36 -> println(p036Solver.run())
            37 -> println(p037Solver.run())
            38 -> println(p038Solver.run())
            39 -> println(p039Solver.run())
            40 -> println(p040Solver.run())
            41 -> println(p041Solver.run())
            42 -> println(p042Solver.run())
            43 -> println(p043Solver.run())
            44 -> println(p044Solver.run())
            45 -> println(p045Solver.run())
            46 -> println(p046Solver.run())
            47 -> println(p047Solver.run())
            48 -> println(p048Solver.run())
            49 -> println(p049Solver.run())
            50 -> println(p050Solver.run())
            67 -> println(p067Solver.run())
            92 -> println(p092Solver.run())
            97 -> println(p097Solver.run())
            else -> println("not yet solved")
        }
    }
}
