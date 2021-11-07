/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.StringCalculator
import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.stereotype.Component
import java.math.BigInteger

@Component
class P055Solver(
    private val stringCalculator: StringCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        val bound = 10_000
        var count = 0
        for (i in 1 until bound) {
            if (isLychrel(i)) {
                count++
            }
        }
        return count.toString()
    }

    private fun isLychrel(n: Int): Boolean {
        var base = n.toBigInteger()
        for (i in 1 until 50) {
            val sum = base + reverse(base)
            if (stringCalculator.isPalindrome(sum.toString())) {
                return false
            }
            base = sum
        }
        return true
    }

    private fun reverse(n: BigInteger): BigInteger {
        return BigInteger(n.toString().reversed())
    }
}
