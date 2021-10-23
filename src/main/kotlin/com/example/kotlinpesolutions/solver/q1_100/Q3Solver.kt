/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.q1_100

import com.example.kotlinpesolutions.solver.PeSolver
import org.springframework.stereotype.Component

@Component
class Q3Solver : PeSolver {
    override fun run() {
        var divider = 3L
        var target = 600851475143

        while (divider * divider < target) {
            if (target % divider == 0L) {
                target /= divider
                continue
            }
            divider += 2
        }

        println(target)
    }
}
