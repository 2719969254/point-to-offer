package com.kfzx.sort;

import java.util.Arrays;

/**
 * 归并排序
 * <p>
 * 归并排序是利用递归和分治技术将数据序列划分成为越来越小的半子表，再对半子表排序，
 * 最后用递归方法将排序好的半子表合并成越来越大的有序数列。
 * <p>
 * 归并排序中，归是递归的意思，就是递归的将数组折半的分离为单个数组，
 * 如[1,9,4,2]会被拆分为[1,9],[4,2]两个子数组，然后再分为[1],[9],[4],[2]
 * <p>
 * 归并排序中，并就是将分开的数据按从小到大或从大到小的顺序放在一个数组中，
 * 如上面的数组合并为[1,2],[4,9]，然后再合并为[1,2,4,9]
 * <p>
 * 归并排序的原理如下：
 * 对于给定的一组记录，首先将每两个相邻的长度1的字序列进行归并，得到n/2（向上取整）个长度为2或1的有序子序列
 * 再将其两两归并，反复执行此过程，直到得到一个有序序列
 * <p>
 * 所以，归并排序的关键就是两步：
 * 第一步：划分半子表
 * 第二步：合并半子表
 * <p>
 * 以[49,38,65,97,76,13,27]为例
 * 初始关键字为：[49,38],[65,97],[76,13],[27]
 * 一趟归并后  ：[38,49],[65,97],[13,76],[27]
 * 两趟归并后  ：[38,49,65,97],[13,27,76]
 * 三趟归并后  ：[13,27,38,49,65,76,97]
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/22
 */
public class MargeSort {

	public static void main(String[] args) {
		int[] array = {38, 65, 97, 76, 13, 27, 49};
		int p = 0;
		int r = array.length - 1;
		margeSort(array, p, r);
		System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
	}

	private static void margeSort(int[] array, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			margeSort(array, p, q);
			margeSort(array, q + 1, r);
			merge(array, p, q, r);
		}
	}

	private static void merge(int[] array, int p, int q, int r) {
		int i, j, k, n1, n2;
		n1 = q - p + 1;
		n2 = r - q;
		int[] leftArray = new int[n1];
		int[] rightArray = new int[n2];
		for (i = 0, k = p; i < n1; i++, k++) {
			leftArray[i] = array[k];
		}
		for (i = 0, k = q + 1; i < n2; i++, k++) {
			rightArray[i] = array[k];
		}
		for (k = p, i = 0, j = 0; i < n1 && j < n2; k++) {
			if (leftArray[i] > rightArray[j]) {
				array[k] = leftArray[i];
				i++;
			} else {
				array[k] = rightArray[j];
				j++;
			}
		}
		if (i < n1) {
			for (j = i; j < n1; j++, k++) {
				array[k] = leftArray[j];
			}
		}
		if (j < n2) {
			for (i = j; i < n2; i++, k++) {
				array[k] = rightArray[i];
			}
		}
	}
}
