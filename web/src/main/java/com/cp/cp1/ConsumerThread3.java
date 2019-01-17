package com.cp.cp1;

import java.util.concurrent.BlockingQueue;

public class ConsumerThread3 extends Thread {

    BlockingQueue<Integer> queue = null;

    public ConsumerThread3(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                queue.take();
                System.out.println("消费者" + Thread.currentThread().getName() + "消耗一件资源," + "当前资源池有" + queue.size() + "个资源");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
