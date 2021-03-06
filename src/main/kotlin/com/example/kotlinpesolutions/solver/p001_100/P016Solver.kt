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
import java.math.BigInteger

@Component
class P016Solver : ProjectEulerSolver {
    override fun run(): String {
        return BigInteger("2")
            .pow(1000)
            .toString()
            .map { d -> d.digitToInt() }
            .sum().toString()
    }
}
