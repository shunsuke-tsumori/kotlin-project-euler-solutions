/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.solver.PeSolver
import org.springframework.stereotype.Component
import java.math.BigInteger

@Component
class P020Solver : PeSolver {
    override fun run(): Int {
        var factorial = BigInteger("1")
        for (i in 2..100) {
            factorial = factorial.times(i.toBigInteger())
        }
        return factorial.toString().map { d -> d.digitToInt() }.sum()
    }
}

