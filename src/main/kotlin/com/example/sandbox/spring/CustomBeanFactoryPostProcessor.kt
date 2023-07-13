package com.example.sandbox.spring

import mu.KLogging
import org.springframework.beans.factory.config.BeanFactoryPostProcessor
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.stereotype.Component

@Component
class CustomBeanFactoryPostProcessor: BeanFactoryPostProcessor {

    companion object: KLogging()

    override fun postProcessBeanFactory(beanFactory: ConfigurableListableBeanFactory) {
        logger.info { "!!! CustomBeanFactoryPostProcessor is running" }
    }
}