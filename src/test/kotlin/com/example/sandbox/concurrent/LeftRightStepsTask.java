package com.example.sandbox.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class LeftRightStepsTask {

    @Test
    void letsDoSomeSteps() {
        StepHolder stepHolder = new StepHolder(true, new AtomicInteger(0));

        new Thread(new Left(stepHolder)).start();
        new Thread(new Right(stepHolder)).start();

        while (true) {
            if (stepHolder.count.get() == 6) {
                return;
            }
        }
    }

    static class StepHolder {
        private boolean b;
        final private AtomicInteger count;

        public StepHolder(boolean b, AtomicInteger count) {
            this.b = b;
            this.count = count;
        }

        public void setB(boolean b) {
            this.b = b;
        }
    }

    static class Left implements Runnable {

        final private StepHolder stepHolder;

        public Left(StepHolder stepHolder) {
            this.stepHolder = stepHolder;
        }

        @Override
        public void run() {
            synchronized (stepHolder) {
                while (stepHolder.b) {

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("Left");
                    stepHolder.setB(false);
                    stepHolder.count.getAndIncrement();

                    try {
                        stepHolder.notify();
                        stepHolder.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    static class Right implements Runnable {

        final private StepHolder stepHolder;

        public Right(StepHolder stepHolder) {
            this.stepHolder = stepHolder;
        }

        @Override
        public void run() {
            synchronized (stepHolder) {
                while (!stepHolder.b) {

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("Right");
                    stepHolder.setB(true);
                    stepHolder.count.getAndIncrement();

                    try {
                        stepHolder.notify();
                        stepHolder.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}