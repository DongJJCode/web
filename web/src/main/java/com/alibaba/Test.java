package com.alibaba;

import java.util.HashMap;
import java.util.Map;

/**
 * 例如，给定数组 num=[2,7,11,15],target=9,
 * 因为num[0]+num[1]=2+7=9,
 * 打印索引 所有和时目标值的组合
 * @author dongjj
 *
 */
public class Test {
	
	public static void main(String[] args) {
		
		int[] a = {1,6,3,5,4,7,2};
		
		m3(a, 9);
		
	}
	
	/**
	 * 复杂度分析：时间复杂度O(n​2​​)，
	 * 对于每个元素，我们试图通过遍历剩余的数组来发现元素这话费了O(n)O(n)时间，
	 * 因此时间，因此时间复杂度为O（n2).空间复杂度为O(1).
	 * @param a
	 * @param target
	 */
	public static void m1(int[] a, int target) {
		
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if (a[i] + a[j] == target) {
					System.out.println(a[i] + " + " + a[j] + " = " + target);
				}
			}
		}
		
	}
	
	
	
	/**
	 * 时间复杂度O（n）空间复杂度O（n）
	 * @param a
	 * @param target
	 */
	public static void m2(int[] a, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int m = 0; m < a.length; m++) {
			map.put(a[m], m);
		}
		
		for (int i = 0; i < a.length; i++) {
			int other = target - a[i];
			if (map.containsKey(other) && map.get(other)!=i ) {
				System.out.println(a[i] + " + " + other + " = " + target);
				map.remove(a[i]);
			}
		}
		
	}

	
	/**
	 * 时间复杂度O(n),我们只遍历了一次包含N个元素的列表，每次查找哈希表只需要O（1）时间
	 * 空间复杂度O(n).
	 * @param a
	 * @param target
	 */
	public static void m3(int[] a, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < a.length; i++) {
			int other = target - a[i];
			if (map.containsKey(other)) {
				System.out.println(a[i] + " + " + other + " = " + target);
			}
			map.put(a[i], i);
		}
	
	}

}
