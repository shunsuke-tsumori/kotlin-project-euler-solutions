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
class P022Solver : ProjectEulerSolver {
    override fun run(): String {
        val resourceStream = ClassPathResource("params/p22.txt").inputStream
        val reader = BufferedReader(InputStreamReader(resourceStream))
        val line = reader.readLine()!!
        reader.close()

        val nameList = line
            .split(",")
            .map { n -> n.replace("\"", "") }
            .sorted()

        var sum = 0L
        for ((idx, elem) in nameList.withIndex()) {
            sum += (idx + 1) * nameAlphabeticalValue(elem)
        }
        return sum.toString()
    }

    fun nameAlphabeticalValue(name: String): Int {
        val baseByte = 'A'.code.toByte() - 1
        return name.toByteArray().sumOf { c -> c - baseByte }
    }
}
