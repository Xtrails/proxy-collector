plugins {
    kotlin("multiplatform") version "1.6.20"
    kotlin("plugin.spring") version "1.6.20"
    kotlin("plugin.jpa") version "1.6.20"
    kotlin("plugin.noarg") version "1.6.20"
    id("org.springframework.boot") version "2.5.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    application
}

group = "me.anisi"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.2")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
                implementation("org.jetbrains.kotlin:kotlin-noarg:1.6.20")

                implementation("io.ktor:ktor-server-netty:1.6.7")
                implementation("io.ktor:ktor-html-builder:1.6.7")

                implementation("org.springframework.boot:spring-boot-starter:2.6.6")
                implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.6.6")


                implementation("org.postgresql:postgresql:42.3.4")
                implementation("com.h2database:h2:2.1.212")
                implementation("net.sourceforge.htmlunit:htmlunit:2.60.0")
                implementation("org.jsoup:jsoup:1.14.3")
                implementation("org.openqa.selenium:selenium:0.8.1")
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation("org.springframework.boot:spring-boot-starter-test:2.6.6")
            }
        }
    }
}

application {
    mainClass.set("me.anisi.application.Application")
}