/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.DivisorCalculator
import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.stereotype.Component

@Component
class P023Solver(
    private val divisorCalculator: DivisorCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        val bound = 28123
        val abundantList = mutableListOf<Long>()
        for (i in 2..bound) {
            val d = divisorCalculator.sumProperDivisors(i)
            if (i < d) {
                abundantList.add(i.toLong())
            }
        }
        val sumOfTwoSet = mutableSetOf<Long>()
        for (a in abundantList) {
            for (b in abundantList) {
                val sum = a + b
                if (sum > bound) {
                    break
                }
                sumOfTwoSet.add(sum)
            }
        }
        return (bound * (bound + 1) / 2 - sumOfTwoSet.sum()).toString()
    }
}
