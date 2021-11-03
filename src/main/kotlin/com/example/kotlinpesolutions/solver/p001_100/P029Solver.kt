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
class P029Solver:PeSolver {
    override fun run(): Int {
        val powersSet = mutableSetOf<BigInteger>()
        for (a in 2..100) {
            for (b in 2..100) {
                powersSet.add(BigInteger.valueOf(a.toLong()).pow(b))
            }
        }
        return powersSet.size
    }
}
