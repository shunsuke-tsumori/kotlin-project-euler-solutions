package com.example.kotlinpesolutions

import com.example.kotlinpesolutions.solver.Q1Solver
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class SolverDispatcher(
    private val q1Solver: Q1Solver,
    @Value("\${problem}") val problem: Int
) {
    fun run() {
        when (problem) {
            1 -> q1Solver.run()
            else -> println("not yet solved")
        }
    }
}
