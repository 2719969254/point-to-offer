package com.kfzx.codinginterview;

import java.util.Arrays;

/**
 * 有两个排序的数组A1和A2，内存在A1的末尾有足够多的空余空间容纳A2。请实现一个函数，把A2中的所有数字插入到A1中并且所有数字是排序的
 * 归并排序的简单实现
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/19
 */
public class P55_InsertArray {
	public static void main(String[] args) {
		Integer[] A1 = new Integer[10];
		//增加一些模拟数据
		for (int i = 0; i < 5; ++i) {
			A1[i] = i + 1;
		}
		Integer[] A2 = {1, 4, 6};
		int len1 = 5, len2 = 3;
		System.out.println("insertArray(A1,A2,len1,len2) = " + insertArray(A1, A2, len1, len2));
	}

	private static String insertArray(Integer[] a1, Integer[] a2, int len1, int len2) {
		int indexOfNew = ((len1--) + (len2--)) - 1;
		while (len1 > 0 && len2 > 0) {
			if (a1[len1] >= a2[len2]) {
				a1[indexOfNew--] = a1[len1--];
			} else {
				a1[indexOfNew--] = a2[len2--];
			}
		}
		//有一个数组指针指向0并完成运算
		while (len1 > 0) {
			a1[indexOfNew--] = a1[len1--];
		}
		while (len2 > 0) {
			a1[indexOfNew--] = a2[len2--];
		}
		return Arrays.toString(a1);
	}
}
