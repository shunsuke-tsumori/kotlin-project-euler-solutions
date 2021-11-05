/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.ListCalculator
import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.stereotype.Component

@Component
class P024Solver(
    private val listCalculator: ListCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        val numList = listOf(0L, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        val permutationsList = listCalculator.permutations(numList)
        return permutationsList[1_000_000 - 1].reduce { sum, element -> sum * 10 + element }.toString()
    }
}
