/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.PrimeCalculator
import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.stereotype.Component
import kotlin.math.floor
import kotlin.math.sqrt

@Component
class P087Solver(
    private val primeCalculator: PrimeCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        val bound = 50_000_000
        val primeList = primeCalculator.primeListBelow(floor(sqrt(bound.toDouble())).toLong())
        val numberSet = mutableSetOf<Long>()
        for (a in primeList) {
            val square = square(a)
            for (b in primeList) {
                val cube = cube(b)
                if (square + cube >= bound) {
                    break
                }
                for (c in primeList) {
                    val fourthPower = fourthPower(c)
                    val sum = square + cube + fourthPower
                    if (sum >= bound) {
                        break
                    }
                    numberSet.add(sum)
                }
            }
        }
        return numberSet.size.toString()
    }

    private fun square(n: Long): Long {
        return n * n
    }

    private fun cube(n: Long): Long {
        return n * n * n
    }

    private fun fourthPower(n: Long): Long {
        return n * n * n * n
    }
}
