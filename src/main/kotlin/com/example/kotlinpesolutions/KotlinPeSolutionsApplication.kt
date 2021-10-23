package com.example.kotlinpesolutions

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class KotlinPeSolutionsApplication

fun main(args: Array<String>) {
    runApplication<KotlinPeSolutionsApplication>(*args)
}
