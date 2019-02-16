package com.kfzx.codinginterview;

/**
 * 斐波那契数列
 * 作为最经典的递归题目，斐波那契大家都不会太陌生，但是如果只用递归，会造成很大的时间和空间消耗，所以递归并不是最好的办法，时间复杂度为o(n^2)
 * 我们要避免重复，可以把计算出来的值存储起来，就不用再进行重复计算的，这样的话时间复杂度为O(n)9
 * 我们还可以用等比数列的公式进行计算，时间复杂度为O(nlogn)
 * 最简单的，还可以用通项公式进行计算，实现O(1)的时间复杂度
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/23
 */
public class P74_Fibonacci {
	/**
	 * 利用递归进行求解
	 */
	public static int fibonacci1(int i) {
		if (i <= 0) {
			return 0;
		}
		if (i == 1) {
			return 1;
		}
		return fibonacci1(i - 1) + fibonacci1(i - 2);
	}

	/**
	 * 利用普通循环
	 */
	public static int fibonacci2(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int fibNMinusOne = 0;
		int fibNMinusTwo = 1;
		int fibN = 0;
		for (int i = 2; i <= n; i++) {
			fibN = fibNMinusOne + fibNMinusTwo;
			fibNMinusOne = fibNMinusTwo;
			fibNMinusTwo = fibN;
		}
		return fibN;
	}

	/**
	 * 借助如下数学公式解决问题。矩阵乘法部分，可用递归解决，时间复杂度o(logn)
	 * [ f(n)  f(n-1) ] = [ 1  1 ] ^ n-1   (当n>2)
	 * [f(n-1) f(n-2) ]   [ 1  0 ]
	 * 证明:
	 * [ f(n)  f(n-1) ] = [ f(n-1)+f(n-2)  f(n-1)] = [ f(n-1)  f(n-2)] * [1 1]
	 * [f(n-1) f(n-2) ]   [ f(n-2)+f(n-3)  f(n-2)]   [ f(n-2)  f(n-3)]   [1 0]
	 * 得到如上递推式，所以
	 * [ f(n)  f(n-1) ] = [ f(2)  f(1)] * [1 1]^n-2 = [1 1]^n-1
	 * [f(n-1) f(n-2) ]   [ f(1)  f(0)]   [1 0]       [1 0]
	 */
	public static int fibonacci3(int n) {
		int[][] start = {{1, 1}, {1, 0}};
		return matrixPow(start, n - 1)[0][0];
	}

	public static int[][] matrixPow(int[][] start, int n) {
		if ((n & 1) == 0) {
			int[][] temp = matrixPow(start, n >> 1);
			return matrixMultiply(temp, temp);
		} else if (n == 1) {
			return start;
		} else {
			return matrixMultiply(start, matrixPow(start, n - 1));
		}
	}

	public static int[][] matrixMultiply(int[][] x, int[][] y) {
		int[][] result = new int[x.length][y[0].length];
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < y[0].length; j++) {
				int sum = 0;
				for (int k = 0; k < x[0].length; k++) {
					sum += x[i][k] * y[k][j];
				}
				result[i][j] = sum;
			}
		}
		return result;
	}

	/**
	 * 使用通项公式完成，时间复杂度o(1)
	 * f(n) = (1/√5)*{[(1+√5)/2]^n - [(1-√5)/2]^n}
	 * 推导过程可参考https://wenku.baidu.com/view/57333fe36bd97f192379e936.html
	 */
	public static int fibonacci4(int n) {
		double gen5 = Math.sqrt(5);
		return (int) ((1 / gen5) * (Math.pow((1 + gen5) / 2, n) - Math.pow((1 - gen5) / 2, n)));
	}

	public static void main(String[] args) {
		System.out.println(fibonacci1(13));
		System.out.println(fibonacci2(13));
		System.out.println(fibonacci3(13));
		System.out.println(fibonacci4(13));
	}
}

