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
class P100Solver : ProjectEulerSolver {
    override fun run(): String {
        // solve x^2 - 2y^2 = -1  s.t.  x=2n-1, y=2b-1, n>10^12
        val y = calculateY()
        return y.plus(BigInteger.ONE).divide(BigInteger.TWO).toString()
    }

    // same as p066
    //TODO refactor
    private fun calculateY(): BigInteger {
        val a0 = BigInteger.ONE
        if (a0 * a0 == BigInteger.TWO) {
            return BigInteger.ZERO
        }
        @Suppress
        var a = a0
        var m = BigInteger.ZERO
        var d = BigInteger.ONE

        var pN = a
        var pNm1 = BigInteger.ONE
        var qN = BigInteger.ONE
        var qNm1 = BigInteger.ZERO

        while (true) {
            if (isMeet(pN, qN)) {
                return qN
            }
            m = d * a - m
            d = (BigInteger.TWO - m * m) / d
            @Suppress
            a = (a0 + m) / d

            val pNm2 = pNm1
            pNm1 = pN
            val qNm2 = qNm1
            qNm1 = qN
            pN = a * pNm1 + pNm2
            qN = a * qNm1 + qNm2
        }
    }

    private fun isMeet(pN: BigInteger, qN: BigInteger): Boolean {
        val bound = BigInteger.valueOf(1_999_999_999_999)
        if (pN < bound) {
            return false
        }
        if (pN.remainder(BigInteger.TWO) != BigInteger.ONE || qN.remainder(BigInteger.TWO) != BigInteger.ONE) {
            return false
        }
        return pN * pN - BigInteger.TWO * qN * qN == -BigInteger.ONE
    }
}
