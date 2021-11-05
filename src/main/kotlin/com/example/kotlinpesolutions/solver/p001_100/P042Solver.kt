/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import com.example.kotlinpesolutions.library.StringCalculator
import com.example.kotlinpesolutions.solver.ProjectEulerSolver
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.InputStreamReader

@Component
class P042Solver(
    private val stringCalculator: StringCalculator
) : ProjectEulerSolver {
    override fun run(): String {
        val resourceStream = ClassPathResource("params/p42.txt").inputStream
        val reader = BufferedReader(InputStreamReader(resourceStream))
        val line = reader.readLine()!!
        reader.close()

        val nameList = line
            .split(",")
            .map { n -> n.replace("\"", "") }

        // 最長 14 は既知とする
        // 14 * 26 = 364

        val triangles = mutableListOf<Int>()
        for (i in 1..26) {
            triangles.add(i * (i + 1) / 2)
        }
        var count = 0

        for (name in nameList) {
            if (triangles.contains(stringCalculator.alphabeticalValue(name))) {
                count++
            }
        }

        return count.toString()
    }
}
