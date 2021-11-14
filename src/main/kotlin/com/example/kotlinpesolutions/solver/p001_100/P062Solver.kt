/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.StringCalculator
import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.stereotype.Component

@Component
class P062Solver(
    private val stringCalculator: StringCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        var n = 1
        val target = 5

        while (true) {
            if (countPermutations(n) == target) {
                return triple(n).toString()
            }
            n++
        }
    }

    private fun countPermutations(n: Int): Int {
        var count = 1
        val baseTriple = triple(n)
        val maxTriple = baseTriple
            .toString()
            .map { it.digitToInt().toLong() }
            .sorted()
            .reversed()
            .reduce { sum, elem -> sum * 10 + elem }

        var m = n + 1
        while (true) {
            val mTriple = triple(m)
            if (mTriple > maxTriple) {
                break
            }
            if (stringCalculator.isPermutation(baseTriple.toString(), mTriple.toString())) {
                count++
            }
            m++
        }
        return count
    }

    private fun triple(n: Int): Long {
        return n.toLong() * n * n
    }
}
