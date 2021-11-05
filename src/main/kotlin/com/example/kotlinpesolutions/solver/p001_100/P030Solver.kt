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
class P030Solver : ProjectEulerSolver {
    override fun run(): String {
        var sum = 0
        // a^5 + ... + f^5 <= 354294 = 6 * 9^5
        for (a in 0..3) {
            for (b in 0..9) {
                for (c in 0..9) {
                    for (d in 0..9) {
                        for (e in 0..9) {
                            for (f in 0..9) {
                                val f1 = f1(a, b, c, d, e, f)
                                val f2 = f2(a, b, c, d, e, f)
                                if (f1 == f2) {
                                    sum += f1
                                }
                            }
                        }
                    }
                }
            }
        }
        return (sum - 1).toString()
    }

    private fun f1(a: Int, b: Int, c: Int, d: Int, e: Int, f: Int): Int {
        return 100000 * a + 10000 * b + 1000 * c + 100 * d + 10 * e + f
    }

    private fun f2(vararg a: Int): Int {
        return a.reduce { sum, elem -> sum + elem.toBigInteger().pow(5).toInt() }
    }
}
