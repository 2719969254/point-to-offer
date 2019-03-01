package com.kfzx.exercises;

import java.util.Scanner;

/**
 * 给定一个字符串（数字或大小写字母）, 找出最长的对称的子串（如有多个，输出任意一个）。
 * 例如：
 * 输入：“abbaad”
 * 输出：“abba”
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/28
 */
public class MaxReverseStr {
	public static void main(String[] args) {
		String str;
		String maxStr = "";
		Scanner scanner = new Scanner(System.in);
		str = scanner.nextLine();
		if (str == null) {
			return;
		}
		if (str.length() <= 1) {
			maxStr = str;
			System.out.println(maxStr);
			return;
		}
		if (str.length() == 2) {
			if (str.charAt(0) == str.charAt(1)){
				maxStr = str;
			}else {
				maxStr = str.substring(1);
			}
		}else {
			for (int i = 0;i<str.length();i++){
				for (int j = str.length();j>i;j--){
					String subStr = str.substring(i,j);
					if (subStr.equals(new StringBuffer(subStr).reverse().toString())){
						if (subStr.length() > maxStr.length()){
							maxStr = subStr;
						}
					}
				}
			}
		}
		System.out.println(maxStr);

	}
}
