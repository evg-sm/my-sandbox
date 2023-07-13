package com.example.sandbox

import mu.KLogging
import org.junit.jupiter.api.Test
import java.util.Base64

class Base64Test {

    companion object: KLogging()

    @Test
    fun test_01() {
        val str = "some string value"

        val encodeToString = Base64.getEncoder().encodeToString(str.toByteArray())
        logger.info { "encodeToString = $encodeToString" }

        val decode: ByteArray = Base64.getDecoder().decode(encodeToString)
        logger.info { "decode = ${String(decode)}" }
    }
}