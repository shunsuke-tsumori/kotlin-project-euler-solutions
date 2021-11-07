/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.library

import java.math.BigInteger

interface CombinationCalculator {
    /**
     * 0<=r<=m<=n (1<=m) の
     * mCr のメモを取得する。
     */
    fun getCombinationMemo(n: Int): Map<Pair<Int, Int>, BigInteger>
}
