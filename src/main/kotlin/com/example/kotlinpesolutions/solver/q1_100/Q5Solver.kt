/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.q1_100

import com.example.kotlinpesolutions.library.NumericalCalculator
import com.example.kotlinpesolutions.solver.PeSolver
import org.springframework.stereotype.Component

@Component
class Q5Solver(
    private val numericalCalculator: NumericalCalculator
) : PeSolver {
    override fun run() {
        println(calculate())
    }

    fun calculate(): Long {
        val max = 20L
        var lcm = 1L
        for (i in 2L..max) {
            lcm = i * lcm / numericalCalculator.gcd(i, lcm)
        }
        return lcm
    }

}
