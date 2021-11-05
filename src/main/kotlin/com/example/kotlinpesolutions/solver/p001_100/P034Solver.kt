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
class P034Solver : PeSolver {
    override fun run(): Int {
        var sum = 0
        // 9! * 7 = 2540160
        for (i in 3..2540160) {
            val f1 = factorialOfDigits(i)
            if (f1 == i) {
                sum += i
            }
        }
        return sum
    }

    private fun factorialOfDigits(n: Int): Int {
        var sum = 0
        var nDivided = n
        while (nDivided > 0) {
            sum += factorial(nDivided % 10)
            nDivided /= 10
        }
        return sum
    }

    private fun factorial(n: Int): Int {
        var f = 1
        for (i in 2..n) {
            f *= i
        }
        return f
    }
}
