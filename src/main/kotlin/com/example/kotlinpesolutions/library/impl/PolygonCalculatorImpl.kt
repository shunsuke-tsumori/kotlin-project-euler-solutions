/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.library.impl

import com.example.kotlinpesolutions.library.PolygonCalculator
import org.springframework.stereotype.Component
import kotlin.math.floor
import kotlin.math.sqrt

// cf) https://en.wikipedia.org/wiki/Pentagonal_number

@Component
class PolygonCalculatorImpl
    : PolygonCalculator {
    override fun triangle(n: Int): Long {
        return n * (n + 1L) / 2
    }

    override fun isTriangle(n: Long): Boolean {
        val x = 8 * n + 1
        val m = floor(sqrt(x.toDouble())).toLong()
        return m * m == x
    }

    override fun square(n: Int): Long {
        return n.toLong() * n
    }

    override fun isSquare(n: Long): Boolean {
        val r = floor(sqrt(n.toDouble())).toLong()
        return n == r * r
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

    override fun heptagonal(n: Int): Long {
        return n * (5L * n - 3) / 2
    }

    override fun isHeptagonal(n: Long): Boolean {
        val x = 40 * n + 9
        val m = floor(sqrt(x.toDouble())).toLong()
        return m * m == x && m % 10 == 7L
    }

    override fun octagonal(n: Int): Long {
        return n * (3L * n - 2)
    }

    override fun isOctagonal(n: Long): Boolean {
        val x = 3 * n + 1
        val m = floor(sqrt(x.toDouble())).toLong()
        return m * m == x && m % 3 == 2L
    }

}
