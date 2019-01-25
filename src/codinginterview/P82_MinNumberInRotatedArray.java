package codinginterview;

/**
 * 旋转数组的最小数字
 * <p>
 * 题目要求：
 * 把一个数组最开始的若干个元素搬到末尾成为数组的旋转，如1,2,3,4,5=>3,4,5,1,2；0,1,1,1,1=>1,1,1,0,1；0,1,1,1,1=>1,0,1,1,1。
 * 求一个原本递增的数组旋转后的最小数字。
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/25
 */
public class P82_MinNumberInRotatedArray {

	/**
	 * 解法一：旋转数组中包含两个递增排序的子数组，把begin指向数组第一个数字，eng指向数组最后一个数字
	 * 如果minIndex比begin大，所以最小数一定在midIndex后面，反之，最小数可能就是midIndex或在midIndex前面
	 * 就这样一直循环，直到两个指针距离为一，表示第一个指针已经指向了第一个递增子数列的末尾，第二个子数组的第一个数字就是最小数字
	 * 此时，第二个指针指向的就是这个数字即结果
	 * 还有一些特殊情况，比如把排序数组的前0个元素搬到最后面，及排序数组本身，所以我们把midIndex初始值设置为begin
	 * 还有的特殊情况就是0,1,1,1,1=>1,1,1,0,1；0,1,1,1,1=>1,0,1,1,1这样的，遇到这样的情况就要进行顺序遍历
	 */
	private int min(int[] array) {
		if (array == null || array.length <= 0) {
			return -1;
		}
		int begin = array[0];
		int end = array.length - 1;
		int midIndex = begin;
		while (array[begin] >= array[end]) {
			if (end - begin == 1) {
				return array[end];
			}
			midIndex = (begin + end) / 2;
			// 如果下标为begin，end，minIndex的值不一样，则继续查找
			// 如果下标为begin，end，minIndex的值不一样，则只能顺序遍历查找
			if (array[begin] == array[end] && array[begin] == array[midIndex]) {
				return minInOrder(array, begin, end);
			}
			if (array[midIndex] >= array[begin]) {
				begin = midIndex + 1;
			} else if (array[midIndex] <= array[end]) {
				end = midIndex - 1;
			}
		}
		return array[midIndex];
	}

	private int minInOrder(int[] array, int begin, int end) {
		int min = array[begin];
		for (int i = begin + 1; i <= end; i++) {
			if (min > array[i]) {
				min = array[i];
			}
		}
		return min;
	}

	/**
	 * 解法二 利用二分法，通过观察中间点与左右点的关系，缩小范围，从而找到最小值。
	 * 缩小范围时要注意值相等的情况，尤其是左右中三个值都相等的情况，
	 * 这种特殊情况是无法折半缩小范围的，只能逐步缩小，即左右点各缩进一个单位。
	 */
	private int min2(int[] array) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int mid = 0;
		int right = array.length - 1;

		while (left < right) {
			mid = (left + right) / 2;
			// left < right
			if (array[left] < array[right]) {
				return array[left];
			}
			// left > right
			if (array[left] > array[right]) {
				if (array[mid] >= array[left]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			// left = right
			if (array[left] == array[right]) {
				if (array[left] < array[mid]) {
					left = mid + 1;
				}
				if (array[left] > array[mid]) {
					right = mid;
				}
				if (array[left] == array[mid]) {
					left = left + 1;
					right = right - 1;
				}
			}
		}
		return array[right];

	}

	public static void main(String[] args) {
		P82_MinNumberInRotatedArray array = new P82_MinNumberInRotatedArray();
		int[] data1 = {3, 4, 5, 1, 2};
		int[] data2 = {1, 0, 1, 1, 1};
		int[] data3 = {1, 1, 1, 0, 1};
		int[] data4 = {0, 1, 1, 1, 1};
		System.out.println(array.min(data1));
		System.out.println(array.min(data2));
		System.out.println(array.min(data3));
		System.out.println(array.min(data4));
		System.out.println("---------------------------");
		System.out.println(array.min2(data1));
		System.out.println(array.min2(data2));
		System.out.println(array.min2(data3));
		System.out.println(array.min2(data4));
	}
}
