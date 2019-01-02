package com.factory.simple;

public class Test {

    public static void main(String[] args) {
        INoodles iNoodles = SimpleNoodlesFactory.createNoodles(SimpleNoodlesFactory.TYPE_LZ);

        iNoodles.desc();
    }
}
