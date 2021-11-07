/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.library.impl

import com.example.kotlinpesolutions.library.CombinationCalculator
import org.springframework.stereotype.Component
import java.math.BigInteger

@Component
class CombinationCalculatorImpl : CombinationCalculator {
    override fun getCombinationMemo(n: Int): Map<Pair<Int, Int>, BigInteger> {
        val combinationMemo = mutableMapOf<Pair<Int, Int>, BigInteger>()
        for (m in 1..n) {
            for (r in 0..m) {
                val pair = Pair(m, r)
                when (r) {
                    0, m -> {
                        combinationMemo[pair] = BigInteger.ONE
                    }
                    1 -> {
                        combinationMemo[pair] = BigInteger.valueOf(m.toLong())
                    }
                    else -> {
                        combinationMemo[pair] =
                            combinationMemo[Pair(m - 1, r)]!! + combinationMemo[Pair(m - 1, r - 1)]!!
                    }
                }
            }
        }
        return combinationMemo
    }
}
