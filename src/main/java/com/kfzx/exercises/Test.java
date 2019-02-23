package com.kfzx.exercises;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/25
 */
public class Test {
	static int result = 0;

	public static void main(String[] args) {
		int n = 3;
		result = fun1(n);
		System.out.println("result = " + result);
	}

	private static int fun(int n) {
		if (n == 1 || n == 2) {
			return n;
		}
		return fun(n - 1) + fun(n - 2);
	}

	private static int fun1(int n) {
		int preOne = 1;
		int preTwo = 2;
		if (n==1|| n==2){
			return n;
		}
		for (int i = 3;i<=n;i++){
			result = preOne + preTwo;
			preOne = preTwo;
			preTwo = result;
		}
		return result;
	}
}
