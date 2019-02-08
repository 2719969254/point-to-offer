package codinginterview;

/**
 * 在Excel中，用A表示第一列，B表示第二列...Z表示第26列，AA表示第27列，AB表示第28列...依次列推。
 * 请写出一个函数，输入用字母表示的列号编码，输出它是第几列。
 * <p>
 * 思路：这道题实际上考察的是把二十六进制表示成十进制数字，将输入的字符串先转换成字符数组，遍历数组中的每一个字符，
 * 用这个字符减去A再加1就是该位对应的十进制数，然后乘以26的相应次方，最后把这些数加起来就是结果了
 * 十进制是用0-9表示，那么二十六进制就应该用0-25表示，但是这里是A-Z，就相当于1-26，所以算出来的数需要加1
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/8
 */
public class P99_ExcelEncode {
	/**
	 * 将二十六进制转换成十进制
	 *
	 * @param str
	 * @return
	 */
	private int twentysixToDecimal(String str) {
		char[] chars = str.toCharArray();
		int exp = 0;
		int num = 0;
		for (int i = chars.length - 1; i >= 0; i--) {
			num += (chars[i] - 'A' + 1) * Math.pow(26, exp);
			exp++;
		}
		return num;
	}

	/**
	 * 将十进制转换成二十六进制
	 * 使用反向取余的方式将十进制转换成二十六进制
	 *
	 * @param n
	 * @return
	 */
	private StringBuffer decimalToTwentysix(int n) {
		StringBuffer result = new StringBuffer();
		while (n > 0) {
			int remainder = n % 26;
			result.append((char) (remainder + 64));
			n = n / 26;
		}
		return result.reverse();
	}

	public static void main(String[] args) {
		P99_ExcelEncode encode = new P99_ExcelEncode();
		System.out.println("encode.twentysixToDecimal(\"AA\") = " + encode.twentysixToDecimal("AA"));
		System.out.println("encode.decimalToTwentysix(27) = " + encode.decimalToTwentysix(27));
	}
}
