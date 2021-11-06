/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.stereotype.Component

@Component
class P092Solver : ProjectEulerSolver {
    override fun run(): String {
        var count = 0
        val bound = 10_000_000
        for (i in 1..bound) {
            if (isArrive89(i)) {
                count++
            }
        }
        return count.toString()
    }

    private fun isArrive89(n: Int): Boolean {
        return when (n) {
            1 -> {
                false
            }
            89 -> {
                true
            }
            else -> {
                isArrive89(sumSquareOfDigits(n))
            }
        }
    }

    private fun sumSquareOfDigits(n: Int): Int {
        var nDivided = n
        var sum = 0
        while (nDivided > 0) {
            val d = nDivided % 10
            sum += d * d
            nDivided /= 10
        }
        return sum
    }
}
