import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.4" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
    kotlin("jvm") version "1.6.10" apply false
    kotlin("plugin.spring") version "1.6.10" apply false
    kotlin("plugin.jpa") version "1.6.10" apply false
    kotlin("plugin.allopen") version "1.6.10" apply false
    kotlin("plugin.noarg") version "1.6.10" apply false
}


allprojects {
    group = "til.dudu"
//	version = "0.0.1-SNAPSHOT" /*배포 단위별로 관리하는 것이 좋다*/
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

subprojects { /* 각 모듈에 있는 repositoryes 는 삭제*/
    repositories {
        mavenCentral()
    }
}




