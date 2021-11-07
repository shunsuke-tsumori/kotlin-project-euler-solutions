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
class P052Solver : ProjectEulerSolver {
    override fun run(): String {
        var i = 1L
        while (true) {
            if (isNXContainSameDigits(i)) {
                return i.toString()
            }
            i++
        }
    }

    private fun isNXContainSameDigits(base: Long): Boolean {
        for (i in 2..6) {
            if (!isPermutation(base, i * base)) {
                return false
            }
        }
        return true
    }

    private fun isPermutation(base: Long, nTimes: Long): Boolean {
        var nTimesString = nTimes.toString()
        base.toString().forEach { l -> nTimesString = nTimesString.replaceFirst(l.toString(), "") }
        return nTimesString.isEmpty()
    }
}
