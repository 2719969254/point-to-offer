package com.kfzx.codinginterview;

/**
 * 实现一个函数，输入一个int型整数，输出该数字在计算机中二进制表示形式的1的个数。
 * 例如9->1001,输出2；-3->11111111111111111111111111111101,输出31。
 * <p>
 * 思路：这道题主要考察二进制和位运算，总体思路就是想判断二进制数字的最后一位是不是1，接着将输入整数右移一位，再依次判断
 * 但是这样的话会有一个问题是，如果输入是负数，会一直陷入死循环
 * 为了避免死循环，我们可以不右移数字n，首先把n和1做与运算，判断最低位是不是1，然后把1左移一位，再和n做与运算，就能判断n的次低位是不是1
 * 这样的话，循环次数等于整数二进制的位数，32位的整数需要循环32次，下面的算法中，整数二进制有几个1就只需要循环几次
 * <p>
 * 我们先来分析把一个数字减去一的情况，如果一个整数不等于0，那么该整数的二进制表示至少有一位是1.先假设这个数的最右面一位是1
 * 那么，减去1时，最后一位编程了0，其他位不变。也就是最后一位相当于做了取反操作，由1变成了0.
 * 接下来假设最后一位不是1，是0的情况。如果该整数的二进制表示中，最右边的1位于第m位。那么，减去1时，第m位由1变成了0，而第m位之后的所有0都变成了1，左边的数字则保持不变
 * 比如1100减一变成了1011
 * 在前面两种情况中，我们发现，把一个整数减去1，都是把最右面的1变成0,。如果她的右边还有0，则所有的0变成了1。接下来我们把一个整数和它减去1的结果做位于运算，相当于把他最右边的1变成0。
 * 还是以1100为例，它减去1的结果是1011，两个数字做位运算，结果是1000
 * <p>
 * 经过上面的分析，得出结论：把一个整数减去一，在和原来的数进行位与运算，会把该整数最右边的1变成0，那么，一个整数的二进制表示有几个1就可以进行几次这样的操作
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/8
 */
public class P100_NumberOf1InBinary {
	/**
	 * 遇到负数无法解决
	 *
	 * @param n
	 * @return
	 */
	public int numberOfOne1(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) != 0) {
				count++;
			}
			n = n >> 1;
		}
		return count;
	}

	/**
	 * @param n
	 * @return
	 */
	public int numberOfOne2(int n) {
		int count = 0;
		int flag = 1;
		while (flag != 0) {
			if ((n & flag) != 0) {
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}


	/**
	 * @param n
	 * @return
	 */
	public int numberOfOne3(int n) {
		int count = 0;
		while (n != 0) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}


	public static void main(String[] args) {
		P100_NumberOf1InBinary binary = new P100_NumberOf1InBinary();
		System.out.println("binary.numberOfOne1(2) = " + binary.numberOfOne1(2));
		// 遇到负数开始死循环
		// System.out.println("binary.numberOfOne1(-2) = " + binary.numberOfOne1(-2));

		System.out.println("binary.numberOfOne2(2) = " + binary.numberOfOne2(2));
		System.out.println("binary.numberOfOne2(-2) = " + binary.numberOfOne2(-2));

		System.out.println("binary.numberOfOne3(2) = " + binary.numberOfOne3(7));
		System.out.println("binary.numberOfOne3(-2) = " + binary.numberOfOne3(-7));
	}
}
