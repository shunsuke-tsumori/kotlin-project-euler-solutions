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
class P014Solver : PeSolver {
    override fun run() {
        val bound = 1_000_000L
        var maxLength = 1
        var maxProducer = 1L
        val lengthMap = mutableMapOf<Long, Int>()
        lengthMap[1] = 1

        for (i in 1..bound) {
            val length = collatzMemoAndGetLength(lengthMap, i)
            if (length > maxLength) {
                maxLength = length
                maxProducer = i
            }
        }

//        println("producer:$maxProducer, length:$maxLength")
        println(maxProducer)
    }

    // assert lengthMap[1] = 1
    private fun collatzMemoAndGetLength(lengthMap: MutableMap<Long, Int>, n: Long): Int {
        if (!lengthMap.containsKey(n)) {
            if (n % 2 == 0L) {
                lengthMap[n] = 1 + collatzMemoAndGetLength(lengthMap, n / 2)
            } else {
                lengthMap[n] = 1 + collatzMemoAndGetLength(lengthMap, n * 3 + 1)
            }
        }
        return lengthMap[n]!!
    }
}
