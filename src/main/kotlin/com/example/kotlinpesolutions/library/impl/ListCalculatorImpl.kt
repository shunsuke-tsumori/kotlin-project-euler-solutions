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

    override fun <T> duplicateCombinations(list: List<T>, length: Int): List<List<T>> {
        val combinations = mutableListOf<List<T>>()
        if (length < 1) {
            return combinations
        }
        list.forEach { currentElem ->
            if (length == 1) {
                combinations.add(listOf(currentElem))
            } else {
                duplicateCombinations(list, length - 1).forEach { nextInnerList ->
                    combinations.add(listOf(currentElem).plus(nextInnerList))
                }
            }
        }
        return combinations
    }

    override fun <T> combinations(memberList: List<T>, n: Int): List<List<T>> {
        if (n > memberList.size || 1 > n || memberList.isEmpty()) {
            throw IllegalArgumentException("illegal arg")
        }
        return calculateCombinations(memberList, n, 0)
    }

    private fun <T> calculateCombinations(memberList: List<T>, length: Int, currentIdx: Int): List<List<T>> {
        val combinations = mutableListOf<List<T>>()
        for (i in currentIdx..memberList.size - length) {
            if (length == 1) {
                combinations.add(listOf(memberList[i]))
            } else {
                calculateCombinations(memberList, length - 1, i + 1).forEach { nextList ->
                    combinations.add(listOf(memberList[i]).plus(nextList))
                }
            }
        }
        return combinations
    }
}
