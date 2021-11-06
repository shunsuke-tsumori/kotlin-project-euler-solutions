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
class P048Solver : ProjectEulerSolver {
    override fun run(): String {
        var sum = BigInteger.ZERO
        for (i in 1..1000) {
            sum = sum.plus(i.toBigInteger().pow(i))
        }
        val sumString = sum.toString()
        return sumString.substring(sumString.length - 10, sumString.length)
    }
}
