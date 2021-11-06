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
class P097Solver : ProjectEulerSolver {
    override fun run(): String {
        val number = BigInteger
            .valueOf(28433)
            .times(BigInteger.valueOf(2).pow(7830457))
            .plus(BigInteger.ONE)
        val numberString = number.toString()
        return numberString.substring(numberString.length - 10, numberString.length)
    }
}
