/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.library.impl

import org.springframework.stereotype.Component

@Component
class MaximumPathCalculator {
    fun maximumPathValue(numberGrid: List<List<Int>>): Int {
        val maxGrid = mutableListOf<List<Int>>()
        maxGrid.add(numberGrid[0])

        for (i in 1 until numberGrid.size) {
            val currentRow = numberGrid[i]
            val previousMaxList = maxGrid[i - 1]
            val currentMaxList = mutableListOf<Int>()
            currentMaxList.add(previousMaxList[0] + currentRow[0])
            for (j in 1 until i) {
                currentMaxList.add(maxOf(previousMaxList[j - 1], previousMaxList[j]) + currentRow[j])
            }
            currentMaxList.add(previousMaxList[i - 1] + currentRow[i])
            maxGrid.add(currentMaxList)
        }

        return maxGrid[maxGrid.size - 1].maxOrNull()!!
    }
}
