package com.example.sandbox.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CyclicBarrier;

public class DeadLockTask {

    @Test
    void letsDoSomeDeadLock() {
        Object a = new Object();
        Object b = new Object();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        deadLock(a, b,cyclicBarrier);

        while (true) {}
    }

    private void deadLock(Object a, Object b, CyclicBarrier cyclicBarrier) {
        new Thread(() -> {
            synchronized (a) {

                try {
                    cyclicBarrier.await();
                } catch (Exception ex) {}

                synchronized (b) {}
            }
        }).start();

        new Thread(() -> {
            synchronized (b) {
                try {
                    cyclicBarrier.await();
                } catch (Exception ex) {}

                synchronized (a) {}
            }
        }).start();
    }
}
