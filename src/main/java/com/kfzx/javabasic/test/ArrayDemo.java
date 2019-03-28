package com.kfzx.javabasic.test;

import java.util.Arrays;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/3/6
 */
public class ArrayDemo {
	public static void main(String[] args) {
		// 计算数组{3,4,5,7,5,8,9,5,2,4,3}所有元素之和
		int[] arr1 = {3, 4, 5, 7, 5, 8, 9, 5, 2, 4, 3};
		int sum = 0;
		for (int i : arr1) {
			sum += i;
		}
		System.out.println("sum = " + sum);
		// 统计数组{3,4,5,7,5,8,9,5,2,4,3}中有多少个偶数
		int count = 0;
		for (int i : arr1) {
			// 利用位运算进行更加高效的计算。也可以用取余（%）判断
			if ((i & 1) == 0) {
				count++;
			}
		}
		System.out.println("count = " + count);
		// 查找数组{3,4,5,7,5,8,9,5,2,4,3}中从前到后第⼀个5所在的索引是多少
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] == 5) {
				System.out.println(i);
				break;
			}
		}
		// 将数组{3,4,5,7}互换位置进⾏反转，即{3,4,5,7}->{7,5,4,3}
		int[] arr2 = {3, 4, 5, 7};
		for (int i = 0, s = arr2.length; i < s / 2; i++) {
			int temp = arr2[i];
			// s-i-1 中的-1是防止数组越界
			arr2[i] = arr2[s - i - 1];
			arr2[s - i - 1] = temp;
		}
		// 冒泡排序
		for (int i = 0; i < arr1.length - 1; i++) {
			for (int j = 0; j < arr1.length - i - 1; j++) {
				if (arr1[j + 1] < arr1[j]) {
					int temp = arr1[j];
					arr1[j] = arr1[j + 1];
					arr1[j + 1] = temp;
				}
			}
		}
		System.out.println("Arrays.toString(arr1) = " + Arrays.toString(arr1));

		// 将字符串“我爱你中国”反转，保存到字符串中
		String str = "我爱你中国";
		char[] chars = str.toCharArray();
		for (int i = 0, s = chars.length; i < s / 2; i++) {
			char temp = chars[i];
			// s-i-1 中的-1是防止数组越界
			chars[i] = chars[s - i - 1];
			chars[s - i - 1] = temp;
		}
		for (char aChar : chars) {
			System.out.print(aChar);
		}
	}
}
