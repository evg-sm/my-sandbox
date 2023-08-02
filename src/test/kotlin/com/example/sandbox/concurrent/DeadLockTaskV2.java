package com.example.sandbox.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadLockTaskV2 {

    Object a = new Object();
    Object b = new Object();

    @Test
    void letsDoSomeDeadLock() {
        new One().start();
        new Two().start();
    }

    class One extends Thread {

        @Override
        public void run() {
            synchronized (a) {
                System.out.println("One is use a");

                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("One is wait for b");

                synchronized (b) {
                    System.out.println("One is use b");
                }
            }
        }
    }

    class Two extends Thread {

        @Override
        public void run() {
            synchronized (b) {
                System.out.println("Two is use b");

                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Two is wait for a");

                synchronized (a) {
                    System.out.println("Two is use a");
                }
            }
        }
    }
}
