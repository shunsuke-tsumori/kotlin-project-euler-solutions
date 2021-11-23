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
class P094Solver : ProjectEulerSolver {
    override fun run(): String {
        return countSolutions().toString()
    }

    //TODO refactor
    private fun countSolutions(): BigInteger {
        var ans = BigInteger.ZERO
        val maxX = BigInteger.valueOf(500_000_000)
        val n = BigInteger.valueOf(3L)

        val a0 = BigInteger.ONE
        var a = a0
        var m = BigInteger.ZERO
        var d = BigInteger.ONE

        var pN = a
        var pNm1 = BigInteger.ONE
        var qN = BigInteger.ONE
        var qNm1 = BigInteger.ZERO

        while (true) {
            ans += getLengthIfIsMatch(pN, qN)
            m = d * a - m
            d = (n - m * m) / d
            a = (a0 + m) / d

            val pNm2 = pNm1
            pNm1 = pN
            val qNm2 = qNm1
            qNm1 = qN
            pN = a * pNm1 + pNm2
            qN = a * qNm1 + qNm2
            if (pN > maxX) {
                break
            }
        }

        return ans
    }

    private fun getLengthIfIsMatch(pN: BigInteger, qN: BigInteger): BigInteger {
        val three = BigInteger.valueOf(3)
        if (pN * pN - three * qN * qN != BigInteger.ONE) {
            return BigInteger.ZERO
        }
        if (pN.times(BigInteger.TWO).plus(BigInteger.ONE).remainder(three) == BigInteger.ZERO) {
            val a = pN.times(BigInteger.TWO).plus(BigInteger.ONE).divide(three)
            val l = a.times(three).plus(BigInteger.ONE)
            return if (l >= three) l else BigInteger.ZERO
        }
        if (pN.times(BigInteger.TWO).minus(BigInteger.ONE).remainder(three) == BigInteger.ZERO) {
            val a = pN.times(BigInteger.TWO).minus(BigInteger.ONE).divide(three)
            val l = a.times(three).minus(BigInteger.ONE)
            return if (l >= three) l else BigInteger.ZERO
        }
        return BigInteger.ZERO
    }
}
