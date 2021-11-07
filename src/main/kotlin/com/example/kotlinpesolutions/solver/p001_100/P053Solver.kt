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
import java.math.BigInteger

@Component
class P053Solver(
    private val combinationCalculator: CombinationCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        val combinationMemo = combinationCalculator.getCombinationMemo(100)
        val bound = BigInteger.valueOf(1_000_000)
        var count = 0
        for (n in 1..100) {
            for (r in 0..n) {
                if (combinationMemo[Pair(n, r)]!! > bound) {
                    count++
                }
            }
        }
        return count.toString()
    }
}
