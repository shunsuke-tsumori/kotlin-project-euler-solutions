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

@Component
class P008Solver : ProjectEulerSolver {
    override fun run(): String {
        val resourceStream = ClassPathResource("params/p8.txt").inputStream
        val reader = BufferedReader(InputStreamReader(resourceStream))
        val numList = reader
            .lines()
            .map { line -> line.split("").filter { c -> c.length == 1 }.map { it.toLong() } }
            .collect(Collectors.toList()).flatten()
        reader.close()

        val nAdjacent = 13
        var greatest = numList.subList(0, nAdjacent).reduce { prod, element -> prod * element }
        var current = greatest
        for (i in 1..1000 - 1 - nAdjacent) {
            current = if (numList[i - 1] != 0L) {
                current / numList[i - 1] * numList[i + nAdjacent - 1]
            } else {
                numList.subList(i, i + nAdjacent).reduce { prod, element -> prod * element }
            }
            if (current > greatest) {
                greatest = current
            }
        }
        return greatest.toString()
    }
}
