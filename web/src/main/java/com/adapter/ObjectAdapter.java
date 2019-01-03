package com.adapter;

/**
 * 和类适配器不同，对象适配器采用了委派关系将源角色与适配器角色关联
 */
public class ObjectAdapter {

    private  ObjectAdaptee objectAdaptee;

    public ObjectAdapter(ObjectAdaptee objectAdaptee) {
        this.objectAdaptee = objectAdaptee;
    }

    public void sampleOperation1() {
        this.objectAdaptee.sampleOperation1();
    }

    public void sampleOperation12(){

    }
}
