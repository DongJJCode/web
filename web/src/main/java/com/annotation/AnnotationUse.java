package com.annotation;


/**
 * 使用之前定义的注解
 * 用反射测试进行测试AnnotationUse标记到AnnotationUse类上
 */
@MyAnnotation
public class AnnotationUse {

    public static void main(String[] args) {

        //这里检查Annotation类是否有注解，这里需要使用反射才能完成对Annotation类的检查
        if (AnnotationUse.class.isAnnotationPresent(MyAnnotation.class)) {
            /**
             * MyAnnotation是一个类，这个类的实例对象annotation是通过反射得到的，这个实例对象是如何创建的呢？
             * 一旦在某个类上使用了@MyAnnotation，那么这个MyAnnotation类的实例对象annotation就会被创建出来了
             */
            MyAnnotation annotation = AnnotationUse.class.getAnnotation(MyAnnotation.class);
            //打印MyAnnotation对象，这里输出的结果为：@com.annotation.MyAnnotation()
            System.out.println(annotation);
        }
    }
}
