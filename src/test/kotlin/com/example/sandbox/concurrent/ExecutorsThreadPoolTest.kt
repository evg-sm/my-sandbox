package com.example.sandbox.concurrent

import org.junit.jupiter.api.Test
import java.util.concurrent.Callable
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class ExecutorsThreadPoolTest {

    private val queue = ConcurrentLinkedQueue<String>()

    init {
        for (i in 0 .. 10) {
            queue.add(i.toString())
        }
    }

    @Test
    fun fixedThreadPool() {
        val executor: ExecutorService = Executors.newFixedThreadPool(10)
        val tasks = mutableListOf<Callable<Unit>>()
        for (i in 0 .. 10) {
            tasks.add(callableTask)
        }
        executor.invokeAll(tasks)
    }

    private val callableTask: Callable<Unit> = Callable {
        println("thread ${Thread.currentThread().name} value ${queue.poll()}")
    }

    @Test
    fun cachedThreadPool() {
        val executor: ExecutorService = Executors.newCachedThreadPool()

        val tasks = mutableListOf<Callable<Unit>>()
        for (i in 0 .. 15) {
            tasks.add(callableTask)
        }

        executor.invokeAll(tasks)

    }
}