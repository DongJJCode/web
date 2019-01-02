package com.factory.method;


import java.util.HashMap;
import java.util.Map;

/**
 * 工厂方法模式——工厂实现
 */
public class MyMessageFactory implements IMyMessageFactory {

    @Override
    public IMyMessage createMessage(String messageType) {

        IMyMessage iMyMessage;

        Map<String, Object> messageParam = new HashMap<>();

        if ("SMS".equals(messageType)) {
            iMyMessage = new MyMessageSms();
            messageParam.put("PHONENUM", "18888888888");
        } else if ("OA".equals(messageType)) {
            iMyMessage = new MyMessageOaTodo();
            messageParam.put("OAUSERNAME", "testUser");
        } else if ("EMAIL".equals(messageType)) {
            iMyMessage = new MyMessageEmail();
            messageParam.put("EMAIL", "test@test.com");
        } else {
            iMyMessage = new MyMessageEmail();
            messageParam.put("EMAIL", "test@test.com");
        }

        return iMyMessage;
    }
}
