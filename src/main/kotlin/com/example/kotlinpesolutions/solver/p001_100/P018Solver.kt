/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.impl.MaximumPathCalculator
import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.stream.Collectors

@Component
class P018Solver(
    private val maximumPathCalculator: MaximumPathCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        val resourceStream = ClassPathResource("params/p18.txt").inputStream
        val reader = BufferedReader(InputStreamReader(resourceStream))

        val numberGrid = reader
            .lines()
            .map { line -> line.split(" ").map { it.toInt() } }
            .collect(Collectors.toList())
        reader.close()

        return maximumPathCalculator.maximumPathValue(numberGrid).toString()
    }
}
