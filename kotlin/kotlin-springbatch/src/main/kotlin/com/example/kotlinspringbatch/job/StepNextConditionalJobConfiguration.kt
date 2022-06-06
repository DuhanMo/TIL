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
class StepNextConditionalJobConfiguration (
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory
        ){
    companion object {
        val logger: Logger = Logger.getLogger(StepNextJobConfiguration::class.java.name)
    }

    @Bean
    fun stepNextConditionalJob(): Job {
        return jobBuilderFactory["stepNextConditionalJob"]
            .start(conditionalJobStep1())
                .on("FAILED") //FAILED 일 경우
                .to(conditionalJobStep3()) //step3로 이동한다.
                .on("*") //step3의 결과와 상관없이
                .end() //setp3으로 이동하면 Flow가 종료한다.
            .from(conditionalJobStep1()) //setp1으로 부터
                .on("*")//FAILED외에 모든 경우
                .to(conditionalJobStep2()) //step2로 이동한다.
                .next(conditionalJobStep3()) //step2가 정상 종료되면 step3로 이동한다.
                .on("*") //step3의 결과와 상관없이
                .end() //step3로 이동하면 Flow가 종료한다.
            .end() //Job 종료
            .build()
    }

    @Bean
    fun conditionalJobStep1(): Step {
        return stepBuilderFactory["conditionalJobStep1"]
            .tasklet { contribution, _ ->
                logger.info(">>>>>>>>>>This is stepNextConditionalJob Step1")
                /**
                 * ExitStatus를 FAILED로 지정한다.
                 * 해당 status를 보고 flow가 진행된다.
                 */
//                contribution.exitStatus = ExitStatus.FAILED
                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    fun conditionalJobStep2() :Step {
        return stepBuilderFactory["conditionalJobStep2"]
            .tasklet { _, _ ->
                logger.info(">>>>>>>>>>This is stepNextConditionalJob Step2")
                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    fun conditionalJobStep3(): Step{
        return stepBuilderFactory["conditionalJobStep3"]
            .tasklet{_, _ ->
                logger.info(">>>>>>>>>>This is stepNextConditionalJob Step3")
                RepeatStatus.FINISHED
            }
            .build()
    }
}