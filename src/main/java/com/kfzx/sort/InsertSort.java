package com.kfzx.sort;

import java.util.Arrays;

/**
 * 插入排序
 * <p>
 * 对于给定的一组数据，初始时，假设第一个记录自成一格有序序列，其余记录为无需序列。
 * 接着从第二个纪录开始，按照记录的大小，依次将当前处理的记录插入到其之前的有序序列中
 * 直到插到最后一个元素为止
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/22
 */
public class InsertSort {
	public static void insertSort(int[] array) {
		if (array == null) {
			return;
		}
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i;
			if (array[i - 1] > temp) {
				while (j >= 1 && array[j - 1] > temp) {
					array[j] = array[j - 1];
					j--;
				}
			}
			array[j] = temp;
		}
	}

	public static void main(String[] args) {
		int[] array = {38, 65, 97, 76, 13, 27, 49};
		insertSort(array);
		System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
	}
}
