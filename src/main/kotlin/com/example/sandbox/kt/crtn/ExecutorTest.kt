package com.example.sandbox.kt.crtn

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis


val i1: AtomicInteger = AtomicInteger()
fun main() {
    val fixedThreadPool: ExecutorService = Executors.newFixedThreadPool(10)
    measureTimeMillis {
        for (i in 1..50000)
            fixedThreadPool.execute(Runnable {
                i1.getAndIncrement()
            })
    }.also { println("time cost $it") }
    println(i1)
}
