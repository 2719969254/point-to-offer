package com.kfzx.concurrency;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 输入一个数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字。
 * 要求时间复杂度是O(N)。如果有多对数字的和等于输入的数字，输出任意一对即可。
 * 例如输入数组1、2、4、7、11、15和数字15。由于4+11=15，因此输出4和11。
 * <p>
 * 思路一：直接穷举，从数组中任意选取两个数，判定它们的和是否为输入的那个数字。此举复杂度为O(N^2)
 * <p>
 * 优化：采用二分查找。可以将第二个数字的查找时间复杂度用排序算法优化到O(log N)，
 * 这样对于a[i]，都要花O(logN）的时间去查找相对应的sum-a[i]是否在数组中，
 * 总的时间复杂度已降为O(N log N)，且空间复杂度为O(1)。
 * <p>
 * 思路二：如果a[i]在数组中，那么sum-a[i]（a[k])也必然在这个数组中，可以直接寻找a[k]是否在这个数组中，时间复杂度为O(n)
 * 优化：采用hash表对数组进行预处理，可用O(1)的时间复杂度将结果表示出来。但需要经过O(N)时间的预处理，并且用O(N)的空间构造hash表
 * <p>
 * 思路三：相对数组进行排序，时间复杂度为O(N log N)，然后用两个指针i，j，各自指向数组的首尾两端，
 * 令i=0，j=n-1，然后i++，j--，逐次判断a[i]+a[j]?=sum
 * 如果某一刻a[i]+a[j] > sum，则要想办法让sum的值减小，所以此刻i不动，j--
 * 如果某一刻a[i]+a[j] < sum，则要想办法让sum的值增大，所以此刻i++，j不动
 * 所以，数组无序的时候，时间复杂度最终为O(N log N + N)=O(N log N)。
 * 如果原数组是有序的，则不需要事先的排序，直接用两指针分别从头和尾向中间扫描，O(N)搞定，且空间复杂度还是O(1)。
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/16
 */
public class FindTwoNumberForSum {
	/**
	 * 思路二
	 */
	private static void twoSum1(int[] data, int sum) {
		int count = 0;
		Map<Integer, Integer> hashMap = new HashMap<>(data.length);
		for (int i : data) {
			hashMap.put(i, i);
		}
		for (Iterator<Map.Entry<Integer, Integer>> it = hashMap.entrySet().iterator(); it.hasNext(); ) {
			Map.Entry<Integer, Integer> i = it.next();
			int num = sum - i.getKey();
			if (hashMap.containsValue(num)) {
				it.remove();
				System.out.println("twoSum1 = " + i.getKey() + "\t" + num);
				count++;
			}
		}
		if (count == 0) {
			System.out.println("没有满足条件的值");
		}
	}

	/**
	 * 思路三
	 */
	private static void twoSum2(int[] data, int sum) {
		Arrays.sort(data);
		int begin = 0;
		int end = data.length - 1;
		int count = 0;
		while (begin < end) {
			int currSum = data[begin] + data[end];
			if (currSum == sum) {
				System.out.println("twoSum2 = " + data[begin] + "\t" + data[end]);
				count++;
				begin++;
				end--;
			} else {
				if (currSum < sum) {
					begin++;
				} else {
					end--;
				}
			}
		}
		if (count == 0) {
			System.out.println("没有满足条件的值");
		}
	}

	public static void main(String[] args) {
		int[] data = {-1, 1, -2, 7, 11, 15, 2, -4,};
		twoSum1(data, -3);
		twoSum2(data, 0);
	}
}
