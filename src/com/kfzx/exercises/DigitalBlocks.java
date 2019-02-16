package com.kfzx.exercises;

/**
 * 小明最近喜欢搭数字积木，
 * 一共有10块积木，每个积木上有一个数字，0~9。
 * 搭积木规则：
 * 每个积木放到其它两个积木的上面，并且一定比下面的两个积木数字小。
 * 最后搭成4层的金字塔形，必须用完所有的积木。
 * 下面是两种合格的搭法：
 * 0
 * 1 2
 * 3 4 5
 * 6 7 8 9
 * <p>
 * 0
 * 3 1
 * 7 5 2
 * 9 8 6 4
 * <p>
 * 请你计算这样的搭法一共有多少种？
 * 思路：目前只想到暴力，优雅一点的说是全排列，时间复杂度已经达到O(2^n）指数级别,希望有更好的办法能进行优化
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/21
 */
public class DigitalBlocks {
	private static int count = 0;

	public static void main(String[] args) {
		int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		DigitalBlocks digitalBlocks = new DigitalBlocks();
		digitalBlocks.combination(num, 0);
		System.out.println("count = " + count);
	}

	private void combination(int[] arr, int start) {
		if (start == arr.length - 1) {
			if (arr[0] < arr[2] && arr[0] < arr[3] && arr[1] < arr[3] && arr[1] < arr[4] && arr[2] < arr[5]
					&& arr[2] < arr[6] && arr[3] < arr[6] && arr[3] < arr[7]
					&& arr[4] < arr[7] && arr[4] < arr[8]) {
				count++;
			}
		} else {
			for (int i = start; i < arr.length; i++) {
				int temp = arr[i];
				arr[i] = arr[start];
				arr[start] = temp;
				combination(arr, start + 1);
				temp = arr[i];
				arr[i] = arr[start];
				arr[start] = temp;
			}
		}
	}
}
