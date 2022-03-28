plugins {
    kotlin("jvm")
}

group = "til.dudu"
version = "2.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":module-common"))
}