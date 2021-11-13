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
import kotlin.experimental.xor

@Component
class P059Solver : ProjectEulerSolver {
    override fun run(): String {
        val cipher = readDigits()
        var maxScore = 0
        var maxScoreText: List<Byte> = listOf()

        for (c1 in 'a'..'z') {
            for (c2 in 'a'..'z') {
                for (c3 in 'a'..'z') {
                    val decoder = listOf(c1.code.toByte(), c2.code.toByte(), c3.code.toByte())
                    val plainText = decrypt(cipher, decoder)
                    val score = scoreTheText(plainText)
                    if (score > maxScore) {
                        maxScoreText = plainText
                        maxScore = score
                    }
                }
            }
        }
        return maxScoreText.sumOf { it.toInt() }.toString()
    }

    private fun scoreTheText(plainText: List<Byte>): Int {
        var score = 0
        for (b in plainText) {
            if (b < 32 || b.toInt() == 127) {
                return -1
            }
            if (b.toInt().toChar() in 'a'..'z') {
                score++
            }
        }
        return score
    }
//
//    private fun printPlainText(plainText: List<Byte>) {
//        for (b in plainText) {
//            print(b.toInt().toChar())
//        }
//        println()
//    }

    private fun readDigits(): List<Byte> {
        val resourceStream = ClassPathResource("params/p59.txt").inputStream
        val reader = BufferedReader(InputStreamReader(resourceStream))
        val digits = reader
            .readLine()
            .split(",")
            .map { it.toByte() }
        reader.close()
        return digits
    }

    private fun decrypt(cipher: List<Byte>, decoder: List<Byte>): List<Byte> {
        val plainText = mutableListOf<Byte>()
        for (i in cipher.indices) {
            plainText.add(cipher[i] xor decoder[i % decoder.size])
        }
        return plainText
    }
}
