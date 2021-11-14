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
class P080Solver : ProjectEulerSolver {
    override fun run(): String {
        var sum = 0
        val skipList = listOf(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)
        for (i in 1..100) {
            if (!skipList.contains(i)) {
                sum += sumOfSqrtDigits(i)
            }
        }
        return sum.toString()
    }

    private fun sumOfSqrtDigits(n: Int): Int {
        val sequence = BigInteger.valueOf(n.toLong()).times(BigInteger.TEN.pow(200)).sqrt().toString().substring(0, 100)
        return sequence.map { c -> c.digitToInt() }.sum()
    }
}
