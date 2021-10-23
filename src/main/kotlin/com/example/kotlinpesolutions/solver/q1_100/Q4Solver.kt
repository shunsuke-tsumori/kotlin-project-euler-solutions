/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.q1_100

import com.example.kotlinpesolutions.library.StringCalculationProcessor
import com.example.kotlinpesolutions.solver.PeSolver
import org.springframework.stereotype.Component

@Component
class Q4Solver(
    private val stringCalculationProcessor: StringCalculationProcessor
) : PeSolver {
    override fun run() {
        var max = 0
        var aI = 0
        var aJ = 0
        for (i in 100 until 1000) {
            for (j in i until 1000) {
                val prod = i * j
                if (stringCalculationProcessor.isPalindrome(prod.toString()) && max < prod) {
                    aI = i
                    aJ = j
                    max = prod
                }
            }
        }
        println("ans=$max, ($aI, $aJ)")
    }
}
