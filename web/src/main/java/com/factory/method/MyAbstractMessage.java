package com.factory.method;

import java.util.Map;

/**
 * 工厂方法模式_虚拟产品类
 */
public abstract class MyAbstractMessage implements IMyMessage {

    private Map<String, Object> messageParam;

    @Override
    public Map<String, Object> getMessageParam() {
        return messageParam;
    }

    @Override
    public void setMessageParam(Map<String, Object> messageParam) {
        this.messageParam = messageParam;
    }

}
