/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.NumericalCalculator
import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.stereotype.Component

@Component
class P005Solver(
    private val numericalCalculator: NumericalCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        return calculate().toString()
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
