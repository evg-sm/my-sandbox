package com.example.sandbox.spring

import mu.KLogging
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.stereotype.Component

@Component
class CustomBeanPostProcessor: BeanPostProcessor {

    companion object: KLogging()

    override fun postProcessBeforeInitialization(bean: Any, beanName: String): Any? {
        if (bean is SomeComponent) {
            logger.info { "taco service $bean" }
        }
        if (beanName == "tacoServiceImpl"){
            logger.info { "taco service $bean" }
        }
        return bean
    }

    override fun postProcessAfterInitialization(bean: Any, beanName: String): Any? {
        if (bean is SomeComponent) {
            logger.info { "taco service $bean" }
        }
        return bean
    }
}