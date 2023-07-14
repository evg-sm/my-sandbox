package com.example.sandbox.concurrent

import org.junit.jupiter.api.Test
import java.util.concurrent.Callable
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class ExecutorServiceTest {

    private val queue = ConcurrentLinkedQueue<String>()

    init {
        queue.add("1")
        queue.add("2")
        queue.add("3")
    }

    @Test
    fun test() {
        val executor: ExecutorService = Executors.newFixedThreadPool(10)
        executor.invokeAll(listOf(callableTask, callableTask, callableTask))

    }

    private val callableTask: Callable<Unit> = Callable {
        println(queue.poll())
    }
}