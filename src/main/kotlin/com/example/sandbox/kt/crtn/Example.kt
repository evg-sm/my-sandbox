package com.example.sandbox.kt.crtn

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


suspend fun main1() = coroutineScope {
    launch {
        delay(1000)
        println("Kotlin Coroutines World!")
    }
    println("Hello")
}

fun main() {

    runBlocking {


        launch {
            delay(1002L)
            println("World1!")
            println(Thread.currentThread().name)

            launch {
                println("World3!")
                println(Thread.currentThread().name)

                launch {
                    println("World4!")
                    println(Thread.currentThread().name)
                }
            }
        }
        launch {
            delay(1000L)
            println("World2!")
            println(Thread.currentThread().name)
//        throw Exception()
        }
        println("Hello")
    }

    println("after")
}