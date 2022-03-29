package com.example.kotlinspringbatch.job

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.logging.Logger

@Configuration //SpringBatch의 모든 Job은 @Configuration으로 등록해서 사용한다
class SimpleJobConfiguration(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
) {
    companion object {
        val logger: Logger = Logger.getLogger(SimpleJobConfiguration::class.java.name)
    }

    @Bean
    fun simpleJob(): Job {
        return jobBuilderFactory["simpleJob"] //"simplejob" 이란 이름의 BatchJob 생성
            .start(simpleStep1(null))
            .next(simpleStep2(null))
            .build()
    }

    @Bean
    @JobScope
    fun simpleStep1(@Value("#{jobParameters[requestDate]}") requestDate: String?): Step {
        return stepBuilderFactory["simpleStep1"]
            .tasklet { _: StepContribution, _: ChunkContext ->
                logger.info(">>>>>>>>> This is Step1")
                logger.info(">>>>>>>>> requestDate = $requestDate")
                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    @JobScope
    fun simpleStep2(@Value("#{jobParameters[requestDate]}") requestDate: String?): Step {
        return stepBuilderFactory["simpleStep2"]
            .tasklet { _: StepContribution, _: ChunkContext ->
                logger.info(">>>>>>>>> This is Step2")
                logger.info(">>>>>>>>> requestDate = $requestDate")
                RepeatStatus.FINISHED
            }
            .build()
    }
}