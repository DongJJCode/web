package com.annotation;

/**
 * MetaAnnotation注解类为元注解
 */
public @interface MetaAnnotation {
    //元注解MetaAnnotation设置有一个唯一的属性value
    String value();
}
