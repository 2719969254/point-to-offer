package com.kfzx.codinginterview;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分
 * <p>
 * 思路一：运用快速排序的思想，设置前后两个指针，分别从数组的前后两端开始遍历，前指针遇到偶数，后指针遇到奇数交换之。
 * <p>
 * 思路二：因为快速排序是不稳定的排序，而题目要求稳定性。那么就要考虑冒泡排序和插入排序了。冒泡排序无非是交换前偶后奇的情况，插入排序是找到一个奇数插入到第一个偶数前面
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/19
 */
public class P129_ReorderArray {
	/**
	 * 思路一
	 *
	 * @param data
	 */
	private static void reorder(int[] data) {
		if (data.length <= 0 || data == null) {
			return;
		}
		int left = 0;
		int right = data.length - 1;
		while (left < right) {
			// 向后移动，直到它指向偶数
			while (left < right && !isEven(data[left])) {
				left++;
			}
			// 向前移动，直到它指向奇数
			while (left < right && isEven(data[right])) {
				right--;
			}
			if (left < right) {
				data[left] = data[left] ^ data[right];
				data[right] = data[left] ^ data[right];
				data[left] = data[left] ^ data[right];

			}
		}
	}

	/**
	 * 思路二
	 *
	 * @param array
	 */
	private static void reOrderArray(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		for (int i = 0; i < array.length; i++) {
			// 如果找到奇数
			if (!isEven(array[i])) {
				int temp = array[i];
				int j = i - 1;
				// 将奇数插入到第一个偶数前面
				while (j >= 0 && isEven(array[j])) {
					array[j + 1] = array[j];
					j--;
				}
				array[j + 1] = temp;
			}
		}

	}

	private static boolean isEven(int num) {
		return (num & 1) == 0;
	}

	public static void main(String[] args) {
		int[] data = {1, 2, 3, 4, 5, 7, 7};
		reOrderArray(data);
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print('\t');
		}
		System.out.println();
	}
}
