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
class P015Solver : PeSolver {
    override fun run() {


        println(combinationMemoAndGetValue(mutableMapOf(), 40, 20))
    }

    // nCr
    private fun combinationMemoAndGetValue(
        combinationMemo: MutableMap<Pair<Int, Int>, Long>,
        n: Int,
        r: Int
    ): Long {
        val combination = Pair(n, r)
        if (combinationMemo.containsKey(combination)) {
            return combinationMemo[combination]!!
        }
        if (n == r || r == 0) {
            combinationMemo[combination] = 1L
        } else if (r == 1) {
            combinationMemo[combination] = n.toLong()
        } else {
            // nCr = n-1Cr + n-1Cr-1
            combinationMemo[combination] =
                combinationMemoAndGetValue(combinationMemo, n - 1, r) +
                        combinationMemoAndGetValue(combinationMemo, n - 1, r - 1)
        }

        return combinationMemo[Pair(n, r)]!!
    }
}
