package com.container;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Container2<T> {


    final private LinkedList<T> lists = new LinkedList<>();
    final private int max = 10;

    private int count = 0;

    ReentrantLock lock = new ReentrantLock();
    private Condition producte = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(T t) {
        try {
            lock.lock();
            while (lists.size() == max) {
                producte.await();
            }
            lists.add(t);
            count++;
            consumer.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T get() {
        T r = null;
        try {
            lock.lock();
            while (lists.size() == 0) {
                consumer.await();
            }
            r = lists.removeFirst();
            count--;
            producte.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return r;
    }
}
