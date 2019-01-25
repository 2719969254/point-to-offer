package codinginterview;

/**
 * 题目：机器人的运动范围
 * 地上有一个m行n列的方格，一个机器人从坐标(0,0)的各自开始移动，它每次可以向上下左右移动一格，但不能进入横纵坐标数位之和大于k的格子。
 * 例如，当k等于18时，机器人能进入(35,37)，因为3+5+3+7=18；但却不能进入(35,38)，因为3+5+3+8=19>18。
 * 请问该机器人能够到达多少个格子。
 * <p>
 * 思路：
 * 每前进一步后，可选移动项为上下左右四个；
 * 为了判断某一个格子是否可以进入从而进行计数，不仅需要考虑边界值，计算各位数字之和，更要判断该格子是否已经被访问过。
 * 所以需要一个布尔矩阵，用来记录各格子是否已被访问。
 * 整体思路与面试题12类似
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/25
 */
public class P92_RobotMove {
	public static int movingCount(int threshold, int rowLen, int colLen) {
		if (threshold < 0 || rowLen < 0 || colLen < 0) {
			return 0;
		}
		boolean[][] visitFlag = new boolean[rowLen][colLen];
		for (int row = 0; row < rowLen; row++) {
			for (int col = 0; col < colLen; col++) {
				visitFlag[row][col] = false;
			}
		}

		return movingCountCore(threshold, rowLen, colLen, 0, 0, visitFlag);
	}

	private static int movingCountCore(int threshold, int rowLen, int colLen, int row, int col, boolean[][] visitFlag) {
		int count = 0;
		if (canGetIn(threshold, rowLen, colLen, row, col, visitFlag)) {
			visitFlag[row][col] = true;
			count = 1 + movingCountCore(threshold, rowLen, colLen, row + 1, col, visitFlag) +
					movingCountCore(threshold, rowLen, colLen, row - 1, col, visitFlag) +
					movingCountCore(threshold, rowLen, colLen, row, col + 1, visitFlag) +
					movingCountCore(threshold, rowLen, colLen, row, col - 1, visitFlag);
		}
		return count;
	}

	private static boolean canGetIn(int threshold, int rowLen, int colLen, int row, int col, boolean[][] visitFlag) {
		return row >= 0 && col >= 0 && row < rowLen && col < colLen && !visitFlag[row][col] && getDigSum(row) + getDigSum(col) <= threshold;
	}

	private static int getDigSum(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(movingCount(0, 3, 4));
		System.out.println(movingCount(1, 3, 4));
		System.out.println(movingCount(9, 2, 20));
	}
}
