package codinginterview;

import java.util.Arrays;

/**
 * 实现一个函数，把字符串中的每个空格替换成“ %20 ”。
 * 通过按传统办法，假设字符的长度是n。对每个空格字符，需要移动后面O(n)个字符，因此对含有O(n)个空格字符串而言总的时间效率是O(n2)
 * 在前面的分析中，我们发现数组中的很多字符都移动了很多次，能不能减少移动的次数呢？我们换一种思路，把从前向后替换成从后向前替换
 * 我们先遍历一次字符串，这样就能够统计出字符串中空格的综述，并可以计算出替换之后字符串的总的长度。
 * 每替换一个空格，长度增加2，因此替换以后的字符串的长度等于原来的长度加上2乘以空格的数目
 * 我们从字符串的后面开始复制和替换。首先准备两个指针，P1和P2.（用字符数组代替）
 * P1指向原始字符串的末尾，而P2指向替换之后的字符串的末尾。
 * 接下来我们向前移动指针P1,逐个把它指向的字符复制到P2指向的位置，直到碰到第一个空格为止。
 * 碰到第一个空格之后，把P1向前移动一格，在P2之前插入字符串”%20“，由于”%20“的长度为3，同时也要把P2向前移动3格
 * 接着向前复制，直到碰到第二个空格。
 * 和上一次一样，我们再把P1向前移动1格，并把P2向前移动3格插入”%20“，
 * 此时P1，P2指向同一个位置，表明所有的空格都已经替换完毕。
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/19
 */
public class P51_ReplaceSpaces {
	public static void main(String[] args) {
		String str = "We are happy.";
		System.out.println("replaceBlank(str) = " + replaceBlank(str));
	}

	private static String replaceBlank(String str) {
		int newLength = str.length();
		char[] chars = str.toCharArray();
		for (char aChar : chars) {
			if (aChar == ' ') {
				newLength += 2;
			}
		}
		char[] newStr = new char[newLength];
		for (int i = 0; i < chars.length; ++i) {
			newStr[i] = chars[i];
		}
		for (int indexOfOld = str.length() - 1, indexOfNew = newLength - 1; indexOfOld > 0 && indexOfNew != indexOfOld; indexOfOld--, indexOfNew--) {
			if (chars[indexOfOld] == ' ') {
				newStr[indexOfNew--] = '0';
				newStr[indexOfNew--] = '2';
				newStr[indexOfNew] = '%';
			} else {
				newStr[indexOfNew] = newStr[indexOfOld];
			}
		}

		return Arrays.toString(newStr);
	}
}
