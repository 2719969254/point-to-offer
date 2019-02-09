package codinginterview;

/**
 * 定义一个函数，在该函数中可以实现任意两个整数的加法
 * <p>
 * 对于这道题，由于没有限定输入的两个数的范围，所以要按照大数问题来进行处理
 * 由于题目要求是要实现任意两个整数的加法，我们就要考虑如何实现大数的加法，此外，两个数字是任意的，所以要考虑负数
 * 对于大数问题，常用的方法就是使用字符串来表示这个大数，我们可以首先将两个整数用字符串进行表示，然后分别将这两个字符串拆分成对应的字符数组
 * 当两个整数都是正数的时候直接相加结果为正数，同为负数的时候取两者的绝对值相加然后在结果前加一个负号
 * 假若是一正一负，则用两者的绝对值相减，用绝对值大的数减去绝对值小的数，当正数的绝对值大的时候相减的结果为正数
 * 当负数的绝对值大的时候相减的结果为负数，结果为负数时在相减的结果前加一个负号即可
 * 在具体进行相加的时候两个字符数组对应的数字字符相加即可，当有进位的时候做出标记，在更高一位进行相加时再将这个进位加进去
 * 同样在相减的时候有借位的也做出标记，在更高一位相减的时候将这个借位算进去
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/9
 */
@SuppressWarnings("all")
public class P119_TwoNumberAdd {
	private static char[] add(String str1, String str2) {
		char[] char1 = str1.toCharArray();
		char[] char2 = str2.toCharArray();

		int nsum;
		int nTakeOver = 0;
		boolean flag = false;
		char[] num;

		if ((char1[0] == '-' && char2[0] != '-') || (char1[0] != '-' && char2[0] == '-')) {
			// 结果为一正一负
			// char1是负数，char2是正数
			if (char1[0] == '-' && char2[0] != '-') {
				char1 = absNum(char1);
				char2 = absNum(char2);
				// char2大 并且结果为正数
				if (getMaxAbs(char2, char1)) {
					char[] temp = char1;
					char1 = char2;
					char2 = temp;
				} else {
					// char1大 并且结果为负数
					flag = true;
				}
			}
			// char1是正数，char2是负数
			else {
				char1 = absNum(char1);
				char2 = absNum(char2);
				if (getMaxAbs(char2, char1)) {
					// char2的绝对值比char1大 并且结果为负数
					flag = true;
					char[] temp = char1;
					char1 = char2;
					char2 = temp;
				}
				// 否则char1大 并且为正数
			}

			num = new char[char1.length];
			for (int i = char1.length - 1, j = char2.length - 1; i >= 0; i--, j--) {
				if (j >= 0) {
					nsum = char1[i] - char2[j] + nTakeOver;
					if (nsum < 0) {
						// 相减结果小于0 向上借一位
						nTakeOver = -1;
						nsum = nsum + 10;
						num[i] = (char) (nsum + '0');
					} else {
						nTakeOver = 0;
						num[i] = (char) (nsum + '0');
					}
				} else {
					nsum = char1[i] + nTakeOver - '0';
					if (nsum < 0) {
						nTakeOver = -1;
						nsum = nsum + 10;
						num[i] = (char) (nsum + '0');
					} else {
						nTakeOver = 0;
						num[i] = (char) (nsum + '0');
					}
				}
			}

		} else {
			// 结果都是正数或都是负数
			// 如果两个都是负数
			if (char1[0] == '-' && char2[0] == '-') {
				char1 = absNum(char1);
				char2 = absNum(char2);
				flag = true;
			}
			if (getMaxAbs(char2, char1)) {
				char[] temp = char1;
				char1 = char2;
				char2 = temp;
			}
			num = new char[char1.length + 1];
			for (int i = char1.length - 1, j = char2.length - 1; i >= 0; i--, j--) {
				if (j >= 0) {
					nsum = char1[i] - '0' + char2[j] - '0' + nTakeOver;
					if (nsum >= 10) {
						// 相加大于等于十 产生进位
						nTakeOver = 1;
						nsum = nsum - 10;
						if (i == 0) {
							num[i + 1] = (char) (nsum + '0');
							num[i] = (char) (nTakeOver + '0');
						}
						num[i + 1] = (char) (nsum + '0');
					} else {
						nTakeOver = 0;
						num[i + 1] = (char) (nsum + '0');
					}
				} else {
					nsum = char1[i] - '0' + nTakeOver;
					if (nsum >= 10) {
						nTakeOver = 1;
						nsum = nsum - 10;
						num[i + 1] = (char) (nsum + '0');
					} else {
						nTakeOver = 0;
						num[i + 1] = (char) (nsum + '0');
					}
				}
			}
		}
		if (flag) {
			char[] temp = new char[num.length + 1];
			temp[0] = '-';
			for (int i = 0; i < num.length; i++) {
				temp[i + 1] = num[i];
			}
			return temp;
		} else {
			return num;
		}

	}

	/**
	 * 对比char1与char2的绝对值大小 如果char1比char2大则返回true
	 * @param char1
	 * @param char2
	 * @return
	 */
	private static boolean getMaxAbs(char[] char1, char[] char2) {

		char1 = absNum(char1);
		char2 = absNum(char2);
		int length1 = char1.length;
		int length2 = char2.length;
		if (length1 > length2) {
			return true;
		}
		if (length1 < length2) {
			return false;
		}
		for (int i = 0; i < length1; i++) {
			if (char1[i] > char2[i]) {
				return true;
			}
			if (char1[i] < char2[i]) {
				return false;
			}
		}
		return true;

	}

	/**
	 * 获得一个数的绝对值
	 *
	 * @param chars
	 * @return
	 */
	private static char[] absNum(char[] chars) {
		if (chars[0] != '-') {
			return chars;
		}
		char[] temp = new char[chars.length - 1];
		for (int i = 1; i < chars.length; i++) {
			temp[i - 1] = chars[i];
		}
		return temp;
	}

	/**
	 * 打印结果
	 */
	private static void printNumber(char[] number) {
		// 如果第一个字符为'-'则先打印出该字符 然后i从1开始遍历该字符数组 从第一个非0字符开始打印该字符数组
		int begin = 0;
		if (number[0] == '-') {
			System.out.print(number[0]);
			begin = 1;
		}
		for (; begin < number.length; begin++) {
			// 需要考虑全部为0的情况
			if ((number[begin] == '0') && (begin == number.length - 1)) {
				System.out.print(0);
				return;
			}
			if (number[begin] != '0') {
				break;
			}
		}
		for (; begin < number.length; begin++) {
			System.out.print(number[begin]);
		}
	}

	public static void main(String[] args) {
		// String num1="1004215696420130001";
		// String num2="123";
		// String num1="-1004215696420130001";
		// String num2="123";
		// String num1 = "-999";
		// String num2 = "999";
		String num1 = "-899";
		String num2 = "999";
		char[] num = add(num1, num2);
		printNumber(num);
	}
}
