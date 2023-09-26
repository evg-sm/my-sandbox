package com.example.sandbox.kt.crtn

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

fun main11() = runBlocking {
    doWorld()
}

suspend fun doWorld() = coroutineScope {  // this: CoroutineScope
    val o: Job = launch {
        delay(1000L)
        println("World!")
    }
    println("Hello")
}

val i: AtomicInteger = AtomicInteger()

fun main() {
    measureTimeMillis {
        runBlocking {
            repeat(50000) { // launch a lot of coroutines
                launch {
                    i.getAndIncrement()
                }
            }
        }
        println(i.get())
    }
        .also { println("time cost $it") }
}