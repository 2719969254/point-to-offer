package com.kfzx.javabasic.test;

public class LogicDemo {
	public static void main(String[] args) {
		System.out.println(!false);
		System.out.println(5 > 3 && 4 > 5);
		int i = 10;

		boolean b = (i-- == 10) || (--i == 9);
		System.out.println(b);
		System.out.println(i);
	}
}