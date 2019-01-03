package com.adapter;

/**
 * 客户端期待一个接口ClassTarget有sampleOperation1和sampleOperation2这两个方法
 * 现在我有一个类ClassAdaptee里面只有一个sampleOperation1方法
 * 既然ClassTarget要两个方法，我现在的ClassAdaptee只有一个方法怎么办？
 * 搞一个适配器，多编出来一个sampleOperation2，就符合ClassTarget的标准了，
 * 由于适配器是ClassTarget接口的实现类，所以可以直接使用适配器作为ClassTarget
 */
public class ClassAdapter extends ClassAdaptee implements ClassTarget {
    /**
     * 这是源类ClassAdaptee没有的方法
     */
    @Override
    public void sampleOperation2() {

    }
}
