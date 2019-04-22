package com.kfzx.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/4/3
 */
public class Test1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int len = scanner.nextInt();
		int[] array = new int[len];
		int[] res = new int[len/2];
		for (int i = 0;i<len;i++){
			array[i] = scanner.nextInt();
		}
		Arrays.sort(array);
		for (int i = 0; i < len / 2; i++) {
			res[i] = array[i]+array[len-i-1];
		}
		Arrays.sort(res);
		System.out.println(res[len/2-1]-res[0]);
	}
}
