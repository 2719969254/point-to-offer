package com.kfzx.sort;

import java.util.Arrays;

/**
 * 选择排序
 * <p>
 * 选择排序是一种简单直观的排序算法，基本原理如下：
 * 对于给定的一个数组，经过第一轮比较后得到的最小值与第一个记录的位置进行交换；
 * 接着对不包括第一个记录以外的其他记录进行第二轮比较，得到的最小值与第二个记录进行交换
 * 重复这个过程，直到进行比较的值只有一个为止
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/22
 */
public class SelectionSort {
	public static void selectSort(int[] array) {
		int temp;
		int flag;
		int length = array.length;
		for (int i = 0; i < length; i++) {
			temp = array[i];
			flag = i;
			// 进行比较
			for (int j = i + 1; j < length; j++) {
				// 如果后面的值比第一个值大，就把那个值存在temp里，并且将其索引值记录在flag里
				if (array[j] < temp) {
					temp = array[j];
					flag = j;
				}
			}
			// 如果索引值不是开始比较的第一个元素，说明后面一定有比第一个元素小的值
			if (flag != i) {
				array[flag] = array[i];
				array[i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = {5,6,8,2,4,9,5,3};
		selectSort(array);
		System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
	}
}
