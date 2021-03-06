/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.InputStreamReader

@Component
class P001Solver : ProjectEulerSolver {
    override fun run(): String {
        val resourceStream = ClassPathResource("params/p1.txt").inputStream
        val reader = BufferedReader(InputStreamReader(resourceStream))
        val max = reader.readLine().toInt()
        val (a, b) = reader.readLine().split(" ").map { it.toInt() }
        reader.close()
        var sum = 0
        for (i in 1 until max) {
            if (i % a == 0 || i % b == 0) {
                sum += i
            }
        }
        return sum.toString()
    }
}
