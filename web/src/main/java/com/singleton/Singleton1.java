package com.singleton;

/**
 * 优点：写法简单，在类装载的时候就完成了实例化，避免了线程的问题
 * 缺点：在类装载的时候就完成实例化，没有达到lazy loading的效果。如果从始至终，从未用到这个实例，则造成了内存的浪费。
 */
public class Singleton1 {

    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1(){
    }

    public  static  Singleton1 getInstance(){
        return  INSTANCE;
    }

}
