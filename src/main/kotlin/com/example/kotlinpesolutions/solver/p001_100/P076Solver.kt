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
class P076Solver : ProjectEulerSolver {
    override fun run(): String {
        // nをk以下で表現するパターン数を考える。
        // 1文字で表現するパターンも含む。
        val size = 100
        val patterns = Array(size + 1) { arrayOfNulls<Long>(size + 1) }
        for (n in 1..size) {
            for (k in 1..size) {
                if (k == 1) {
                    patterns[n][k] = 1
                } else if (k > n) {
                    patterns[n][k] = patterns[n][n]
                } else if (k == n) {
                    patterns[n][k] = patterns[n][k - 1]!! + 1
                } else {
                    patterns[n][k] = patterns[n][k - 1]!! + patterns[n - k][k]!!
                }
            }
        }
        return patterns[size][size - 1].toString()
    }
}
