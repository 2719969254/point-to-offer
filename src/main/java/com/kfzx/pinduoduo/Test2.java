package com.kfzx.pinduoduo;

import java.util.Scanner;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/4/3
 */
@SuppressWarnings("all")
public class Test2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] time = new int[10];
		for (int i = 0; i < 10; i++) {
			time[i] = scanner.nextInt();
		}

		int firstNum = scanner.nextInt();
		int secondNum = scanner.nextInt();
		/*if (firstNum<=secondNum){
			fun(time,firstNum,secondNum);
		}*/
		if (time[0] != 0 && (firstNum == 1 || secondNum == 1)) {
			System.out.println(0);
			return;
		}

		int num1 = 0, num2 = 0, bit = 1;

		if (firstNum <= secondNum) {
			if (time[0] != 0) {
				while (firstNum > 0) {
					if (firstNum - time[0] == 0) {
						break;
					}
					num1 += canUse(time) * bit;
					bit = bit * 10;
					firstNum--;
				}

			} else {
				while (firstNum > 0) {
					if (firstNum - time[0] == 0) {
						break;
					}
					num1 = canUse(time) * bit;
					bit = bit * 10;
					firstNum--;
				}
			}
		}
		bit = 1;
		while (secondNum > 0) {
			for (int i = 1; i < time.length; i++) {
				while (time[i] != 0) {
					time[i]--;
					num2 += i * bit;
					bit = bit * 10;
					secondNum--;
				}
			}
		}
		System.out.println(num1 * num2);

	}



	private static int canUse(int[] time) {
		for (int i = time.length - 1; i >= 0; i--) {
			if (time[i] != 0) {
				time[i]--;
				return i;
			}
		}
		return 0;
	}
}
