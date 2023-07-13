package com.example.sandbox

import mu.KLogger
import mu.KLogging
import mu.NamedKLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import kotlin.reflect.jvm.jvmName

@EnableScheduling
@SpringBootApplication
class SandboxApplication

val logger: KLogger = NamedKLogging(SandboxApplication::class.jvmName).logger

    fun main(args: Array<String>) {
        runApplication<SandboxApplication>(*args)
        logger.info { "!!! Context started" }
    }
