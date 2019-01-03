package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface MyAnnotation1 {
    /**
     * 为注解添加value属性，这个value属性很特殊，如果一个注解中只有一个value属性要设置
     * 那么在设置注解的属性值时，可以忽略属性名和等号不写，直接写属性值，如@SuppressWarnings("deprecation")，
     * 这里MyAnnotation1注解设置了两个String类型的属性，color和value
     * 因为color属性指定有缺省值，value属性又是属于特殊的属性，因为使用MyAnnotation1注解时，
     * 可以这样使用MyAnnotation1注解："@MyAnnotation(color="red",value="xdp")"
     * 也可以这样使用："@MyAnnotation("DongJJ")"，这样写就表示MyAnnotation1注解只有一个value属性要设置，color属性采用缺省值
     * 当一个注解只有一个value属性要是设置时，可以省略"value="的
     * @return
     */

    String color() default "blue";

    //定义一个名称为value的属性
    String value();

    //添加一个int类型数组的属性
    int[] arrayAttr() default {1, 2, 3};

    //添加一个枚举类型的属性，并指定枚举属性的缺省值，缺省值只能从枚举类EumTrafficLamp中定义的枚举对象中取出任意一个作为缺省值
    EumTrafficLamp lamp() default EumTrafficLamp.RED;

    //为注解添加一个注解类型的属性，并制定注解属性的缺省值
    MetaAnnotation annotationAttr() default @MetaAnnotation("xdp");
}
