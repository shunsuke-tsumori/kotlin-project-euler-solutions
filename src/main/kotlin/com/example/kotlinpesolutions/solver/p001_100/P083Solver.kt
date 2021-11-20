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
        val nodes = mutableListOf<Node>()
        for (i in 0 until HEIGHT) {
            for (j in 0 until WIDTH) {
                nodes.add(Node(i, j, Int.MAX_VALUE))
            }
        }
        val startNode = nodes[0]
        startNode.minCost = MATRIX[0][0]
        val queue = PriorityQueue<Node>()
        queue.add(startNode)

        while (queue.isNotEmpty()) {
            val current = queue.poll()
            val currentX = current.x
            val currentY = current.y
            calculateFor(currentX + 1, currentY, current, nodes, queue)
            calculateFor(currentX - 1, currentY, current, nodes, queue)
            calculateFor(currentX, currentY + 1, current, nodes, queue)
            calculateFor(currentX, currentY - 1, current, nodes, queue)
        }

        return nodes[HEIGHT * WIDTH - 1].minCost
    }

    private fun calculateFor(x: Int, y: Int, currentNode: Node, nodes: List<Node>, nodeQueue: PriorityQueue<Node>) {
        if (isExistsPathTo(x, y)) {
            val nextNode = nodes.filter { n -> n.x == x && n.y == y }[0]
            val cost = currentNode.minCost + MATRIX[x][y]
            if (nextNode.minCost > cost) {
                nextNode.minCost = cost
                nodeQueue.add(nextNode)
            }
        }
    }

    private fun isExistsPathTo(i: Int, j: Int): Boolean {
        if (i < 0 || HEIGHT <= i || j < 0 || WIDTH <= j) {
            return false
        }
        return true
    }

    private class Node(
        val x: Int,
        val y: Int,
        var minCost: Int,
    ) : Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return if (this.minCost == other.minCost) {
                0
            } else if (other.minCost < this.minCost) {
                1
            } else {
                -1
            }
        }
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
