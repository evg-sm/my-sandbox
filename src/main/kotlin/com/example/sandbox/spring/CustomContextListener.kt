package com.example.sandbox.spring

import mu.KLogging
import org.springframework.context.ApplicationListener
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class CustomContextListener(val configurableApplicationContext: ConfigurableApplicationContext): ApplicationListener<ContextRefreshedEvent> {

    companion object: KLogging()

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        logger.info { "!!! Context refreshed" }
    }
}