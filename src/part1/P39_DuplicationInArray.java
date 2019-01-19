package part1;

import java.util.Arrays;

/**
 * 在一个长度为n的数组里的所有数字都在0~n-1的范围内。数组中某些数字的重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如输入长度为七的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出重复数字为数字2或数字3
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/19
 */
public class P39_DuplicationInArray {
	public static void main(String[] args) {
		P39_DuplicationInArray duplicationInArray = new P39_DuplicationInArray();
		int[] array = {1,2,1,4,5,6,6};
		System.out.println("duplicationInArray.getDuplication1(array) = " + duplicationInArray.getDuplication1(array));
		System.out.println("duplicationInArray.getDuplication2(array) = " + duplicationInArray.getDuplication2(array));
		System.out.println("duplicationInArray.getDuplication3(array) = " + duplicationInArray.getDuplication3(array));
		System.out.println("duplicationInArray.getDuplication4(array) = " + duplicationInArray.getDuplication4(array));
		System.out.println("duplicationInArray.getDuplication5(array) = " + duplicationInArray.getDuplication5(array));
	}

	/**
	 * 思路一：暴力破解，不会修改原来的数据
	 * 时间复杂度为 O(n^2)，空间复杂度为 O(1)
	 */
	public int getDuplication1(int[] array) {
		if (array == null || array.length < 2) {
			return -1;
		}
		for (int i = 0; i < array.length; ++i) {
			for (int j = i + 1; j < array.length; ++j) {
				if (array[i] == array[j]) {
					return array[i];
				}
			}
		}
		return -1;
	}

	/**
	 * 思路二：先对数组进行排序，再从排序后的数组中找到重复的数字
	 * 时间复杂度为 O(nlogn)，空间复杂度为 O(1)
	 */
	public int getDuplication2(int[] array) {
		if (array == null || array.length < 2) {
			return -1;
		}
		Arrays.sort(array);
		// 进行比较
		int prev = array[0];
		for (int i = 1; i < array.length; ++i) {
			if (array[i] == prev) {
				return prev;
			} else {
				prev = array[i];
			}
		}
		return -1;
	}

	/**
	 * 利用hash表，不修改原数组数据，需要一个大小为 O(n)的hash表为代价
	 * 时间复杂度 O(n),空间复杂度 O(n)
	 *
	 * @param array
	 * @return
	 */
	public int getDuplication3(int[] array) {
		if (array == null || array.length < 2) {
			return -1;
		}
		// 申请一个与array同样大小的内存空间
		int[] hashTable = new int[array.length];
		for (int i : array) {
			// 如果hashTable内部已经有值，说明这个值已经重复了
			if (hashTable[i] != 0) {
				return i;
			} else {
				hashTable[i] = i;
			}
		}
		return -1;
	}

	/**
	 * 从头到尾扫描这个数组的每一个数字，扫描到数组为i的值时，首先比较这个数字是不是等于i。
	 * 如果是，继续扫描
	 * 如果不是，则再拿它和地m个数字比较，如果值一样，则找到重复数字，如果值不相等，就交换数组地i个和地m个数字，
	 * 继续重复这个比较
	 * 时间复杂度： O(n) 空间复杂度 O(1)
	 */
	public int getDuplication4(int[] array) {
		if (array == null || array.length < 2) {
			return -1;
		}
		for (int i = 0; i < array.length; ++i) {
			while (array[i] != i) {
				if (array[i] == array[array[i]]) {
					return array[i];
				} else {
					int temp = array[i];
					array[i] = array[temp];
					array[temp] = temp;
				}
			}
		}
		return -1;
	}

	/**
	 * 题目改动：在一个长度为n+1的数组里，所有数字都在1~n的范围内，求重复的任意一个数字
	 * 把从1~n的数字从中间数字m分成两部分，前面部分为1~m，后面部分为m+1~n。
	 * 如果前一部分的数目超过m，则这一版的区间里肯定有重复的数字，否则，另一半一定有重复的数字，
	 * 就这样一直划分，直到找到重复数字
	 * 时间复杂度： O(nlogn) 空间复杂度：O(1)   以时间换空间
	 */
	public int getDuplication5(int[] array) {
		if (array == null || array.length < 2) {
			return -1;
		}
		int start = 1;
		int end = array.length - 1;
		while (end >= start) {
			int middle = ((end - start) >> 1) + start;
			int count = countRange(array, start, middle);
			if (end == start) {
				if (count > 1) {
					return start;
				} else {
					return -1;
				}
			}
			if (count > (middle - start + 1)) {
				end = middle;
			} else {
				start = middle + 1;
			}
		}
		return -1;
	}

	private int countRange(int[] array, int start, int end) {
		int count = 0;
		for (int i = 0; i < array.length; ++i) {
			if (array[i] >= start && array[i] <= end) {
				++count;
			}
		}
		return count;
	}
}
