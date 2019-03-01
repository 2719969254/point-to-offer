package com.kfzx.exercises;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/3/1
 */
public class StrRotate {
	public static void main(String[] args) {
		System.out.println(strRotate());
	}

	private static boolean strRotate() {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String[] split = str.split("[;]");
		String str1 = split[0];
		String str2 = split[1];
		int length = str1.length();
		for (int i = 1;i<str1.length();i++){
			if (str2.equals(str1.substring(i,length)+str1.substring(0,i))){
				return true;
			}
		}
		return false;
	}
}
