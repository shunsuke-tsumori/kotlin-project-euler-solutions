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

@Component
class P004Solver(
    private val stringCalculator: StringCalculator
) : PeSolver {
    override fun run(): Int {
        var max = 0
//        var aI = 0
//        var aJ = 0
        for (i in 100 until 1000) {
            for (j in i until 1000) {
                val prod = i * j
                if (stringCalculator.isPalindrome(prod.toString()) && max < prod) {
//                    aI = i
//                    aJ = j
                    max = prod
                }
            }
        }
//        println("ans=$max, ($aI, $aJ)")
        return max
    }
}
