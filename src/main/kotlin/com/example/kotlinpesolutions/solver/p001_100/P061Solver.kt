/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.PolygonCalculator
import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.stereotype.Component

@Component
class P061Solver(
    private val polygonCalculator: PolygonCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        val octagonalList = mutableListOf<Long>()
        var n = 5
        while (true) {
            val octagonal = polygonCalculator.octagonal(n)
            if (octagonal >= 10000) {
                break
            }
            if (octagonal >= 1000) {
                octagonalList.add(octagonal)
            }
            n++
        }
        for (octagonal in octagonalList) {
            val candidateList = listOf(0, 0, 0, 0, 0, octagonal)
            val theValue = cyclicalTotal(candidateList, 5, octagonal / 100)
            if (theValue > 0) {
                return theValue.toString()
            }
        }
        return "no answer"
    }

    //TODO refactor
    private fun cyclicalTotal(candidateList: List<Long>, preIndex: Int, terminal: Long): Int {
        if (candidateList.none { it == 0L }) {
            if (candidateList[preIndex] % 100 == terminal) {
                return candidateList.sum().toInt()
            }
            return 0
        }
        val preTwoDigits = candidateList[preIndex] % 100
        if (preTwoDigits < 10) {
            return 0
        }
        for (i in 10..99) {
            val candidate = preTwoDigits * 100 + i
            if (candidateList[0] == 0L && polygonCalculator.isTriangle(candidate)) {
                val nextList = candidateList.toMutableList()
                nextList[0] = candidate
                val theValue = cyclicalTotal(nextList, 0, terminal)
                if (theValue > 0) {
                    return theValue
                }
            }
            if (candidateList[1] == 0L && polygonCalculator.isSquare(candidate)) {
                val nextList = candidateList.toMutableList()
                nextList[1] = candidate
                val theValue = cyclicalTotal(nextList, 1, terminal)
                if (theValue > 0) {
                    return theValue
                }
            }
            if (candidateList[2] == 0L && polygonCalculator.isPentagonal(candidate)) {
                val nextList = candidateList.toMutableList()
                nextList[2] = candidate
                val theValue = cyclicalTotal(nextList, 2, terminal)
                if (theValue > 0) {
                    return theValue
                }
            }
            if (candidateList[3] == 0L && polygonCalculator.isHexagonal(candidate)) {
                val nextList = candidateList.toMutableList()
                nextList[3] = candidate
                val theValue = cyclicalTotal(nextList, 3, terminal)
                if (theValue > 0) {
                    return theValue
                }
            }
            if (candidateList[4] == 0L && polygonCalculator.isHeptagonal(candidate)) {
                val nextList = candidateList.toMutableList()
                nextList[4] = candidate
                val theValue = cyclicalTotal(nextList, 4, terminal)
                if (theValue > 0) {
                    return theValue
                }
            }
        }
        return 0
    }
}
