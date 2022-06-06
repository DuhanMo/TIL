package com.example.kotlinspringbatch

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableBatchProcessing //배치기능 활성화
@SpringBootApplication
class KotlinSpringbatchApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringbatchApplication>(*args)
}
