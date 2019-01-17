package com.cp;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {

    public static void main(String[] args) throws  Exception{
        BlockingQueue<PCData> queue = new LinkedBlockingDeque<>(10);

        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        Consumer c3 = new Consumer(queue);

        Producer p1 = new Producer(queue);
        Producer p2 = new Producer(queue);
        Producer p3 = new Producer(queue);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(p1);
        executorService.execute(p2);
        executorService.execute(p3);

        executorService.execute(c1);
        executorService.execute(c2);
        executorService.execute(c3);

        Thread.sleep(1000 * 10);

        p1.stop();
        p2.stop();
        p3.stop();

        Thread.sleep(1000);
        executorService.shutdown();
    }
}
