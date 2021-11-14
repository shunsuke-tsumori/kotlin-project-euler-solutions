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
class P078Solver : ProjectEulerSolver {
    override fun run(): String {
        val p = mutableListOf(1)
        var n = 1

        while (true) {
            val pn = calcPn(n, p)
            if (pn == 0) {
                return n.toString()
            }
            p.add(pn)
            n++
        }
    }

    // partition function
    // p(n) = p(n-1) + p(n-2) - p(n-5) - p(n-7) + ...
    private fun calcPn(n: Int, p: List<Int>): Int {
        var pn = 0
        var k = 1
        var i = 0
        while (k <= n) {
            val sign = if (i % 4 <= 1) 1 else -1
            pn = (pn + sign * p[n - k] + MODULUS) % MODULUS
            i++
            val j = if (i % 2 == 0) i / 2 + 1 else -(i / 2) - 1
            k = j * (3 * j - 1) / 2
        }
        return pn
    }

    companion object {
        private const val MODULUS = 1_000_000
    }
}
