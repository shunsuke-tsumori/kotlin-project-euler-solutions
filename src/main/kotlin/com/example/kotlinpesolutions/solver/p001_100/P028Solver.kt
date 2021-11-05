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
class P028Solver : ProjectEulerSolver {
    override fun run(): String {
        var sum = BigInteger("1")
        for (i in 1..500) {
            sum = sum.plus(f(i))
        }
        return sum.toString()
    }

    private fun f(n: Int): BigInteger {
        return BigInteger
            .valueOf(2 * n + 1L)
            .pow(2)
            .times(BigInteger("4"))
            .minus(BigInteger.valueOf(12L * n))
    }
}
