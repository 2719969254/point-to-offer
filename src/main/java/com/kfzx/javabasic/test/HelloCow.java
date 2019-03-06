package com.kfzx.javabasic.test;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/3/5
 */
public class HelloCow {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i < 1000; i += 2) {
			sum += i;
		}
		System.out.println("sum = " + sum);
	}
}
