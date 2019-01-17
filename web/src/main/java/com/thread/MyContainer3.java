package com.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/**
 *  * 实现一个容器，提供两个方法，add，size
 *  * 写两个线程，线程1添加10个元素到容器，线程2实现监控元素的个数，当个数到5的时候，线程2给出提示并结束
 */
public class MyContainer3 {
    volatile List<Object> list = new ArrayList<>();

    public void add(Object object) {
        list.add(object);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer3 c = new MyContainer3();

        final Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2 启动" );
                if (c.size() != 5) {
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 结束" );
                lock.notify();
            }
        }, "t2").start();

        new Thread(() -> {
            System.out.println("t1 启动" );
            synchronized (lock) {
                for (int i = 0; i < 10 ; i++) {
                    c.add(new Object());
                    System.out.println("add " + i);

                    if (c.size() == 5) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1").start();


    }
}
