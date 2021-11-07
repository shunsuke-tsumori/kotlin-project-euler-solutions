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
class P063Solver : ProjectEulerSolver {
    override fun run(): String {
        var count = 0
        for (base in 1..9) {
            var n = 1
            while (true) {
                if (n == BigInteger.valueOf(base.toLong()).pow(n).toString().length) {
                    count++
                } else {
                    break
                }
                n++
            }
        }
        return count.toString()
    }
}
