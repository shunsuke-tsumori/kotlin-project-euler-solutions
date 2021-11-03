/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.solver.PeSolver
import org.springframework.stereotype.Component

@Component
class P026Solver : PeSolver {
    override fun run(): Int {
        val bound = 1000
        var maxLength = 0
        var maxProducer = 0

        for (i in 1 until bound) {
            val thePair = repeatingDecimal(1, i)
            if (thePair.second.size > maxLength) {
                maxLength = thePair.second.size
                maxProducer = i
            }
        }
        return maxProducer
    }

    /**
     * m / n
     * @return (循環前, 循環部)
     */
    fun repeatingDecimal(m: Int, n: Int): Pair<List<Int>, List<Int>> {
        val quotients = mutableListOf<Int>()
        val surpluses = mutableListOf<Int>()
        var mDivided = m
        while (true) {
            val quotient = mDivided / n
            quotients.add(quotient)
            val surplus = mDivided % n
            if (surplus == 0) {
                return Pair(quotients, listOf())
            } else {
                val positionLoopStart = surpluses.indexOf(surplus)
                if (positionLoopStart >= 0) {
                    return Pair(
                        quotients.subList(0, positionLoopStart + 1),
                        quotients.subList(positionLoopStart + 1, quotients.size)
                    )
                }
                surpluses.add(surplus)
                mDivided = 10 * surplus
            }
        }
    }
}
