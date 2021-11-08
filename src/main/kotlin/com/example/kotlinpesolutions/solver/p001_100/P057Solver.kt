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
class P057Solver : ProjectEulerSolver {
    override fun run(): String {
        var count = 0
        var numerator = BigInteger.ONE
        var denominator = BigInteger.TWO
        for (i in 1..1000) {
            val plus1Numerator = numerator + denominator
            if (plus1Numerator.toString().length > denominator.toString().length) {
                count++
            }
            val tmp = BigInteger.TWO.times(denominator) + numerator
            numerator = denominator
            denominator = tmp
        }
        return count.toString()
    }
}
