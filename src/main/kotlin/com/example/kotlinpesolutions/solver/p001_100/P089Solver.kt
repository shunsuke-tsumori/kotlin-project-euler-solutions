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
class P089Solver : ProjectEulerSolver {
    override fun run(): String {
        val lines = readLines()
        val replacedLines = replace(lines)
        return (countLines(lines) - countLines(replacedLines)).toString()
    }

    private fun replace(lines: List<String>): List<String> {
        val newLines = mutableListOf<String>()
        for (line in lines) {
            newLines.add(
                line.replace("DCCCC", "CM")
                    .replace("CCCC", "CD")
                    .replace("LXXXX", "XC")
                    .replace("XXXX", "XL")
                    .replace("VIIII", "IX")
                    .replace("IIII", "IV")
            )
        }
        return newLines
    }


    private fun countLines(lines: List<String>):Int {
        return lines.sumOf { l -> l.length }
    }

    private fun readLines(): List<String> {
        val resourceStream = ClassPathResource("params/p89.txt").inputStream
        val reader = BufferedReader(InputStreamReader(resourceStream))
        val lines = reader
            .lines()
            .map { it.toString() }
            .collect(Collectors.toList())
        reader.close()
        return lines
    }
}
