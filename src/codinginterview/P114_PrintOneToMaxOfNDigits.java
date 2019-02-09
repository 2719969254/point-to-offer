package codinginterview;

/**
 * 打印从1到最大的n位数
 * <p>
 * 如输入2，打印1,2......98,99
 * 注意：本题需要考虑大数问题，用字符串解决大数问题是最好的解决方案之一
 * 用字符串表示数字的时候，最直观的方法就是字符串里每个字符都是‘0’到‘9’之间的某一个字符，用来表示数字中的一位。因为最大的是n位的，
 * 因此我们需要一个长度为n+1的字符串（字符串中最后一个是结束符号‘\0’。当实际数字不够n位的时候，在字符串的前半部分补0）。
 * <p>
 * 首先我们把字符串中的每一个数字都初始化为‘0’，然后每一次为字符串表示的数字加1，再打印出来。
 * 故我们只需要做两件事：一是在字符串表达数字上模拟加法，二是把字符串表达的数字打印出来。
 * <p>
 * 在字符串表达数字上模拟加法，我们首先设置是否溢出标识，是否进位标识，以及取得字符数组长度，遍历这个字符数组，在末尾进行+1操作，
 * 如果末尾字符在+1后变为不小于10的数字，我们将末尾减去10加上‘0’字符赋值为末位，进位标识设置为1，在循环次位时+1，
 * 然后再判断是否为不小于10，是的话重复上面的步骤。
 * 直到判断高位是不是不小于10，是的话字符数组溢出；
 * 如果末尾字符在+1后是小于10的数字，直接加上‘0’赋值给末尾，跳出当前循环，返回没有溢出。
 * <p>
 * 在字符串表达的数字打印出来方法时，没有什么特别，直接利用for循环遍历输出字符数组，
 * 但是要从高位第一个不是0的开始输出。
 * <p>
 * 同时把问题转化为数字排列的解法，使用递归可以使代码简洁明了。
 * 即：如果在所有的数字前面补0的话，就会发现n位所有的十进制数其实就是n个从0到9的全排列。
 * 也就是说，我们把数字的每一位都从0到9排列一遍，就得到了所有的十进制数。在打印时，数字排在前面的0不打印。
 * <p>
 * 全排列递归实现最容易。数字的每一位都可能是0到9的一个数，然后设置下一位。递归结束的条件就是我们已经设置了数字的最后一位。
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/9
 */
public class P114_PrintOneToMaxOfNDigits {
	private void printToMaxOfDigits(int n) {
		if (n <= 0) {
			System.out.println("输入的n没有意义");
			return;
		}
		// 声明字符数组,用来存放一个大数
		char[] number = new char[n];
		// 放字符0进行初始化
		for (int i = 0; i < number.length; ++i) {
			number[i] = '0';
		}
		// 如果大数自加，直到自溢退出
		while (!incrementNumber(number)) {
			// 打印大数
			printNumber(number);
		}
	}

	private boolean incrementNumber(char[] number) {
		// 判断是否溢出
		boolean isOverflow = false;
		// 判断是否进位
		int nTakeOver = 0;
		int nLength = number.length;
		for (int i = nLength - 1; i >= 0; --i) {
			// 取到第i位的字符转换为数字 +进位符
			int nSum = number[i] - '0' + nTakeOver;
			// 末尾自加1
			if (i == nLength - 1) {
				++nSum;
			}
			if (nSum >= 10) {
				if (i == 0) {
					isOverflow = true;
				} else {
					nSum -= 10;
					nTakeOver = 1;
					number[i] = (char) ('0' + nSum);
				}
			} else {
				number[i] = (char) (nSum + '0');
				break;
			}
		}
		return isOverflow;
	}

	private void printNumber(char[] number) {
		boolean isBeginning0 = true;
		int nLength = number.length;
		for (int i = 0; i < nLength; ++i) {
			if (isBeginning0 && number[i] != '0') {
				isBeginning0 = false;
			}
			if (!isBeginning0) {
				System.out.print(number[i]);
			}
		}
		System.out.println();
	}


	private void printOneToMaxOfDigits(int n) {
		if (n <= 0) {
			System.out.println("输入的n没有意义");
			return;
		}
		char[] number = new char[n];
		for (int i = 0; i < number.length; i++) {
			number[i] = '0';
		}
		for (int i = 0; i < 10; ++i) {
			number[0] = (char) (i + '0');
			printToMaxOfNDigitsRecursively(number, n, 0);
		}
	}

	/**
	 * 利用递归实现1到最大的n位数的全排列
	 */

	private void printToMaxOfNDigitsRecursively(char[] number, int n, int index) {
		if (index == n - 1) {
			printNumber(number);
			return;
		}
		for (int i = 0; i < 10; ++i) {
			number[index + 1] = (char) (i + '0');
			printToMaxOfNDigitsRecursively(number, n, index + 1);
		}
	}


	public static void main(String[] args) {
		P114_PrintOneToMaxOfNDigits printOneToMaxOfNDigits = new P114_PrintOneToMaxOfNDigits();
		printOneToMaxOfNDigits.printToMaxOfDigits(2);
		printOneToMaxOfNDigits.printOneToMaxOfDigits(20);
	}
}
