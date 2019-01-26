package com.alibaba;

/**
 * 找出一串数字中，n个连续的数之和最大
 * @author kangdongjie
 *
 */
public class Test1 {

	public static void main(String[] args) {
		int array[]={1,2,-10,7,-3,2,7,8,9,21,-22};
		
		m1(array, 4);
		
		
	}
	
	public static void m1(int[] a, int m) {
		
		int max = 0;
		for (int i = 0; i < m; i++) {
			max += a[i];
		}
		
		
		for (int i = 1; i < a.length; i++) {
			int max1 = 0;
			for (int j = i; j < i+m && j < a.length; j++) {
				max1 = max1 + a[j];
			}
			if (max < max1) {
				max = max1;
			}
		}
		
		System.out.println(max);
	}
	
}
