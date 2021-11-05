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
class P032Solver(
    private val listCalculator: ListCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        val productSet = mutableSetOf<Int>()
        val permutations = listCalculator.permutations(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9))
        for (p in permutations) {
            for (i in 1..2) {
                val a = toNum(p.subList(0, i))
                for (j in 3..4) {
                    val b = toNum(p.subList(i, i + j))
                    val c = toNum(p.subList(i + j, p.size))
                    if (a < b && a * b == c) {
                        productSet.add(c)
                    }
                }
            }
        }
        return productSet.sum().toString()
    }

    private fun toNum(numList: List<Int>): Int {
        var num = 0
        for (n in numList) {
            num *= 10
            num += n
        }
        return num
    }
}
