/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.generator

import java.io.File
import java.nio.file.Paths

fun main() {
    val solved = listOf(
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10,
        11,
        12,
        13,
        14,
        15,
        16,
        17,
        18,
        19,
        20,
        21,
        22,
        23,
        24,
        25,
        26,
        27,
        28,
        29,
        30,
        31,
        32,
        33,
        34,
        35,
        36,
        67
    )
    val path =
        Paths.get("").toAbsolutePath().toString() + "/src/main/kotlin/com/example/kotlinpesolutions/SolverDispatcher.kt"

    generate(solved, path)
}


fun generate(list: List<Int>, path: String) {
    var text =
"""/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions

import com.example.kotlinpesolutions.solver.p001_100.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class SolverDispatcher(
"""

    for (p in list) {
        text +=
"    private val p%03dSolver: P%03dSolver,\n".format(p, p)
    }


    text +=
"""    @Value("\${'$'}{problem}") val problem: Int
) {
    fun run() {
        println("problem: ${'$'}problem")
        when (problem) {
"""

    for (p in list) {
        text +=
"            %d -> println(p%03dSolver.run())\n".format(p, p)
    }

    text +=
"""            else -> println("not yet solved")
        }
    }
}
"""
    File(path).writeText(text)
}
