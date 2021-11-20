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
class P096Solver : ProjectEulerSolver {
    override fun run(): String {
        val grids = readGrids()

        var sum = 0
        for (grid in grids) {
            solveAPuzzle(grid)
            val numbers = grid.numbers
            sum += (numbers[0][0] * 100 + numbers[0][1] * 10 + numbers[0][2])
        }

        return sum.toString()
    }

    private fun solveAPuzzle(grid: Grid) {
        val numbers = grid.numbers
        recursiveBruteForce(numbers, 0)
    }

    private fun recursiveBruteForce(numbers: MutableList<MutableList<Int>>, currentPosition: Int): Boolean {
        if (currentPosition == 9 * 9) {
            return true
        }
        val currentI = currentPosition % 9
        val currentJ = currentPosition / 9
        if (numbers[currentI][currentJ] != 0) {
            return recursiveBruteForce(numbers, currentPosition + 1)
        }
        for (x in 1..9) {
            if (isOkToApply(x, currentI, currentJ, numbers)) {
                numbers[currentI][currentJ] = x
                if (recursiveBruteForce(numbers, currentPosition + 1)) {
                    return true
                }
            }
        }
        numbers[currentI][currentJ] = 0
        return false
    }

    private fun isOkToApply(x: Int, currentI: Int, currentJ: Int, numbers: List<List<Int>>): Boolean {
        for (k in 0..8) {
            if (numbers[currentI][k] == x) {
                return false
            }
            if (numbers[k][currentJ] == x) {
                return false
            }
        }
        for (i in 0..2) {
            for (j in 0..2) {
                if (numbers[currentI / 3 * 3 + i][currentJ / 3 * 3 + j] == x) {
                    return false
                }
            }
        }
        return true
    }

    private fun readGrids(): List<Grid> {
        val resourceStream = ClassPathResource("params/p96.txt").inputStream

        val reader = BufferedReader(InputStreamReader(resourceStream))

        val lines = reader
            .lines()
            .collect(Collectors.toList())
        reader.close()

        val grids = mutableListOf<Grid>()

        for (i in 0 until lines.size / 10) {
            var display = ""
            val numbers = mutableListOf<MutableList<Int>>()
            for (j in 0..9) {
                val line = lines[10 * i + j]
                if (j == 0) {
                    display = line
                } else {
                    val lineNumbers = line.map { it.digitToInt() }.toMutableList()
                    numbers.add(lineNumbers)
                }
            }
            grids.add(Grid(display, numbers))
        }

        return grids
    }

    private data class Grid(
        var display: String,
        var numbers: MutableList<MutableList<Int>>
    )
}
