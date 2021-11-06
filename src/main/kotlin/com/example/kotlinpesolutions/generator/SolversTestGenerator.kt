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
    val answers = answers()
    val path =
        Paths.get("").toAbsolutePath()
            .toString() + "/src/test/kotlin/com/example/kotlinpesolutions/solver/p001_100/SolversTest.kt"
    createFile(path, answers)
}


private fun answers(): Map<Int, String> {
    val answers = mutableMapOf<Int, String>()
    answers[1] = "233168"
    answers[2] = "4613732"
    answers[3] = "6857"
    answers[4] = "906609"
    answers[5] = "232792560"
    answers[6] = "25164150"
    answers[7] = "104743"
    answers[8] = "23514624000"
    answers[9] = "31875000"
    answers[10] = "142913828922"
    answers[11] = "70600674"
    answers[12] = "76576500"
    answers[13] = "5537376230"
    answers[14] = "837799"
    answers[15] = "137846528820"
    answers[16] = "1366"
    answers[17] = "21124"
    answers[18] = "1074"
    answers[19] = "171"
    answers[20] = "648"
    answers[21] = "31626"
    answers[22] = "871198282"
    answers[23] = "4179871"
    answers[24] = "2783915460"
    answers[25] = "4782"
    answers[26] = "983"
    answers[27] = "-59231"
    answers[28] = "669171001"
    answers[29] = "9183"
    answers[30] = "443839"
    answers[31] = "73682"
    answers[32] = "45228"
    answers[33] = "100"
    answers[34] = "40730"
    answers[35] = "55"
    answers[36] = "872187"
    answers[37] = "748317"
    answers[38] = "932718654"
    answers[39] = "840"
    answers[40] = "210"
    answers[41] = "7652413"
    answers[42] = "162"
    answers[43] = "16695334890"
    answers[44] = "5482660"
    answers[45] = "1533776805"
    answers[67] = "7273"
    return answers
}

private fun createFile(path: String, answers: Map<Int, String>) {
    var text =
"""/*
 * kotlin-pe-solutions
 * Copyright (c) 2021 shunsuke.tsumori
 *
 * Released under the MIT license.
 * see https://opensource.org/licenses/MIT
 */


package com.example.kotlinpesolutions.solver.p001_100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class SolversTest(
"""
    for (key in answers.keys) {
        text += "    @Autowired private val p%03dSolver: P%03dSolver,\n".format(key, key)
    }

    text += ") {\n"

    for (key in answers.keys) {
        val ans = answers[key]
        text +=
"""
    @Test
    @DisplayName("%s")
    fun p%03d() {
        assertEquals("%s", p%03dSolver.run())
    }
""".format(ans, key, ans, key)
    }

    text +=
"""
}
"""
    File(path).writeText(text)
}
