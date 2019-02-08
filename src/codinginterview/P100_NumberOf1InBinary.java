package codinginterview;

/**
 * 实现一个函数，输入一个int型整数，输出该数字在计算机中二进制表示形式的1的个数。
 * 例如9->1001,输出2；-3->11111111111111111111111111111101,输出31。
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
			n = n&(n-1);
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
