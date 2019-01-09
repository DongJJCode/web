package com.lock;

public class DeadLock {

//    public Object object1 = new Object();
//    public Object object2 = new Object();
//
//    public static void main(String[] args) {
//        DeadLock deadLock = new DeadLock();
//        Thread a = new Thread(() -> {
//            try {
//                while (true) {
//                    synchronized (deadLock.object1) {
//                        System.out.println(Thread.currentThread().getName() + " 锁住 object1");
//                        Thread.sleep(1000);
//                        synchronized (deadLock.object2) {
//                            System.out.println(Thread.currentThread().getName() + " 锁住 object2");
//                        }
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//
//        Thread b = new Thread(() -> {
//            try {
//                while (true) {
//                    synchronized (deadLock.object2) {
//                        System.out.println(Thread.currentThread().getName() + " 锁住 object2");
//                        Thread.sleep(1000);
//                        synchronized (deadLock.object1) {
//                            System.out.println(Thread.currentThread().getName() + " 锁住 object1");
//                        }
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//
//        a.start();
//        b.start();
//    }

    Object object1 = new Object();
    Object object2 = new Object();

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        new Thread(() -> {
            while (true) {
                synchronized (deadLock.object1) {
                    System.out.println(Thread.currentThread().getName() + "锁住1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (deadLock.object2) {
                        System.out.println(Thread.currentThread().getName() + "锁住2");
                    }
                }
            }
        }).start();


        new Thread(() -> {
            while (true) {
                synchronized (deadLock.object2) {
                    System.out.println(Thread.currentThread().getName() + "锁住2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (deadLock.object1) {
                        System.out.println(Thread.currentThread().getName() + "锁住1");
                    };
                }
            }
        }).start();
    }
}
