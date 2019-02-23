package com.kfzx.codinginterview;

import java.util.Arrays;

/**
 * 对公司所有员工的年龄进行排序，公司总共有几万名员工，要求时间复杂度为O（n）,可使用的空间复杂度为常量大小，不得超过O(n)
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/24
 */
public class P81_AgeSort {
	public static void main(String[] args) {
		int[] a = {51, 2, 6, 8, 9, 5, 7, 8, 9, 4, 5, 6, 1, 4, 7, 51, 48, 47, 46, 64};
		System.out.println("ageSort(a) = " + Arrays.toString(ageSort(a)));
	}

	public static int[] ageSort(int[] array) {
		if (array == null || array.length <= 0) {
			return null;
		}
		final int oldestAge = 99;
		int[] countAge = new int[oldestAge + 1];
		for (int i = 0; i < oldestAge; i++) {
			countAge[i] = 0;
		}

		for (int i = 0; i < array.length; i++) {
			int age = array[i];
			if (age < 0 || age > 99) {
				System.out.println("年龄不合法");
				return null;
			}
			// 遍历传进来的数组，将几岁的年龄存入下标为几的数组，然后几岁的人有几个，格子里的数就是几
			countAge[age]++;
		}
		int curIndex = 0;
		for (int i = 0; i < countAge.length; i++) {
			for (int j = 0; j < countAge[i]; j++) {
				array[curIndex++] = i;
			}
		}
		return array;
	}

}
