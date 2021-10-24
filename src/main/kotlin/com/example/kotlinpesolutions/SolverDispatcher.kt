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
    @Value("\${problem}") val problem: Int
) {
    fun run() {
        println("problem: $problem")
        when (problem) {
            1 -> p001Solver.run()
            2 -> p002Solver.run()
            3 -> p003Solver.run()
            4 -> p004Solver.run()
            5 -> p005Solver.run()
            6 -> p006Solver.run()
            7 -> p007Solver.run()
            8 -> p008Solver.run()
            9 -> p009Solver.run()
            10 -> p010Solver.run()
            11 -> p011Solver.run()
            else -> println("not yet solved")
        }
    }
}
