package com.kfzx.javabasic.test;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/3/5
 */
public class SumDemo {
	public static void main(String[] args) {
		test();
		oddNumberSum();
		primeNumberSum();
		evenNumberCount();
		leapYearNumber();
		multiplication();
		printTriangle();
		System.out.println(twoNumberAdd(3, 2));
		System.out.println(twoNumberMul(3, 2));
		System.out.println(twoNumberDiv(3, 2));
		System.out.println(twoNumberSub(3, 2));
		int[] arr = {1,2,3};
	}

	/**
	 * 两个变量减法
	 *
	 * @param i
	 * @param j
	 * @return
	 */
	private static int twoNumberSub(int i, int j) {
		return i - j;
	}

	/**
	 * 两个变量除法
	 *
	 * @param i
	 * @param j
	 * @return
	 */
	private static double twoNumberDiv(double i, double j) {
		double result = 0;
		try {
			result = i / j;
		} catch (NumberFormatException ne) {
			System.out.print("数字格式异常");
		} catch (ArithmeticException ae) {
			System.out.print("算术异常");
		} catch (Exception e) {
			System.out.print("未知异常");
		}

		return result;
	}

	/**
	 * 两个变量乘法
	 *
	 * @param i
	 * @param j
	 * @return
	 */
	private static int twoNumberMul(int i, int j) {
		return i * j;
	}

	/**
	 * 两个变量加法
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	private static int twoNumberAdd(int a, int b) {
		return a + b;
	}

	/**
	 * 打印三角形
	 */
	private static void printTriangle() {
		for (int i = 1; i <= 10; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*" + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * 打印乘法表
	 */
	private static void multiplication() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + "=" + i * j + '\t');
			}
			System.out.println();
		}

	}

	/**
	 * 统计2000年-3000年有多少个闰年
	 */
	private static void leapYearNumber() {
		int leapYear = 0;
		for (int year = 2000; year <= 3000; year++) {
			if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
				leapYear++;
			}
		}
		System.out.println("leapYear = " + leapYear);

	}

	/**
	 * 统计1-100之间有多少个偶数
	 */
	private static void evenNumberCount() {
		int count = 0;
		for (int i = 2; i <= 1000; i += 2) {
			count++;
		}
		System.out.println("count = " + count);
	}

	/**
	 * 求1-1000之间所有素数的和
	 */
	private static void primeNumberSum() {
		int sum = 0;
		for (int i = 1; i <= 1000; i++) {
			if (isPrime(i)) {
				sum += i;
			}
		}
		System.out.println("sum = " + sum);
	}

	/**
	 * 判断是否为素数
	 *
	 * @param i
	 * @return
	 */
	private static boolean isPrime(int i) {
		boolean flag = true;
		for (int j = 2; j <= Math.sqrt(i); j++) {
			if (i % j == 0) {
				flag = false;
			}
		}
		return flag;
	}

	/**
	 * 求1-100之间所有奇数的和
	 */
	private static void oddNumberSum() {
		int sum = 0;
		for (int i = 1; i <= 100; i += 2) {
			sum = sum + i;
		}
		System.out.println("sum = " + sum);
	}

	/**
	 * 验证结果
	 */
	private static void test() {
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			sum = sum + i;
		}
		System.out.println(sum);

		sum = 0;
		for (int i = 0; i < 100; i++) {
			if (!(i % 2 == 0)) {
				continue;
			}
			sum = sum + i;
		}
		System.out.println(sum);
	}
}
