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
class P044Solver : ProjectEulerSolver {
    // cf) https://en.wikipedia.org/wiki/Pentagonal_number
    override fun run(): String {
        var minDistance = Long.MAX_VALUE
        var i = 2
        while (true) {
            val pI = pentagonal(i)
            if (3 * i - 2 > minDistance) {
                break
            }
            for (j in i - 1 downTo 1) {
                val pJ = pentagonal(j)
                val distance = pI - pJ
                if (distance > minDistance) {
                    break
                }
                if (isPentagonal(distance) && isPentagonal(pI + pJ)) {
                    if (distance < minDistance) {
                        minDistance = distance
                    }
                    break
                }
            }
            i++
        }

        return minDistance.toString()
    }

    private fun pentagonal(n: Int): Long {
        return n * (3L * n - 1) / 2
    }

    // ∃n st x = n*(3n-1)/2 <=> ∃m 24x+1=m^2 and sqrt(24x+1)=5 mod6
    private fun isPentagonal(n: Long): Boolean {
        val x = 24 * n + 1
        val m = floor(sqrt(x.toDouble())).toLong()
        return m * m == x && m % 6 == 5L
    }
}
