package com.kfzx.javabasic.test;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/3/4
 */
public class IfDemo {
	public static void main(String[] args) {
		int i = 5 > 3 ? 1 : 2;
		System.out.println(i);
		if (5 > 3) {
			System.out.println(1);
		} else {
			System.out.println(2);
		}


		int age = 20;
		if (age < 12) {
			System.out.println("⼉童");
		} else if (age < 18) {
			System.out.println("少年");
		} else if (age < 27) {
			System.out.println("⻘年");
		} else {
			System.out.println("⻄边的太阳快要落⼭了");
		}
		int a = 5;
		if (a > 4) {
			System.out.println("a⼤于4");
		} else {
			System.out.println("a不⼤于4");
		}
		int k = 10;
		if (k % 2 == 0) {
			System.out.println(k + "是偶数");
		} else {
			System.out.println(k + "不是偶数");
		}
	}
}
