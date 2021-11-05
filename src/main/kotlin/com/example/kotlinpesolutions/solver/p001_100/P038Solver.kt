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
class P038Solver : ProjectEulerSolver {
    override fun run(): String {
        var max = 0L

        for (base in 1..50000) {
            var n = 2
            while (true) {
                var concatenatedProductString = ""
                for (i in 1..n) {
                    concatenatedProductString += (base * i)
                }
                val concatenatedProduct = concatenatedProductString.toLong()
                if (concatenatedProduct > 987654321) {
                    break
                }
                if (isPandigital(concatenatedProductString) && max < concatenatedProduct) {
                    max = concatenatedProduct
                }
                n++
            }
        }

        return max.toString()
    }

    private fun isPandigital(digit: String): Boolean {
        for (i in 1..9) {
            if (!digit.contains(i.toString())) {
                return false
            }
        }
        return true
    }
}
