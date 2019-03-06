package com.kfzx.javabasic.test;

/**
 * 使用while、do-while和for循环打印1-1000之间的所有数
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/3/4
 */
public class OneToThousandNumber {
	private static final int MAX = 1000;

	public static void main(String[] args) {
		oneToThousandNumberWithWhile();
		oneToThousandNumberWithDoWhile();
		oneToThousandNumberWithFor();
	}

	/**
	 * 使⽤while循环打印1-1000之间的所有数
	 */
	private static void oneToThousandNumberWithWhile() {
		int i = 1;
		while (i <= MAX) {
			System.out.println("oneToThousandNumberWithWhile: " + i);
			i++;
		}
	}

	/**
	 * 使⽤do-while循环打印1-1000之间的所有数
	 */
	private static void oneToThousandNumberWithDoWhile() {
		int i = 1;
		do {
			System.out.println("oneToThousandNumberWithDoWhile: " + i);
			i++;
		} while (i <= MAX);
	}

	/**
	 * 使⽤for循环打印1-1000之间的所有数
	 */
	private static void oneToThousandNumberWithFor() {
		for (int i = 1; i <= MAX; i++) {
			System.out.println("oneToThousandNumberWithFor: " + i);
		}
	}
}
