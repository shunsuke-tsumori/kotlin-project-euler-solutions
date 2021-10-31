/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.solver.PeSolver
import org.springframework.stereotype.Component

@Component
class P009Solver : PeSolver {
    override fun run(): Int {
        return calculate()
    }

    fun calculate(): Int {
        val total = 1000
        for (a in 1..total / 3) {
            for (b in a + 1..total) {
                val c = total - a - b
                if (a * a + b * b == c * c) {
//                    println("a=$a, b=$b, c=$c")
                    return a * b * c
                }
            }
        }
        return -1
    }

}
