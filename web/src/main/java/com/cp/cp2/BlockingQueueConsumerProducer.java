package com.cp.cp2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueConsumerProducer {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(10);

        ReentrantLock lock = new ReentrantLock(true);

        Condition r = lock.newCondition();

        Condition w = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            try {
                while (true) {
                    if (list.size() == 0) {
                        r.await();
                    }
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread() + "read " + list.get(0));
                    list.remove(0);
                    w.signalAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            lock.lock();

            try {
                 while (true) {
                     if (list.size() == 10) {
                         w.await();
                     }
                     Thread.sleep(1000);
                     list.add(1);
                     System.out.println(Thread.currentThread() + "write " + list.get(0));
                     r.signalAll();
                 }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }).start();
    }
}
