package com.singleton;

/**
 * 静态内部类的方式在Singleton类被加载时并不会立即实例化，而是在需要实例化的时候，
 * 调用getInstance方法，才会装载SingletonInstance类，从而完成Singleton的实例化
 *
 * 类的静态属性只会在第一次加载类的时候初始化，所以在这里JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
 */
public class Singleton3 {

    private Singleton3(){

    }

    private static class SingletonInstance {
        private static final Singleton3 SINGLETON = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return SingletonInstance.SINGLETON;
    }
}
