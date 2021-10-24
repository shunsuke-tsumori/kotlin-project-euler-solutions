/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.solver.PeSolver
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.stream.Collectors

@Component
class P011Solver : PeSolver {
    override fun run() {
        val resourceStream = ClassPathResource("params/p11.txt").inputStream
        val reader = BufferedReader(InputStreamReader(resourceStream))
        val numberGrid = reader
            .lines()
            .map { line -> line.split(" ").map { it.toLong() } }
            .collect(Collectors.toList())
        reader.close()

        val nRow = numberGrid.size
        val nCol = numberGrid[0].size
        val nAdjacent = 4
        var maxProd = 0L

        // left to right
        for (i in 0 until nRow) {
            for (j in 0..nCol - nAdjacent) {
                var currentProd = 1L
                for (k in 0 until nAdjacent) {
                    currentProd *= numberGrid[i][j + k]
                }
                if (maxProd < currentProd) {
                    maxProd = currentProd
                }
            }
        }

        // down
        for (i in 0..nRow - nAdjacent) {
            for (j in 0 until nCol) {
                var currentProd = 1L
                for (k in 0 until nAdjacent) {
                    currentProd *= numberGrid[i + k][j]
                }
                if (maxProd < currentProd) {
                    maxProd = currentProd
                }
            }
        }

        // right lower
        for (i in 0..nRow - nAdjacent) {
            for (j in 0..nCol - nAdjacent) {
                var currentProd = 1L
                for (k in 0 until nAdjacent) {
                    currentProd *= numberGrid[i + k][j + k]
                }
                if (maxProd < currentProd) {
                    maxProd = currentProd
                }
            }
        }

        // left lower
        for (i in 0..nRow - nAdjacent) {
            for (j in nAdjacent - 1 until nCol) {
                var currentProd = 1L
                for (k in 0 until nAdjacent) {
                    currentProd *= numberGrid[i + k][j - k]
                }
                if (maxProd < currentProd) {
                    maxProd = currentProd
                }
            }
        }

        println(maxProd)
    }
}
