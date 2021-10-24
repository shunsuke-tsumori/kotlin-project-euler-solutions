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
class P007Solver : PeSolver {
    override fun run() {
        val primeList = mutableListOf<Long>()
        primeList.add(2)
        val limit = 10001
        var currentNum = 3L

        while (primeList.size < limit) {
            if (!isDividedByAny(primeList, currentNum)) {
                primeList.add(currentNum)
            }
            currentNum += 2
        }
        println(primeList[limit - 1])
    }

    private fun isDividedByAny(primeList: List<Long>, target: Long): Boolean {
        for (prime in primeList) {
            if (target % prime == 0L) {
                return true
            }
        }
        return false
    }
}
