package com.kfzx.exercises;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		int[][] arr = new int[t][4];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < 4; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(fun(arr, i));
		}

	}

	public static String fun(int[][] arr, int i) {

		int num = 6;
		while (arr[i][1] > 0 && num > 0) {
			num = num - 1;
			arr[i][1]--;
			if (num < 0) {
				return "NO";
			}
		}
		while (arr[i][2] > 0 && num > 0) {
			num = num - 2;
			arr[i][2]--;
			if (num < 0) {
				return "NO";
			}
		}
		while (arr[i][3] > 0 && num > 0) {
			num = num - 3;
			arr[i][3]--;
			if (num < 0) {
				return "NO";
			}
		}
		return "YES";
	}
}