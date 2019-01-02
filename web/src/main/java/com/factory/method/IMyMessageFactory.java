package com.factory.method;

/**
 * 工厂方法模式——工厂接口
 */
public interface IMyMessageFactory {

     IMyMessage createMessage(String message);
}
