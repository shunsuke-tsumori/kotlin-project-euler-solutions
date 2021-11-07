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
class P081Solver : ProjectEulerSolver {
    override fun run(): String {
        val resourceStream = ClassPathResource("params/p81.txt").inputStream

        val reader = BufferedReader(InputStreamReader(resourceStream))

        val matrix = reader
            .lines()
            .map { line -> line.split(",").map { it.toBigInteger() } }
            .collect(Collectors.toList())
        reader.close()

        val minimalMatrix = mutableListOf(mutableListOf(matrix[0][0]))
        val theSize = matrix.size
        for (i in 1 until theSize) {
            for (j in 0..i) {
                minimalMatrix.add(mutableListOf())
                when (j) {
                    0 -> {
                        minimalMatrix[i].add(matrix[i][0] + minimalMatrix[i - 1][0])
                    }
                    i -> {
                        minimalMatrix[0].add(matrix[0][j] + minimalMatrix[0][j - 1])
                    }
                    else -> {
                        val min =
                            if (minimalMatrix[i - j - 1][j] < minimalMatrix[i - j][j - 1])
                                minimalMatrix[i - j - 1][j]
                            else minimalMatrix[i - j][j - 1]
                        minimalMatrix[i - j].add(matrix[i - j][j] + min)
                    }
                }
            }
        }
        for (i in 1 until theSize) {
            for (j in 0 until theSize - i) {
                val row = theSize - 1 - j
                val col = i + j
                val min =
                    if (minimalMatrix[row - 1][col] < minimalMatrix[row][col - 1])
                        minimalMatrix[row - 1][col]
                    else minimalMatrix[row][col - 1]
                minimalMatrix[row].add(matrix[row][col] + min)
            }
        }
        return minimalMatrix[theSize - 1][theSize - 1].toString()
    }
}
