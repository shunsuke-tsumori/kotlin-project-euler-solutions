/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.stereotype.Component
import kotlin.math.abs
import kotlin.math.floor
import kotlin.math.sqrt

@Component
class P085Solver : ProjectEulerSolver {
    override fun run(): String {
        val target = 2_000_000
        var minDiff = Long.MAX_VALUE
        var minDiffArea = 0L

        // width <= height としてよい
        val widthMax = floor(sqrt(sqrt(target * 4.0))).toInt() + 1
        val heightMax = floor(sqrt(target * 4.0)).toInt() + 1
        for (width in 1..widthMax) {
            for (height in width..heightMax) {
                val count = rectangles(width, height)
                val diff = abs(target - count)
                if (diff < minDiff) {
                    minDiff = diff
                    minDiffArea = width.toLong() * height
                }
            }
        }
        return minDiffArea.toString()
    }

    private fun rectangles(w: Int, h: Int): Long {
        return w.toLong() * (w + 1) * h * (h + 1) / 4
    }
}
