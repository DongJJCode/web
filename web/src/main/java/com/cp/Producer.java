package com.cp;



import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

    private volatile boolean isRunning = true;

    private BlockingQueue<PCData> queue;

    private static AtomicInteger count = new AtomicInteger();

    private static final int SLEEPTIME = 100;

    public Producer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        PCData data = null;
        Random r = new Random();

        System.out.println("start producer id = " + Thread.currentThread().getId());
        try {
            Thread.sleep(r.nextInt(SLEEPTIME));
            data = new PCData(count.incrementAndGet());
            System.out.println(data + " is put into queue");
            if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                System.out.println("fail to put data : " + data);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

    }

    public void stop() {
        isRunning = false;
    }
}
