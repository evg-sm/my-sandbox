package com.example.sandbox

import org.junit.jupiter.api.Test
import java.util.concurrent.*


class ExecTest {

    val queue = ConcurrentLinkedQueue<String>()

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

    val callableTask: Callable<Unit> = Callable {
        println(queue.poll())
    }
}