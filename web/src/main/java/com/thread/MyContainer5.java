package com.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 *  * 实现一个容器，提供两个方法，add，size
 *  * 写两个线程，线程1添加10个元素到容器，线程2实现监控元素的个数，当个数到5的时候，线程2给出提示并结束
 */
public class MyContainer5 {
    volatile List<Object> list = new ArrayList<>();

    public void add(Object object) {
        list.add(object);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer5 container5 = new MyContainer5();

        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2 启动");
            if (container5.size() != 5) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 结束");
        }, "t2").start();


        new Thread(() -> {
            System.out.println("t1 启动");
            for (int i = 0; i < 10 ; i++) {
                container5.add(new Object());
                System.out.println("add " + i);

                if (container5.size() == 5) {
                    countDownLatch.countDown();
                }

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();
    }
}
