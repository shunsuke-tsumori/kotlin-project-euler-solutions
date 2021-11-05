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

@Component
class P040Solver : ProjectEulerSolver {
    override fun run(): String {
        val digits = StringBuilder()
        for (i in 1..1000000) {
            digits.append(i)
        }

        return (digits[0].digitToInt() *
                digits[9].digitToInt() *
                digits[99].digitToInt() *
                digits[999].digitToInt() *
                digits[9999].digitToInt() *
                digits[99999].digitToInt() *
                digits[999999].digitToInt()).toString()
    }
}
