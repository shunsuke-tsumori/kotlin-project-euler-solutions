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
import java.util.stream.Collectors
import kotlin.math.ln

@Component
class P099Solver : ProjectEulerSolver {
    override fun run(): String {
        val resourceStream = ClassPathResource("params/p99.txt").inputStream

        val reader = BufferedReader(InputStreamReader(resourceStream))

        val numberPairs = reader
            .lines()
            .map { line -> line.split(",").map { it.toInt() } }
            .collect(Collectors.toList())
        reader.close()

        var maxIdx = 0
        var maxLogValue = 0.0

        for (i in 0 until numberPairs.size) {
            val logValue = numberPairs[i][1] * ln(numberPairs[i][0].toDouble())
            if (logValue > maxLogValue) {
                maxLogValue = logValue
                maxIdx = i + 1
            }
        }

        return maxIdx.toString()
    }
}
