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
import java.util.*
import java.util.stream.Collectors

@Component
class P083Solver : ProjectEulerSolver {
    override fun run(): String {
        return dijkstra().toString()
    }

    private fun dijkstra(): Int {
        val dNodes = mutableListOf<Pair<Int, Int>>() // destinations
        for (i in 0 until HEIGHT) {
            for (j in 0 until WIDTH) {
                dNodes.add(Pair(i, j))
            }
        }
        dNodes.remove(Pair(0, 0))
        val oNodes = mutableListOf(Pair(0, 0)) // origins
        val costMap = mutableMapOf(Pair(0, 0) to MATRIX[0][0])

        while (dNodes.contains(Pair(HEIGHT - 1, WIDTH - 1))) {
            val (nextNode, theCost) = determineNextNodeAndTheCost(oNodes, dNodes, costMap)
            dNodes.remove(nextNode)
            oNodes.add(nextNode)
            costMap[nextNode] = theCost
            println(oNodes.size)
        }
        return costMap[Pair(HEIGHT - 1, WIDTH - 1)]!!
    }


    private fun determineNextNodeAndTheCost(
        oNodes: List<Pair<Int, Int>>,
        dNodes: List<Pair<Int, Int>>,
        costMap: Map<Pair<Int, Int>, Int>
    ): Pair<Pair<Int, Int>, Int> {
        PriorityQueue<Pair<Int, Int>>()
        var minCost = Int.MAX_VALUE
        var nextNode = dNodes[0]
        for (oNode in oNodes) {
            val (x, y) = oNode
            if (isExistsPathTo(x + 1, y, oNodes)) {
                val cost = costMap[oNode]!! + MATRIX[x + 1][y]
                if (cost < minCost) {
                    minCost = cost
                    nextNode = Pair(x + 1, y)
                }
            }
            if (isExistsPathTo(x - 1, y, oNodes)) {
                val cost = costMap[oNode]!! + MATRIX[x - 1][y]
                if (cost < minCost) {
                    minCost = cost
                    nextNode = Pair(x - 1, y)
                }
            }
            if (isExistsPathTo(x, y + 1, oNodes)) {
                val cost = costMap[oNode]!! + MATRIX[x][y + 1]
                if (cost < minCost) {
                    minCost = cost
                    nextNode = Pair(x, y + 1)
                }
            }
            if (isExistsPathTo(x, y - 1, oNodes)) {
                val cost = costMap[oNode]!! + MATRIX[x][y - 1]
                if (cost < minCost) {
                    minCost = cost
                    nextNode = Pair(x, y - 1)
                }
            }
        }
        return Pair(nextNode, minCost)
    }

    private fun isExistsPathTo(i: Int, j: Int, oNodes: List<Pair<Int, Int>>): Boolean {
        if (i < 0 || HEIGHT <= i || j < 0 || WIDTH <= j) {
            return false
        }
        if (oNodes.contains(Pair(i, j))) {
            return false
        }
        return true
    }

    companion object {
        private val MATRIX = readMatrix()
        private val HEIGHT = MATRIX.size
        private val WIDTH = MATRIX[0].size

        private fun readMatrix(): List<List<Int>> {
            val resourceStream = ClassPathResource("params/p83.txt").inputStream
            val reader = BufferedReader(InputStreamReader(resourceStream))
            val matrix = reader
                .lines()
                .map { line -> line.split(",").map { it.toInt() } }
                .collect(Collectors.toList())
            reader.close()
            return matrix
        }
    }
}
