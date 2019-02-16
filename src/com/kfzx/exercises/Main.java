package com.kfzx.exercises;

public class Main {
	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	public static void main(String[] args) {
		int n = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 6; k++) {
					//填空位置  其中一个骰子上的数字等于另外两个的和
					if ((i == j + k) || (j == i + k) || (k == i + j)) {
						n++;
					}
				}
			}
		}

		int m = gcd(n, 6 * 6 * 6);
		System.out.println(n / m + "/" + 6 * 6 * 6 / m);
	}

}
