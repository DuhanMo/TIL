package til.dudu.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EntityScan(basePackages = ["til.dudu.common"])
@EnableJpaRepositories(basePackages = ["til.dudu.common"])
class ApiKotlinApplication

fun main(args: Array<String>) {
    runApplication<ApiKotlinApplication>(*args)
}