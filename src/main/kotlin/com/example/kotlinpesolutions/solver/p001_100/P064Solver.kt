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
import kotlin.math.floor
import kotlin.math.sqrt

@Component
class P064Solver : ProjectEulerSolver {
    override fun run(): String {
        var count = 0
        val bound = 10_000
        for (i in 2..bound) {
            if (countPeriod(i) % 2 == 1) {
                count++
            }
        }
        return count.toString()
    }

    // https://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Continued_fraction_expansion
    private fun countPeriod(n: Int): Int {
        val a0 = floor(sqrt(n.toDouble())).toInt()
        if (a0 * a0 == n) {
            return 0
        }
        var a = a0
        var m = 0
        var d = 1
        val aList = mutableListOf<Int>()
        do {
            m = d * a - m
            d = (n - m * m) / d
            a = (a0 + m) / d
            aList.add(a)
        } while (a != 2 * a0)
        return aList.size
    }
}
