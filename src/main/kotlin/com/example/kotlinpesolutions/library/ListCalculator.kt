/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.library

interface ListCalculator {
    fun <T> permutations(list: List<T>): List<List<T>>
    fun <T> duplicateCombinations(list: List<T>, length: Int): List<List<T>>
}
