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
class P091Solver : ProjectEulerSolver {
    override fun run(): String {
        val size = 50
        var count = 0
        for (x1 in 0..size) {
            for (y1 in 0..size) {
                for (x2 in 0..size) {
                    for (y2 in 0..size) {
                        if (isTargetTriangle(x1, y1, x2, y2) && isRightTriangle(x1, y1, x2, y2)) {
                            count++
                        }
                    }
                }
            }
        }
        return count.toString()
    }

    // (x1, y1) と (x2, y2) の入れ替わりを区別しない
    private fun isTargetTriangle(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
        return x1 * y2 - x2 * y1 > 0
    }

    private fun isRightTriangle(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
        return x1 * x2 + y1 * y2 == 0
                || x1 * (x2 - x1) + y1 * (y2 - y1) == 0
                || x2 * (x1 - x2) + y2 * (y1 - y2) == 0
    }
}
