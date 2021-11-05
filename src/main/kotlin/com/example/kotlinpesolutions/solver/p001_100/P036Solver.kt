/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.StringCalculator
import com.example.kotlinpesolutions.solver.PeSolver
import org.springframework.stereotype.Component
import java.lang.StringBuilder

@Component
class P036Solver(
    private val stringCalculator: StringCalculator
) : PeSolver {
    override fun run(): Int {
        val bound = 1_000_000
        var sum = 0
        for (i in 1..bound) {
            val iBase10 = i.toString()
            val iBase2 = i.toBinaryString()
            if (stringCalculator.isPalindrome(iBase10) && stringCalculator.isPalindrome(iBase2)) {
                sum += i
            }
        }
        return sum
    }

    private fun Int.toBinaryString(): String {
        var nDivided = this
        val binaryExpression = StringBuilder()
        while (nDivided > 0) {
            val newOne = if (nDivided % 2 == 0) "0" else "1"
            binaryExpression.append(newOne)
            nDivided /= 2
        }
        return binaryExpression.toString()
    }
}
