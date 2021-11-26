/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.ListCalculator
import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.stereotype.Component
import kotlin.math.floor

@Component
class P093Solver(
    private val listCalculator: ListCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        val combinations = listCalculator.combinations(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 4)
        var max = 0
        var maxBase = 0

        for (combination in combinations) {
            val count = count(combination)
            if (count > max) {
                max = count
                maxBase = combination.reduce { sum, elem -> sum * 10 + elem }
            }
        }
        return maxBase.toString()
    }

    private fun count(combination: List<Int>): Int {
        val permutations = listCalculator.permutations(combination)
        val reducedNums = mutableSetOf<Int>()
        for (permutation in permutations) {
            reducedNums.addAll(calcReducedNums(permutation))
        }
        var n = 1
        while (true) {
            if (!reducedNums.contains(n)) {
                return n - 1
            }
            n++
        }
    }

    private fun calcReducedNums(permutation: List<Int>): Set<Int> {
        val operands = permutation.map { it.toDouble() }
        val resultList = fold(listOf(operands)).flatten()
        return resultList.filter { isInt(it) }.map { it.toInt() }.toSet()
    }

    private fun isInt(num: Double): Boolean {
        return floor(num) == num
    }

    private fun fold(operandsList: List<List<Double>>): List<List<Double>> {
        if (operandsList[0].size == 1) {
            return operandsList
        }
        val nextList = mutableListOf<List<Double>>()
        for (operands in operandsList) {
            for (i in 0..operands.size - 2) {
                val operationResults = operationResults(operands[i], operands[i + 1])
                for (r in operationResults) {
                    nextList.add(operands.subList(0, i).plus(listOf(r)).plus(operands.subList(i + 2, operands.size)))
                }
            }
        }
        return fold(nextList)
    }

    private fun operationResults(o1: Double, o2: Double): Set<Double> {
        val results = mutableSetOf<Double>()
        results.add(o1 + o2)
        results.add(o1 - o2)
        results.add(o1 * o2)
        if (o2 != 0.0) {
            results.add(o1 / o2)
        }
        return results
    }
}
