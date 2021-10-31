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
class P017Solver : PeSolver {
    override fun run(): Int {
        val numNameMap = mutableMapOf<Int, String>()
        numNameMap[1] = "one"
        numNameMap[2] = "two"
        numNameMap[3] = "three"
        numNameMap[4] = "four"
        numNameMap[5] = "five"
        numNameMap[6] = "six"
        numNameMap[7] = "seven"
        numNameMap[8] = "eight"
        numNameMap[9] = "nine"
        numNameMap[10] = "ten"
        numNameMap[11] = "eleven"
        numNameMap[12] = "twelve"
        numNameMap[13] = "thirteen"
        numNameMap[14] = "fourteen"
        numNameMap[15] = "fifteen"
        numNameMap[16] = "sixteen"
        numNameMap[17] = "seventeen"
        numNameMap[18] = "eighteen"
        numNameMap[19] = "nineteen"
        numNameMap[20] = "twenty"
        numNameMap[30] = "thirty"
        numNameMap[40] = "forty"
        numNameMap[50] = "fifty"
        numNameMap[60] = "sixty"
        numNameMap[70] = "seventy"
        numNameMap[80] = "eighty"
        numNameMap[90] = "ninety"
        numNameMap[100] = "hundred"
        numNameMap[1000] = "thousand"

        var sumUnder10 = 0
        for (i in 1..9) {
            sumUnder10 += numNameMap[i]!!.length
        }

        var sumUnder20 = sumUnder10
        for (i in 10..19) {
            sumUnder20 += numNameMap[i]!!.length
        }

        var sumUnder100 = sumUnder20
        for (i in 2..9) {
            sumUnder100 += (10 * numNameMap[i * 10]!!.length + sumUnder10)
        }

        var sumUnder1000 = sumUnder100
        for (i in 1..9) {
            // i-hundred and xx
            sumUnder1000 += (100 * (numNameMap[i]!!.length + numNameMap[100]!!.length)
                    + 99 * "and".length
                    + sumUnder100)
        }

        return sumUnder1000 + numNameMap[1]!!.length + numNameMap[1000]!!.length
    }
}
