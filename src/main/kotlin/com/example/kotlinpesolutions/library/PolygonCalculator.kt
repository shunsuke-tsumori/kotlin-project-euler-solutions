/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.library

interface PolygonCalculator {
    fun triangle(n: Int): Long
    fun isTriangle(n: Long): Boolean
    fun square(n: Int): Long
    fun isSquare(n: Long): Boolean
    fun pentagonal(n: Int): Long
    fun isPentagonal(n: Long): Boolean
    fun hexagonal(n: Int): Long
    fun isHexagonal(n: Long): Boolean
    fun heptagonal(n: Int): Long
    fun isHeptagonal(n: Long): Boolean
    fun octagonal(n: Int): Long
    fun isOctagonal(n: Long): Boolean
}
