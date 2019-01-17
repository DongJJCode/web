package com.cp.cp1;


import java.util.concurrent.BlockingQueue;

public class ProducerThread3 extends Thread {

    BlockingQueue<Integer> queue = null;

    public ProducerThread3(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                queue.put(1);
                System.out.println("生产者" + Thread.currentThread().getName() + "生产一件资源," + "当前资源池有" + queue.size() + "个资源");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
