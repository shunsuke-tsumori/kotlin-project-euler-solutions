/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger

@Component
class P013Solver : ProjectEulerSolver {
    override fun run(): String {
        var ans = BigInteger("0")
        val resourceStream = ClassPathResource("params/p13.txt").inputStream
        val reader = BufferedReader(InputStreamReader(resourceStream))
        reader.lines().forEach { line ->
            ans = ans.add(line.toString().toBigInteger())
        }
        reader.close()
        return ans.toString().substring(0, 10).toLong().toString()
    }

}
