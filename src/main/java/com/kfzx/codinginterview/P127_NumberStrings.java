package com.kfzx.codinginterview;

/**
 * 表示数值的字符串
 * <p>
 * 判断一个字符串是否表示数值，如+100,5e2，-123，-1E-16都是，12e，1e3.14，+-5,1.2.3,12e+5.4都不是。
 * 提示：表示数值的字符串遵循模式A[.[B]][e|EC] 或者 .B[e|EC];A,B,C表示整数，|表示或。[]表示可有可无。
 * <p>
 * 此题也没有没什么特殊思路，就按照A[.[B]][e|EC] 或者 .B[e|EC];A,B,C这两种模式匹配下即可。
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/19
 */
public class P127_NumberStrings {
	public static boolean isNumber(String str) {
		// 正确形式：A[.[B]][e|EC] 或者 .B[e|EC];
		if (str == null || str.length() <= 0) {
			return false;
		}
		int index;
		if (str.charAt(0) != '.') {
			index = scanInteger(str, 0);
			if (index == -1) {
				return false;
			}
			if (index == str.length()) {
				return true;
			}
			if (str.charAt(index) == '.') {
				if (index == str.length() - 1) {
					return true;
				}
				index = scanInteger(str, index + 1);
				if (index == str.length()) {
					return true;
				}
			}

			if (str.charAt(index) == 'e' || str.charAt(index) == 'E') {
				index = scanInteger(str, index + 1);
				if (index == str.length()) {
					return true;
				} else {
					return false;
				}
			}
			return false;
		} else {
			index = scanInteger(str, 1);
			if (index == -1) {
				return false;
			}
			if (index == str.length()) {
				return true;
			}
			if (str.charAt(index) == 'e' || str.charAt(index) == 'E') {
				index = scanInteger(str, index + 1);
				if (index == str.length()) {
					return true;
				}
			}
			return false;
		}
	}

	private static int scanInteger(String str, int index) {
		if (index >= str.length()) {
			return -1;
		}
		if (str.charAt(index) == '+' || str.charAt(index) == '-') {
			return scanUnsignedInteger(str, index + 1);
		} else {
			return scanUnsignedInteger(str, index);
		}
	}

	private static int scanUnsignedInteger(String str, int index) {
		int origin = index;
		while (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
			index++;
			if (index == str.length()) {
				return index;
			}
		}
		if (origin == index) {
			index = -1;
		}
		return index;
	}

	public static void main(String[] args) {
		System.out.println(isNumber("+100"));
		System.out.println(isNumber("5e2"));
		System.out.println(isNumber("-123"));
		System.out.println(isNumber("3.1416"));
		System.out.println(isNumber("-1E-16"));
		System.out.println(isNumber(".6"));
		System.out.println(isNumber("6."));
		System.out.println(isNumber("12e"));
		System.out.println(isNumber("1a3.14"));
		System.out.println(isNumber("1.2.3"));
		System.out.println(isNumber("+-5"));
		System.out.println(isNumber("12e+5.4"));
	}
}
