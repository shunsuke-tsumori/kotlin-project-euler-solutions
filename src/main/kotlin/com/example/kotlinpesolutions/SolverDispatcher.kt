/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions

import com.example.kotlinpesolutions.solver.q1_100.Q1Solver
import com.example.kotlinpesolutions.solver.q1_100.Q2Solver
import com.example.kotlinpesolutions.solver.q1_100.Q3Solver
import com.example.kotlinpesolutions.solver.q1_100.Q4Solver
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class SolverDispatcher(
    private val q1Solver: Q1Solver,
    private val q2Solver: Q2Solver,
    private val q3Solver: Q3Solver,
    private val q4Solver: Q4Solver,
    @Value("\${problem}") val problem: Int
) {
    fun run() {
        when (problem) {
            1 -> q1Solver.run()
            2 -> q2Solver.run()
            3 -> q3Solver.run()
            4 -> q4Solver.run()
            else -> println("not yet solved")
        }
    }
}
