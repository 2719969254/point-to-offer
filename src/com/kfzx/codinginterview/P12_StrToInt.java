package com.kfzx.codinginterview;

/**
 * 把一个字符串转换为整数
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/18
 */
public class P12_StrToInt {
	public int strToInt(String str) {
		// 初步判断字符串格式是否正确
		if (str == null || str.length() <= 0) {
			return 0;
		}
		char[] chars = str.toCharArray();
		int result = 0;
		int len = chars.length;
		// 判断符号 1为正数，2为负数
		int flag = 1;
		// 判断第一位是否为负号，如果为负，在计算结果末尾进行处理
		if (chars[0] == '-') {
			flag = -1;
		}
		for (int i = (chars[0] == '-' || chars[0] == '+') ? 1 : 0; i < len; ++i) {
			// 如果遇到不合理字符立即退出
			if (chars[i] < 48 || chars[i] > 57) {
				return 0;
			}
			// 判断是否溢出
			// 比较n和MAX_INT / 10的大小
			// 若n > MAX_INT / 10，那么说明最后一步转换时，n*10必定大于MAX_INT，所以在得知n > MAX_INT / 10时，当即返回MAX_INT
			// 若n == MAX_INT / 10时，那么比较最后一个数字c跟MAX_INT % 10的大小，即如果n == MAX_INT / 10且c > MAX_INT % 10，则照样返回MAX_INT
			// [0~9]的二进制表示低四位刚好就是[0~9]。 (chars[i] & 0xf)即取低四位值
			if (flag > 0 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (chars[i] & 0xf) > Integer.MAX_VALUE % 10))) {
				// 发生正溢出，返回Integer最大值
				return Integer.MAX_VALUE;
			}
			if (flag < 0 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (chars[i] & 0xf) > Integer.MAX_VALUE % 10))) {
				// 发生负溢出，返回Integer最小值
				return Integer.MIN_VALUE;
			}
			// 采用位运算更加高效
			// (result << 1) + (result << 3) 即 result*2+result*8=res*10
			// [0~9]的二进制表示低四位刚好就是[0~9]  (chars[i] & 0xf)即取低四位值
			// 即 result = result * 10 + (chars[i] - '0')
			result = (result << 1) + (result << 3) + (chars[i] & 0xf);
		}
		return result * flag;
	}

	public static void main(String[] args) {
		P12_StrToInt strToInt = new P12_StrToInt();
		int result = strToInt.strToInt("2147483647777");
		System.out.println("i = " + result);
	}
}
