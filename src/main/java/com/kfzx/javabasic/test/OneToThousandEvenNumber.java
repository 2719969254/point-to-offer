package com.kfzx.javabasic.test;

/**
 * 使⽤for循环打印1-1000之间的所有偶数
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/3/4
 */
public class OneToThousandEvenNumber {
	public static void main(String[] args) {
		for (int i = 2; i <= 1000; i+=2) {
			System.out.println("OneToThousandEvenNumber: " + i);
		}
	}
}
