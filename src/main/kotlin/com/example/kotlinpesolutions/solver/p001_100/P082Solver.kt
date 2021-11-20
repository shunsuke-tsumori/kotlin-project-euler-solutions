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
import java.math.BigInteger
import java.util.stream.Collectors

@Component
class P082Solver : ProjectEulerSolver {
    override fun run(): String {
        val matrix = readParams()
        val minMatrix = mutableListOf<MutableList<BigInteger>>()
        for (i in matrix.indices) {
            minMatrix.add(mutableListOf(matrix[i][0].toBigInteger()))
        }
        for (i in 1 until matrix[0].size) {
            for (j in matrix.indices) {
                minMatrix[j].add(minMatrix[j][i - 1] + matrix[j][i].toBigInteger())
            }
            for (j in 1 until matrix.size) {
                minMatrix[j][i] = minOf(minMatrix[j][i], minMatrix[j - 1][i] + matrix[j][i].toBigInteger())
            }
            for (j in matrix.size - 2 downTo 0) {
                minMatrix[j][i] = minOf(minMatrix[j][i], minMatrix[j + 1][i] + matrix[j][i].toBigInteger())
            }
        }
        var minCost = minMatrix[0][minMatrix[0].size - 1]
        for (i in 1 until minMatrix.size) {
            val cost = minMatrix[i][minMatrix[0].size - 1]
            if (cost < minCost) {
                minCost = cost
            }
        }
        return minCost.toString()
    }

    private fun readParams(): List<List<Int>> {
        val resourceStream = ClassPathResource("params/p82.txt").inputStream

        val reader = BufferedReader(InputStreamReader(resourceStream))

        val matrix = reader
            .lines()
            .map { line -> line.split(",").map { it.toInt() } }
            .collect(Collectors.toList())
        reader.close()
        return matrix
    }
}
