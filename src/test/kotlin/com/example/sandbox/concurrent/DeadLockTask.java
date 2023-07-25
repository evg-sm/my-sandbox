package com.example.sandbox.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadLockTask {

    private final AtomicInteger atomicInteger = new AtomicInteger(1);

    @Test
    void letsDoSomeDeadLock() {
        Object a = new Object();
        Object b = new Object();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        deadLock(a, b,cyclicBarrier);

        assertEquals(atomicInteger.get(), 2);
    }

    private void deadLock(Object a, Object b, CyclicBarrier cyclicBarrier) {
        new Thread(() -> {
            synchronized (a) {
                atomicInteger.getAndIncrement();
                try {
                    cyclicBarrier.await();
                } catch (Exception ex) {}

                synchronized (b) {
                    atomicInteger.getAndIncrement();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (b) {
                atomicInteger.getAndIncrement();
                try {
                    cyclicBarrier.await();
                } catch (Exception ex) {}

                synchronized (a) {
                    atomicInteger.getAndIncrement();
                }
            }
        }).start();
    }

    @Test
    void letsDoSomeIncrement() {
        Object a = new Object();
        Object b = new Object();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        deadLock(a, b,cyclicBarrier);

        assertEquals(atomicInteger.get(), 1);
    }
}
