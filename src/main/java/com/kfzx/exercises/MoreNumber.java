package com.kfzx.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 查找数组众数
 *
 * 给定一个数组A[n], 定义数组的众数 ( Majority Element) 为数组中出现次数超过 n/2 次的元素,
 * 假设数组A[n]非空且一定存在众数, 请设计算法找到该众数并输出.
 *
 * 一个非空且一定存在众数的整数数组,如: [1,2,2]
 *
 * 输出打印该众数,如: 2
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/28
 */
@SuppressWarnings("all")
public class MoreNumber {
	public static void main(String[] args) {
		int result = moreNumber();
		System.out.println("result = " + result);
	}

	private static int moreNumber() {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String[] arr = str.split("[\\[\\],]");
		int time=0;
		String result = null;

		Map<Integer,Integer> map = new HashMap();
		for(int i = 1; i < arr.length; i++){
			if (map.containsKey(arr[i])){
				map.put(Integer.valueOf(arr[i]),map.get(arr[i])+1);
			}else{
				map.put(Integer.valueOf(arr[i]), 1);
			}
		}

		int max = 0;
		for (Integer integer : map.keySet()) {
			if (integer > max){
				max = integer;
			}
		}
		return max;
	}
}
