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
class P031Solver : PeSolver {
    override fun run(): Int {
        return coinPatterns(200, listOf(200, 100, 50, 20, 10, 5, 2))
    }

    private fun coinPatterns(remain: Int, coinList: List<Int>): Int {
        if (remain == 0 || coinList.isEmpty()) {
            return 1
        }
        var patterns = 0
        for (i in 0..remain / coinList[0]) {
            patterns += coinPatterns(remain - coinList[0] * i, coinList.subList(1, coinList.size))
        }
        return patterns
    }
}
