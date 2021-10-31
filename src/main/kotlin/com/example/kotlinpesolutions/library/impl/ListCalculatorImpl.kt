/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.library.impl

import com.example.kotlinpesolutions.library.ListCalculator
import org.springframework.stereotype.Component

@Component
class ListCalculatorImpl : ListCalculator {
    override fun <T> permutations(list: List<T>): List<List<T>> {
        val permutationsList = mutableListOf<List<T>>()
        list.forEach { currentElem ->
            if (list.size == 1) {
                permutationsList.add(listOf(currentElem))
            } else {
                val next = list.minus(currentElem)
                permutations(next).forEach { nextInnerList ->
                    permutationsList.add(listOf(currentElem).plus(nextInnerList))
                }
            }
        }
        return permutationsList
    }
}
