/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.PrimeCalculator
import com.example.kotlinpesolutions.solver.PeSolver
import org.springframework.stereotype.Component

@Component
class P035Solver(
    private val primeCalculator: PrimeCalculator
) : PeSolver {
    // TODO うまく解く
    override fun run(): Any {
        return 13 + count3digitsCircularPrimes() + count4digitsCircularPrimes() +
                count5digitsCircularPrimes() + count6digitsCircularPrimes()
    }

    private fun count3digitsCircularPrimes(): Int {
        var sum = 0
        val digitList = listOf(1, 3, 7, 9)
        for (i in digitList) {
            for (j in digitList) {
                for (k in digitList) {
                    if (isProduceCircularPrime(i, j, k)) {
                        sum += 1
                    }
                }
            }
        }
        return sum
    }

    private fun count4digitsCircularPrimes(): Int {
        var sum = 0
        val digitList = listOf(1, 3, 7, 9)
        for (i in digitList) {
            for (j in digitList) {
                for (k in digitList) {
                    for (l in digitList) {
                        if (isProduceCircularPrime(i, j, k, l)) {
                            sum += 1
                        }
                    }
                }
            }
        }
        return sum
    }

    private fun count5digitsCircularPrimes(): Int {
        var sum = 0
        val digitList = listOf(1, 3, 7, 9)
        for (i in digitList) {
            for (j in digitList) {
                for (k in digitList) {
                    for (l in digitList) {
                        for (m in digitList) {
                            if (isProduceCircularPrime(i, j, k, l, m)) {
                                sum += 1
                            }
                        }
                    }
                }
            }
        }
        return sum
    }

    private fun count6digitsCircularPrimes(): Int {
        var sum = 0
        val digitList = listOf(1, 3, 7, 9)
        for (i in digitList) {
            for (j in digitList) {
                for (k in digitList) {
                    for (l in digitList) {
                        for (m in digitList) {
                            for (n in digitList) {
                                if (isProduceCircularPrime(i, j, k, l, m, n)) {
                                    sum += 1
                                }
                            }
                        }
                    }
                }
            }
        }
        return sum
    }

    private fun isProduceCircularPrime(vararg a: Int): Boolean {
        val aList = a.toList()
        for (i in a.indices) {
            val circularList = aList.subList(i, a.size) + aList.subList(0, i)
            if (!primeCalculator.isPrime(toNumber(circularList))) {
                return false
            }
        }
        return true
    }

    private fun toNumber(a: List<Int>): Int {
        return a.reduce { sum, element -> sum * 10 + element }
    }

}
