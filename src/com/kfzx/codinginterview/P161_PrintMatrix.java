package com.kfzx.codinginterview;

/**
 * 顺时针打印矩阵
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序一次打印出每一个数字。
 * 如果输入如下矩阵：
 * 1    2    3    4
 * 5    6    7    8
 * 9    10   11   12
 * 13   14   15   16
 * <p>
 * 则依次打印出1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10。
 * <p>
 * 此题的任务清晰明了，需要小心的是要考虑清楚边界情况。
 * 上例中，环绕一次后，剩下的矩阵行数为2，列数为2，可以看成一个新的矩阵，继续环绕打印。可见，此题可以用递归解决。
 * 示例中行数与列数是相等的，所以能够组成完整的环（完整指能够环绕一圈）；其实，只要行数和列数中，比较小的那个是偶数，就能够组成完整的环。
 * 如果行数和列数中比较小的那个是奇数，则递归到终止前的剩余元素无法成环。如果较小的是行数，则剩余元素的组成的形状类似于“|”；如果较小的是列数，则剩余元素的组成的形状类似于“—”。
 * 因此，当未访问行数和未访问列数都大于等于2时，按照完整环的逻辑递归访问即可。当不满足上述条件，判断剩余元素是“|”型还是“—”型，然后按照不完整环的逻辑访问即可。
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/16
 */
public class P161_PrintMatrix {
	public static void main(String[] args) {
		int[][] data1 = {
				{1, 2, 3, 4},
				{12, 13, 14, 5},
				{11, 16, 15, 6},
				{10, 9, 8, 7},
		};
		printMatrix(data1);
		int[][] data2 = {
				{1, 2, 3, 4},
				{10, 11, 12, 5},
				{9, 8, 7, 6},
		};
		printMatrix(data2);
		int[][] data3 = {
				{1, 2, 3},
				{10, 11, 4},
				{9, 12, 5},
				{8, 7, 6},
		};
		printMatrix(data3);
	}

	private static void printMatrix(int[][] data) {
		if (data == null) {
			return;
		}
		if (data.length == 0 || data[0].length <= 0) {
			return;
		}
		int rowLen = data.length;
		int colLen = data[0].length;
		int row = 0, col = 0, round = 0;
		while (rowLen - 2 * row > 1 && colLen - 2 * col > 1) {
			for (; col < colLen - round; col++) {
				System.out.print(data[row][col]);
				System.out.print("\t");
			}
			for (col = col - 1, row = row + 1; row < rowLen - round; row++) {
				System.out.print(data[row][col]);
				System.out.print("\t");
			}
			for (row = row - 1, col = col - 1; col > round; col--) {
				System.out.print(data[row][col]);
				System.out.print("\t");
			}
			for (; row > round; row--) {
				System.out.print(data[row][col]);
				System.out.print("\t");
			}
			row++;
			col++;
			round++;
		}
		// 如果行数与列数中较小的那个是偶数，则能组成完整的环，在while中就完成了遍历
		if (rowLen - 2 * row == 0 || colLen - 2 * col == 0) {
			System.out.println();
		}
		// 如果行数与列数中较小的是行数，且是奇数，则还需补充访问一行
		if (rowLen - 2 * row == 1) {
			for (; col < colLen - round; col++) {
				System.out.print(data[row][col]);
				System.out.print("\t");
			}
			System.out.println();
		}

		// 如果行数与列数中较小的是列数，且是奇数，则还需补充访问一列
		if (colLen - 2 * col == 1) {
			for (; row < rowLen - round; row++) {
				System.out.print(data[row][col]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}
}
