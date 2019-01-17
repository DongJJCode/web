package com.container;

import java.util.LinkedList;
import java.util.List;

/**
 * 自己实现同步容器
 */
public class Container1<T> {

    final private LinkedList<T> lists = new LinkedList<>();

    final private int max = 10;

    private int count = 0;

    public synchronized void put(T t) {
        while (lists.size() == max) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        lists.add(t);
        count++;
        this.notifyAll();
    }

    public synchronized T get() {
        while (lists.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        T r = lists.removeFirst();
        count--;
        this.notifyAll();
        return r;
    }
}
