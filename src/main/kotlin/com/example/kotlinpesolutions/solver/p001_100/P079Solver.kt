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
class P079Solver : ProjectEulerSolver {
    // トポロジカルソート topological sort
    override fun run(): String {
        val lines = readLines()
        val (sSet, edgeSet) = setUpForThis(lines)
        val sortedList = topologicalSort(sSet, edgeSet)
        return sortedList.joinToString("")
    }

    private fun readLines(): List<String> {
        val resourceStream = ClassPathResource("params/p79.txt").inputStream
        val reader = BufferedReader(InputStreamReader(resourceStream))
        val lines = reader
            .lines()
            .map { it.toString() }
            .collect(Collectors.toList())
        reader.close()
        return lines
    }

    /**
     * @return (始点ノード集合, エッジ集合)
     */
    private fun setUpForThis(lines: List<String>)
            : Pair<MutableSet<Char>, MutableSet<Pair<Char, Char>>> {
        val digitSet = mutableSetOf<Char>()
        lines.forEach { line -> line.forEach { c -> digitSet.add(c) } }
        val sSet = digitSet.toMutableSet() // clone
        val edgeSet = mutableSetOf<Pair<Char, Char>>()

        for (line in lines) {
            for (i in 0 until line.length - 1) {
                edgeSet.add(Pair(line[i], line[i + 1]))
                sSet.remove(line[i + 1])
            }
        }
        return Pair(sSet, edgeSet)
    }

    // 引数に対して破壊的
    private fun <T> topologicalSort(sSet: MutableSet<T>, edgeSet: MutableSet<Pair<T, T>>): List<T> {
        val sortedList = mutableListOf<T>()
        while (sSet.isNotEmpty()) {
            val node = sSet.first()
            sSet.remove(node)
            sortedList.add(node)
            val edgesThatStartWithTheNode = edgeSet.filter { edge -> edge.first == node } // == でいい？
            for (edge in edgesThatStartWithTheNode) {
                edgeSet.remove(edge)
                val destNode = edge.second
                if (edgeSet.none { e -> e.second == destNode }) {
                    sSet.add(destNode)
                }
            }
        }
        if (edgeSet.isNotEmpty()) {
            throw Exception("閉路がある")
        }
        return sortedList
    }
}
