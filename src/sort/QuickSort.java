package sort;

import java.util.Arrays;


/**
 * 快速排序
 * <p>
 * 快速排序是一种非常高效的排序算法，采用分而治之的思想，把大的拆分成小的，小的拆分成更小的。
 * <p>
 * 原理如下：
 * 对于一组给定的记录，通过一趟排序后，将原序列划分成两部分，其中前一部分的所有记录值均比后一部分记录的小
 * 然后在依次对前后两部分的记录进行排序，递归该过程，直到序列中的所有记录都有序为止
 * <p>
 * 快排的特点如下：
 * 1. 最坏时间复杂度。最坏时间复杂度是指每次区间划分的结果都是基准关键字的左边（或者右边）序列为空，而另一区间中的记录项仅比排序前少了一项，即选择的基准关键字是带牌序列的最大值或者最小值
 * 在这种情况下，需要进行（n-1)次区间划分。对于第K（0<k<n）次区间划分，划分前的序列长度为（n-k+1)，需要进行（n-k)次记录的比较。因此，当k从1到n-1时，进行的比较次数总共为n（n-1)/2
 * 所以，最坏情况下的时间复杂度为O(n^2)
 * <p>
 * 2. 最好时间复杂度。最好的情况是指每次区间的划分结果都是基准关键字左右两边的序列长度相等或相差为一，即选择的基准关键字为待排序的记录中的中间值，此时进行的比较次数为nlogn，
 * 所以，最好的情况下，时间复杂度为O(nlogn)
 * <p>
 * 3.平均时间复杂度。快速排序的平均时间复杂度为O(nlogN)。虽然在最坏情况下的时间复杂度为O(n^2)，但是在所有平均时间复杂度为O(nlogn)的算法中，快速排序的性能是最好的
 * <p>
 * 4.空间复杂度。快排的过程汇中需要一个栈空间来实现递归，当每次对区间的划分都比较均匀的情况下（最好的情况），递归树的最大深度为[logn]+1;
 * 当每次区间划分都有一边为0时(最坏情况），递归树的最大深度为N
 * 在每轮排序结束后比较基准关键字左右的记录数，对记录多的一边想进行排序，此时，栈的最大深度可降低为logn，因此，快速排序的平均时间复杂度为O(logn)
 * <p>
 * 5.基准关键字的选取。基准关键字的选取是决定快排算法性能的管件，常用基准关键字的选取非法有如下
 * ① 三者区取中，三者是指在当前序列中，将其首尾，中间位置上的记录进行比较，选择三者的中值作为关键字，在划分开始前交换序列中的第一个记录与基准关键字的位置
 * ② 取随机数，取left和right之间的一个随机数m用n[m]作为基准关键字
 * <p>
 * 快排与归并排序的原理都是基于分而治之思想，首先把元素分为两组，然后对这两组元素分别排序，最后把两组结合起来
 * 不同点在于：他们进行的分组策略不一样，合并策略也不一样。
 * 归并的分组策略为：假设待排序的元素存放在数组中，那么把数组前一半元素作为一组，把后一半元素作为一组。
 * 快排的分组策略为：根据元素的值来分组，把大于某个值的作为一组，小于某个值的分为一组，该值称为基准
 * 总的来说，这两种算法分组策略越简单，合并策略就越复杂，因为快排已经根据元素大小来分组了，所以合并时只需要把两个分组合并起来就可以
 * 归并则需要对两个有序的数组根据大小合并
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/22
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] array = {38, 65, 97, 76, 13, 27, 49};
		quickSort(array);
		System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
	}

	private static void quickSort(int[] array) {
		sort(array, 0, array.length - 1);
	}

	private static void sort(int[] array, int low, int high) {
		int i, j;
		int index;
		if (low >= high) {
			return;
		}
		i = low;
		j = high;
		index = array[i];
		while (i < j) {
			// 当array[j] >= index时，不断进行j--操作，使array[j] < index
			while (i < j && array[j] >= index) {
				j--;
			}
			// 当array[j] < index时，将array[j]放入array[i]位置，并且放入array[i]指针前移(实现将比index值小的值放在index值前面）
			if (i < j) {
				array[i++] = array[j];
			}
			// 如果array[i]值比index值小，则i++ 继续找数组前面比index值大的数字
			while (i < j && array[i] < index) {
				i++;
			}
			// 将index前比index大的值放在index后面
			if (i < j) {
				array[j--] = array[i];
			}
		}
		array[i] = index;
		// 递归对index前的数据进行排序
		sort(array, low, i - 1);
		// 递归对index后的数据进行排序
		sort(array, i + 1, high);
	}
}
