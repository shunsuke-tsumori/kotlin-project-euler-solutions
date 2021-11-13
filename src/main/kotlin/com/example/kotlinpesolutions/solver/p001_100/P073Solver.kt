/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.NumericalCalculator
import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.stereotype.Component

@Component
class P073Solver(
    private val numericalCalculator: NumericalCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        val v1over3 = 1.0 / 3
        val v1over2 = 1.0 / 2
        val fractionSet = mutableSetOf<Pair<Int, Int>>()
        for (d in 2..12_000) {
            var n = d / 3
            var vNOverD = n.toDouble() / d
            while (vNOverD < v1over2) {
                if (vNOverD > v1over3) {
                    val gcd = numericalCalculator.gcd(n, d)
                    val reducedN = n / gcd
                    val reducedD = d / gcd
                    fractionSet.add(Pair(reducedN, reducedD))
                }
                n++
                vNOverD = n.toDouble() / d
            }
        }
        return fractionSet.size.toString()
    }
}
