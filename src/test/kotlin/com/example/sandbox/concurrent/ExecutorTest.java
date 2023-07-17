package com.example.sandbox.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ExecutorTest {

    @Test
    void test1() {
        Executor executor = new ForkJoinPool();

        executor.execute(new SomeRun());
    }

    @Test
    void test2() {
        Executor executor = new ThreadPoolExecutor(5, 10, 10000L, TimeUnit.MINUTES, new LinkedBlockingQueue());

        for (int i = 0; i < 20; i++) {
            executor.execute(new SomeRun());
        }
    }

    class SomeRun implements Runnable {
        @Override
        public void run() {
            System.out.println("it's run ! " + Thread.currentThread().getName());
        }
    }
}
