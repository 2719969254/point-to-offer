package codinginterview;

/**
 * 在一个二维数组中，每一行按照从左到右递增的顺序排列，每一列按照从上到下递增的顺序排列，输入一个二维数组和整数，判断数组中是否含有该整数
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/19
 */
public class P44_FindInPartiallySortedMatrix {
	public static void main(String[] args) {
		int[][] array =
				{
						{1, 2,  8,  9, 10},
						{2, 4,  9, 12, 16},
						{4, 7, 10, 13, 17},
						{6, 8, 11, 15, 18}
				};
		System.out.println(findInPartiallySortedMatrix(array, 18));
		System.out.println(findInPartiallySortedMatrix(array, 5));
	}

	private static boolean findInPartiallySortedMatrix(int[][] array, int num) {
		if (array == null || array.length == 0 || array[0].length == 0) {
			return false;
		}
		// 计算总行数(从0开始)
		int rows = array.length - 1;
		// 计算总列数(从0开始)
		int columns = array[0].length - 1;
		// 设置初始行
		int row = 0;
		// 设置初始列
		int column = columns;
		while (row <= rows && column >= 0) {
			if (array[row][column] == num) {
				return true;
			} else if (array[row][column] > num) {
				--column;
			} else if (array[row][column] < num) {
				++row;
			}
		}
		return false;
	}
}
