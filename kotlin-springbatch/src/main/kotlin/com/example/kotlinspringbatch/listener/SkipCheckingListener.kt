package com.example.kotlinspringbatch.listener

import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener

class SkipCheckingListener : StepExecutionListener {
    override fun beforeStep(stepExecution: StepExecution) {
        TODO("Not yet implemented")
    }

    override fun afterStep(stepExecution: StepExecution): ExitStatus? {
        val exitCode = stepExecution.exitStatus.exitCode
        if (!exitCode.equals(ExitStatus.FAILED) &&
            stepExecution.skipCount > 0
        ) {
            return ExitStatus("COMPLETED WITH SKIPS")
        } else {
            return null
        }
    }
}