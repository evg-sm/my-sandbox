package com.example.sandbox.concurrent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CreateNewThreadTaskTest {

    @Test
    void letsCreateAsThread() {
        new SomeThread().start();
    }

    static class SomeThread extends Thread {
        @Override
        public void run() {
            System.out.println("This thread is run!");
        }
    }

    @Test
    void letsCreateAsRunnable1() {
        new Thread(new SomeRunnable()).start();
    }

    @Test
    void letsCreateAsRunnableAsLambda() {
        new Thread(() -> System.out.println("!")).start();
    }

    @Test
    void letsSeeWhatReturnsRunnable() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> future = executorService.submit(new SomeRunnable());
        assertNull(future.get());
    }

    static class SomeRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("This thread is run!");
        }
    }

    @Test
    void letsCreateAsCallable() throws ExecutionException, InterruptedException {
        final Integer expected = 1;
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(new IntegerCallable(expected));
        assertEquals(expected, future.get());
    }

    @Test
    void letsCreateAsCallableWithException() throws ExecutionException, InterruptedException {
        final Integer expected = -1;
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(new IntegerCallable(expected));
        try {
            future.get();
        } catch (Exception ex) {
            Assertions.assertInstanceOf(IllegalArgumentException.class, ex.getCause());
        }
    }

    static class IntegerCallable implements Callable<Integer> {
        private final Integer integer;

        public IntegerCallable(Integer integer) {
            this.integer = integer;
        }

        @Override
        public Integer call() throws IllegalArgumentException {
            if (integer < 0) {
                throw new IllegalArgumentException("IllegalArgumentException");
            }
            return integer;
        }
    }
}
