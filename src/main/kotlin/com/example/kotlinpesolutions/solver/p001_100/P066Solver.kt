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
import kotlin.math.floor
import kotlin.math.sqrt

@Component
class P066Solver : ProjectEulerSolver {
    override fun run(): String {
        var max = BigInteger.ZERO
        var dOfMax = 0
        for (d in 2..1000) {
            val minimalX = calculateMinimalX(d)
            if (max < minimalX) {
                max = minimalX
                dOfMax = d
            }
        }
        return dOfMax.toString()
    }

    // p064 extension
    // good references↓
    // https://www.mathblog.dk/project-euler-66-diophantine-equation/
    // https://maple0705.hatenablog.jp/entry/2017/02/18/150109
    private fun calculateMinimalX(n: Int) : BigInteger {
        val a0 = floor(sqrt(n.toDouble())).toBigDecimal().toBigInteger()
        if (a0 * a0 == n.toBigInteger()) {
            return BigInteger.ZERO
        }
        var a = a0
        var m = BigInteger.ZERO
        var d = BigInteger.ONE

        var pN = a
        var pNm1 = BigInteger.ONE
        var qN = BigInteger.ONE
        var qNm1 = BigInteger.ZERO

        while (pN * pN - BigInteger.valueOf(n.toLong()) * qN * qN != BigInteger.ONE) {
            m = d * a - m
            d = (BigInteger.valueOf(n.toLong()) - m * m) / d
            a = (a0 + m) / d

            val pNm2 = pNm1
            pNm1 = pN
            val qNm2 = qNm1
            qNm1 = qN
            pN = a * pNm1 + pNm2
            qN = a * qNm1 + qNm2
        }

        return pN
    }
}
