package com.sort;

import java.util.Arrays;

public class Sort {

    public static void bubbolSort(int[] a) {
        for (int i = 0; i < a.length - 1 ; i++) {
            for (int j = 0; j < a.length - 1 - i ; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }

        }
    }

    public static void fastSort(int[] a, int start, int end) {
       if (start > end) {
           return;
       }

       int key = a[start];
       int i = start;
        for (int j = start + 1; j <= end ; j++) {
            if (a[j] < key) {
                int t = a[j];
                a[j] = a[i + 1];
                a[i + 1] = t;
                i++;
            }
        }

        a[start] = a[i];
        a[i] = key;
        fastSort(a, start, i - 1);
        fastSort(a,i + 1, end);
    }



    public static void main(String[] args) {
        int[] a = {90,80,60,70,50,10,20,40,30};
        //bubbolSort(a);
        qSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void qSort(int[] a, int start, int end) {

        if (start > end) {
            return;
        }
        int key = a[start];
        int i = start;

        for (int j = start + 1; j <= end ; j++) {
            if (a[j] < key) {
                int tmp = a[i+1];
                a[i+1] = a[j];
                a[j] = tmp;
                i++;
            }
        }

        a[start] = a[i];
        a[i] = key;

        qSort(a, start , i -1);
        qSort(a, i+ 1, end);
    }
}
