package com.example.sandbox.concurrent;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorJTest {
    @Test
    void test() throws InterruptedException {
        var queue = new LinkedBlockingQueue<Runnable>();
        ExecutorService executorService = new ThreadPoolExecutor(5, 10, 10000L, TimeUnit.MINUTES, queue);

        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            tasks.add(() -> {
                Thread.sleep(1000L);
                System.out.println(queue);
                String res = "it's run ! " + Thread.currentThread().getName();
                System.out.println(res);
                return res;
            });
        }

        executorService.invokeAll(tasks);
    }
}
