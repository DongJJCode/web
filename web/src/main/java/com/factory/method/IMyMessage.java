package com.factory.method;

import java.util.Map;

/**
 *  工厂方法模式——产品接口
 */
public interface IMyMessage {

    Map<String, Object> getMessageParam();

    void setMessageParam(Map<String, Object> messageParam);

    void sendMessage() throws Exception;
}
