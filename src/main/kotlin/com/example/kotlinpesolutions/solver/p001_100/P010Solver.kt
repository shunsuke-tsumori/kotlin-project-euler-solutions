/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.PrimeCalculator
import com.example.kotlinpesolutions.solver.PeSolver
import org.springframework.stereotype.Component

@Component
class P010Solver(
    private val primeCalculator: PrimeCalculator
) : PeSolver {
    override fun run(): Long {
        return primeCalculator.primeListBelow(2_000_000).reduce { prod, element -> prod + element }
    }
}
