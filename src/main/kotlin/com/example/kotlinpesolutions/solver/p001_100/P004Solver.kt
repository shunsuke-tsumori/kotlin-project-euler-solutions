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

@Component
class P004Solver(
    private val stringCalculator: StringCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        var max = 0
        for (i in 100 until 1000) {
            for (j in i until 1000) {
                val prod = i * j
                if (stringCalculator.isPalindrome(prod.toString()) && max < prod) {
                    max = prod
                }
            }
        }
        return max.toString()
    }
}
