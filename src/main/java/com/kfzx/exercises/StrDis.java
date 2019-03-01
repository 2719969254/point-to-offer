package com.kfzx.exercises;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 字符串距离
 * <p>
 * 给定一个字符串str，和一个字母ch，请实现相应的代码求出一个数组，使数组中每个数字表示该位置与字母ch之间的最短距离。
 * 比如str=”lexinfintech”  ch=”i”
 * 则输出为：[3,2,1,0,1,1,0,1,2,3,4,5]
 * <p>
 * 输入例子1:
 * lexinfintech
 * i
 * <p>
 * 输出例子1:
 * [3,2,1,0,1,1,0,1,2,3,4,5]
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/28
 */
public class StrDis {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		char c = scanner.nextLine().charAt(0);


		int[] arr = new int[str.length()];
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			char c1 = str.charAt(i);
			if (c1 == c) {
				index = i;
			}
		}
		for (int i = 0; i < str.length(); i++) {
			int num1 = Math.abs(str.charAt(i) - c);
			int num2 = Math.abs(i - index);
			if (num1 <= num2) {
				arr[i] = num1;
			} else {
				arr[i] = num2;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
