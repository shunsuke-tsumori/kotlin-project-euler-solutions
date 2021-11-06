/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.library.impl

import com.example.kotlinpesolutions.library.HexagonalCalculator
import com.example.kotlinpesolutions.library.PentagonalCalculator
import com.example.kotlinpesolutions.library.TriangleCalculator
import org.springframework.stereotype.Component
import kotlin.math.floor
import kotlin.math.sqrt

// cf) https://en.wikipedia.org/wiki/Pentagonal_number

@Component
class TrianglePentagonalHexagonalCalculator
    : TriangleCalculator, PentagonalCalculator, HexagonalCalculator {
    override fun triangle(n: Int): Long {
        return n * (n + 1L) / 2
    }

    override fun isTriangle(n: Long): Boolean {
        val x = 8 * n + 1
        val m = floor(sqrt(x.toDouble())).toLong()
        return m * m == x
    }

    override fun pentagonal(n: Int): Long {
        return n * (3L * n - 1) / 2
    }

    // ∃n st x = n*(3n-1)/2 <=> ∃m 24x+1=m^2 and sqrt(24x+1)=5 mod6
    override fun isPentagonal(n: Long): Boolean {
        val x = 24 * n + 1
        val m = floor(sqrt(x.toDouble())).toLong()
        return m * m == x && m % 6 == 5L
    }

    override fun hexagonal(n: Int): Long {
        return n * (2L * n - 1)
    }

    override fun isHexagonal(n: Long): Boolean {
        val x = 8 * n + 1
        val m = floor(sqrt(x.toDouble())).toLong()
        return m * m == x && m % 4 == 3L
    }

}
