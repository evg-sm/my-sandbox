package com.example.sandbox.concurrent;

import org.junit.jupiter.api.Test;

public class RobotStepTest {

    final String monitor = "monitor";

    @Test
    void test() throws InterruptedException {
        final String monitor = "monitor";

        new Left().start();
        new Right().start();
    }

    class Left extends Thread {

        public void  run() {
            System.out.println("Left");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notify();
        }

        private synchronized void doWork() {

        }

    }

    class Right extends Thread {

        public void run() {
            System.out.println("Right");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notify();
        }

    }
}