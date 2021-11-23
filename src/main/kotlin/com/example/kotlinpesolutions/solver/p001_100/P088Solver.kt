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
class P088Solver : ProjectEulerSolver {
    override fun run(): String {
        val kMin = 2
        val kMax = 12000
        val minProdSumSet = mutableSetOf<Int>()
        for (k in kMin..kMax) {
            var l = k + 1
            while (true) {
                if (isWriteable(k, l, l)) {
                    minProdSumSet.add(l)
                    break
                }
                l++
            }
        }
        return minProdSumSet.sum().toString()
    }

    private fun isWriteable(k: Int, prodRemain: Int, sumRemain: Int): Boolean {
        if (k == 1) {
            return prodRemain == sumRemain
        }
        if (sumRemain < k) {
            return false
        }
        if (prodRemain == 1) {
            return k == sumRemain
        }
        var i = 2
        while (i <= prodRemain && sumRemain - i >= k - 1) {
            if (prodRemain % i == 0) {
                if (isWriteable(k - 1, prodRemain / i, sumRemain - i)) {
                    return true
                }
            }
            i++
        }
        return false
    }
}
