package com.annotation;

/**
 * 这里将新创建好的注解类MyAnnotation1标记到MyAnnotationTest1类上
 * 并应用了注解类MyAnnotation中定义的各种不同类型的属性
 */
@MyAnnotation1(
        color = "red",
        value = "DongJJ",
        arrayAttr = {4,5,6},
        lamp = EumTrafficLamp.GREEN,
        annotationAttr = @MetaAnnotation("DJ")
)
public class MyAnnotationTest1 {
    //@MyAnnotation1("将MyAnnotation1注解标注到main方法上")
    public static void main(String[] args) {
        /**
         * 这里检查MyAnnotation类是否有注解，这里需要使用反射才能完成对MyAnnotation类的检查
         */
        if (MyAnnotationTest1.class.isAnnotationPresent(MyAnnotation1.class)) {
            /**
             * 用反射方式获得注解对应的实例对象后，在通过该对象调用属性对应的方法
             * MyAnnotation1是一个类，这个类的实例对象annotation是通过反射得到的
             * 一旦在某个类上使用了@MyAnnotation1，那么这个MyAnnotation类的实例对象annotation就会被创建出来了
             */
            MyAnnotation1 annotation1 = MyAnnotationTest1.class.getAnnotation(MyAnnotation1.class);
            System.out.println(annotation1.color());
            System.out.println(annotation1.value());
            System.out.println(annotation1.arrayAttr());
            System.out.println(annotation1.lamp());
            System.out.println(annotation1.annotationAttr().value());

            MetaAnnotation ma = annotation1.annotationAttr();
            System.out.println(ma.value());
        }
    }
}
