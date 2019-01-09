package com.stream;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test {

    public static void main(String[] args) {
        String content = "1234567";

        InputStream in = new ByteArrayInputStream(content.getBytes());
        int ch;

        try {
            while ((ch = in.read()) != -1) {
                System.out.println((char) ch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n" + "-------华丽的分割线------");

        try {
            in.reset();
            while ((ch = in.read()) != -1) {
                System.out.println((char) ch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
