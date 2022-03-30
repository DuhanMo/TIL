package com.example.kotlinspringbatch.job

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.logging.Logger

@Configuration
class StepNextJobConfiguration(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
) {
    companion object {
        val logger: Logger = Logger.getLogger(StepNextJobConfiguration::class.java.name)
    }

    @Bean
    fun stepNextJob(): Job {
        return jobBuilderFactory["stepNextJob"]
            .start(step1())
            .next(step2())
            .next(step3())
            .build();
    }

    @Bean
    fun step1(): Step {
        return stepBuilderFactory["step1"]
            .tasklet { _, _ ->
                logger.info(">>>>>This is Step1")
                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    fun step2(): Step {
        return stepBuilderFactory["step2"]
            .tasklet { _, _ ->
                logger.info(">>>>>This is Step2")
                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    fun step3(): Step {
        return stepBuilderFactory["step3"]
            .tasklet { _, _ ->
                logger.info(">>>>>This is Step3")
                RepeatStatus.FINISHED
            }
            .build()
    }
}