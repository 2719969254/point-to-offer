package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * <p>
 * 冒泡排序顾名思义就是整个过程像气泡一样上升，单向冒泡排序的基本思想是：
 * 对于给定n个记录，从第一个记录开始依次对相邻的两个记录进行比较，当前面的记录大于后面的记录时，交换位置
 * 进行一轮比较和交换后，n个记录中的最大记录将会位于第n位
 * 然后对前(n-1)位进行比较，重复该过程直到记录只剩一个为止
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/22
 */
public class BubbleSort {
	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = array.length - 1; j > i; j--) {
				if (array[j] < array[j - 1]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] array = {38, 65, 97, 76, 13, 27, 49};
		bubbleSort(array);
		System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
	}
}
