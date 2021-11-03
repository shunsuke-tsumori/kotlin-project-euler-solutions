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
class P025Solver : PeSolver {
    // Fibonacci
    override fun run(): Long {
        var index = 3L
        var f1 = BigInteger("1")
        var f2 = BigInteger("1")
        var f3 = f1.plus(f2)
        val bound = BigInteger("10").pow(1000 - 1)
        while (f3 < bound) {
            index++
            f1 = f2
            f2 = f3
            f3 = f2 + f1
        }
        return index
    }
}
