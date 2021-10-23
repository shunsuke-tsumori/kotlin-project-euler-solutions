package com.example.kotlinpesolutions

import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.InputStreamReader

@Component
class HelloComponent {
    fun solve() {
        val resourceStream = ClassPathResource("test.txt").inputStream
        val reader = BufferedReader(InputStreamReader(resourceStream))
        val input = reader.readLine().toInt()
        println(input)
        for (i in 1..input) {
            val nums = reader.readLine().split(" ").map { it.toInt() }
            println(nums)
        }
    }
}
