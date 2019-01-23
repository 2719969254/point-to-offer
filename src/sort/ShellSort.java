package sort;

import java.util.Arrays;

/**
 * 希尔排序
 * <p>
 * 希尔排序也称为缩小增量排序，基本原理是：先将待排序的数组元素分成多个子序列，使得每个子序列的元素个数相对较少，然后对各个子序列分别进行直接插入排序
 * 待整个待排序序列基本有序后，对所有元素进行一次直接插入排序
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/22
 */
public class ShellSort {
	public static void main(String[] args) {
		int[] array = {38, 65, 97, 76, 13, 27, 49};
		shellSort(array);
		System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
	}

	private static void shellSort(int[] array) {
		int length = array.length;
		int j;
		for (int h = length / 2; h > 0; h = h / 2) {
			for (int i = h; i < length; i++) {
				int temp = array[i];
				for (j = i - h; j >= 0; j = j - h) {
					if (temp < array[j]) {
						array[j + h] = array[j];
					} else {
						break;
					}
				}
				array[j + h] = temp;
			}
		}
	}
}
