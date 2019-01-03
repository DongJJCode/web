package com.adapter;

/**
 *  目标接口
 */
public interface ClassTarget {

    /**
     *  这是源类ClassAdaptee也有的方法
     */
    void sampleOperation1();

    /**
     *  这是源类ClassAdaptee没有的方法
     */
    void sampleOperation2();
}
