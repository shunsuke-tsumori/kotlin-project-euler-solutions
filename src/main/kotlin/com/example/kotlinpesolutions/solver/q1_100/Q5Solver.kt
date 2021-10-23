/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.q1_100

import com.example.kotlinpesolutions.solver.PeSolver
import org.springframework.stereotype.Component

@Component
class Q5Solver: PeSolver {
    override fun run() {
        println(calculate())
    }

    fun calculate(): Long {
        return 5L * 7 * 9 * 11 * 13 * 17 * 16 * 19
    }

}
