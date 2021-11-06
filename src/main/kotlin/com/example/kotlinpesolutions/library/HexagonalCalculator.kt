/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.library

interface HexagonalCalculator {
    fun hexagonal(n: Int): Long
    fun isHexagonal(n: Long): Boolean
}
