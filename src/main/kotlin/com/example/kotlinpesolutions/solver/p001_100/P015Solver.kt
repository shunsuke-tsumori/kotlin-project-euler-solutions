/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.CombinationCalculator
import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.stereotype.Component

@Component
class P015Solver(
    private val combinationCalculator: CombinationCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        val combinationMemo = combinationCalculator.getCombinationMemo(40)
        return combinationMemo[Pair(40, 20)].toString()
    }
}
