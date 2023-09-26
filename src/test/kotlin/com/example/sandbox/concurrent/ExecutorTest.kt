package com.example.sandbox.concurrent

import org.junit.jupiter.api.Test
import java.util.concurrent.Executor

class ExecutorTest {

    @Test
    fun test() {
        val executor: Executor = Executor {
            command: Runnable -> command.run()
        }
        executor.execute { println("1") }

    }


    internal class DirectExecutor : Executor {
        override fun execute(r: Runnable) {
            r.run()
        }
    }

}