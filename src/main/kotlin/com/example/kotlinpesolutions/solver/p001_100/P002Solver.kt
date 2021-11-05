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
class P002Solver : ProjectEulerSolver {
    var bound = 4_000_000

    override fun run(): String {
        var a = 1
        var b = 2
        var c = a + b
        var sum = 2
        while (c < bound) {
            if (c % 2 == 0) {
                sum += c
            }
            a = b
            b = c
            c = a + b
        }
        return sum.toString()
    }
}
