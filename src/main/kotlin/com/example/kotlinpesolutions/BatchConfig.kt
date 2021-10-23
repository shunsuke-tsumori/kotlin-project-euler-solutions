package com.example.kotlinpesolutions

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableBatchProcessing
class BatchConfig(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
    private val theTasklet: TheTasklet,
) {
    @Bean
    fun job(): Job {
        return jobBuilderFactory
            .get("the job")
            .flow(step())
            .end()
            .build()
    }

    @Bean
    fun step(): Step {
        return stepBuilderFactory
            .get("the step")
            .tasklet(theTasklet)
            .build()
    }
}
