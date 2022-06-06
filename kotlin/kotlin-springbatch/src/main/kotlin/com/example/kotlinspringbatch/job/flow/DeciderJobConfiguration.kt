package com.example.kotlinspringbatch.job.flow

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.Step
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.job.flow.FlowExecutionStatus
import org.springframework.batch.core.job.flow.JobExecutionDecider
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*
import java.util.logging.Logger

@Configuration
class DeciderJobConfiguration(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
) {
    companion object {
        val logger: Logger = Logger.getLogger(DeciderJobConfiguration::class.java.name)
    }

    @Bean
    fun deciderJob(): Job {
        return jobBuilderFactory["deciderJob"]
            .start(startStep())
            .next(decider()) //홀수 | 짝수 구분
            .from(decider()) //decider의 상태가
                .on("ODD") //ODD라면
                .to(oddStep()) //oddStep으로 간다
            .from(decider()) //decider의 상태가
                .on("EVEN") //EVEN이면
                .to(evenStep()) //evenStep으로 간다
            .end() //Builder 종료
            .build()
    }

    @Bean
    fun startStep(): Step {
        return stepBuilderFactory["startStep"]
            .tasklet { _, _ ->
                logger.info(">>>>>>>>> Start!")
                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    fun evenStep(): Step {
        return stepBuilderFactory["evenStep"]
            .tasklet { _, _ ->
                logger.info(">>>>>>>> 짝수입니다.")
                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    fun oddStep(): Step {
        return stepBuilderFactory["oddStep"]
            .tasklet { _, _ ->
                logger.info(">>>>>>>> 홀수입니다.")
                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    fun decider(): JobExecutionDecider {
        return OddDecider()
    }

    class OddDecider : JobExecutionDecider {
        override fun decide(jobExecution: JobExecution, stepExecution: StepExecution?): FlowExecutionStatus {
            val randomNumber = Random().nextInt(50) + 1
            logger.info("랜덤숫자: $randomNumber")
//            return if (randomNumber % 2 == 0) {
//                FlowExecutionStatus("EVEN")
//            } else {
//                FlowExecutionStatus("ODD")
//            }
            /**
             * Step으로 처리하는게 아니기 때문에 ExitStatus가 아닌 FlowExecutionStatus로 상태를 관리한다
             */
            return when (randomNumber % 2) {
                0 -> FlowExecutionStatus("EVEN")
                else -> FlowExecutionStatus("ODD")
            }
        }

    }
}