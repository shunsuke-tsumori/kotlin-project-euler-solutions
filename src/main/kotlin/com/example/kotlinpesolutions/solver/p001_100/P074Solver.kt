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

@Component
class P074Solver : ProjectEulerSolver {
    override fun run(): String {
        var count = 0
        for (n in 1..BOUND) {
            if (isNonRepeatLength(n)) {
                count++
            }
        }
        return count.toString()
    }

    private fun isNonRepeatLength(n: Int): Boolean {
        val chain = mutableListOf<Int>()
        var currentNode = n
        while (!chain.contains(currentNode)) {
            chain.add(currentNode)
            currentNode = digitFactorialSum(currentNode)
        }
        return chain.size == NON_REPEAT_LENGTH
    }

    private fun digitFactorialSum(n: Int): Int {
        return n.toString().map { c -> FACTORIAL_MAP[c.digitToInt()]!! }.sum()
    }

    companion object {
        private const val BOUND = 1_000_000
        private const val NON_REPEAT_LENGTH = 60
        private val FACTORIAL_MAP = setUpFactorialMap()

        private fun setUpFactorialMap(): Map<Int, Int> {
            val factorialMap = mutableMapOf<Int, Int>()
            for (i in 0..9) {
                factorialMap[i] = factorial(i)
            }
            return factorialMap
        }

        private fun factorial(n: Int): Int {
            if (n <= 1) {
                return 1
            }
            var f = 1
            for (i in 2..n) {
                f *= i
            }
            return f
        }
    }
}
