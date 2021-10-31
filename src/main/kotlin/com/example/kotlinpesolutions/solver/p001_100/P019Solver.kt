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
import java.time.DayOfWeek
import java.time.LocalDate

@Component
class P019Solver : PeSolver {
    override fun run(): Int {
        var sum = 0
        var current = LocalDate.of(1901, 1, 1)
        while (current < LocalDate.of(2001, 1, 1)) {
            if (current.dayOfMonth == 1 && current.dayOfWeek.equals(DayOfWeek.SUNDAY)) {
                sum++
            }
            current = current.plusDays(1)
        }
        return sum
    }
}
