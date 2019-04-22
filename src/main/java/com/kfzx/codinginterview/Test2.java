package com.kfzx.codinginterview;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/4/8
 */
public class Test2 {
	public static void main(String[] args) {
		start();
	}

	private static void start() {
		int num1,num2;
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		int n = scanner.nextInt();
		String substring = str.substring(1, str.length() - 1);
		String[] s = substring.split(",");
		List<Integer> list = new LinkedList<>();

		for (num1 = n - 1;num1 < s.length;num1 = num1+n){
			for (num2 = num1;num2>num1-n;num2--){
				list.add(Integer.valueOf(s[num2]));
			}
		}
		for (int i = num1-n+1;i<s.length;i++){
			list.add(Integer.valueOf(s[i]));
		}
		System.out.print("[");
		for (int i = 0;i<list.size();i++){
			if (i<list.size()-1){
				System.out.print(list.get(i)+",");
			}else{
				System.out.print(list.get(i));
			}
		}
		System.out.print("]");
	}
}
