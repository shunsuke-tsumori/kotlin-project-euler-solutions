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
    val p = 36
    val path =
        Paths.get("").toAbsolutePath()
            .toString() + "/src/main/kotlin/com/example/kotlinpesolutions/solver/p001_100/P%03dSolver.kt".format(p)
    val text =
"""/*
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
class P%03dSolver : PeSolver {
    override fun run(): Any {
        return 0
    }
}
""".format(p)
    if (File(path).exists()) {
        println("the file exists")
    } else {
        File(path).writeText(text)
        println("created")
    }
}
