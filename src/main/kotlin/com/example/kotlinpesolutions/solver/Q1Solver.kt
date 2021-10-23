package com.example.kotlinpesolutions.solver

import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.InputStreamReader

@Component
class Q1Solver : PeSolver {
    override fun run() {
        val resourceStream = ClassPathResource("params/q1.txt").inputStream
        val reader = BufferedReader(InputStreamReader(resourceStream))
        val max = reader.readLine().toInt()
        val (a, b) = reader.readLine().split(" ").map { it.toInt() }
        var sum = 0
        for (i in 1 until max) {
            if (i % a == 0 || i % b == 0) {
                sum += i
            }
        }
        println(sum)
        reader.close()
    }
}
