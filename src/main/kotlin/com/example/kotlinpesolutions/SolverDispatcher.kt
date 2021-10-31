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
    private val p067Solver: P067Solver,
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
            67 -> println(p067Solver.run())
            else -> println("not yet solved")
        }
    }
}
