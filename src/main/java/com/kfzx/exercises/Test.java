package com.kfzx.exercises;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/25
 */
public class Test {
	public static void main(String[] args) {
		// 记录阶乘末尾0的个数
		int count = 0;
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		BigInteger mul = new BigInteger(1 + "");
		// 利用BigInteger进行大数相乘
		for (int i = 1; i <= num; i++) {
			mul = mul.multiply(new BigInteger(i + ""));
		}
		String str = mul.toString();
		// 从末尾开始判断0的个数
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == '0') {
				count++;
			} else {
				break;
			}
		}
		System.out.println(count);
	}
}
