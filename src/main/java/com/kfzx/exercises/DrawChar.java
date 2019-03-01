package com.kfzx.exercises;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * 现有字符串char[] text，实现函数char[] DrawChar(char[] text)，
 * 找出text中重复出现最多的字符，然后将该字符移到text的最前端，生成一个新的字符串。
 * 假设重复出现最多的字符只有一个。请充分考虑内存和性能效率。
 * 举例： “abcaba”，转换后成为“aaabcb”。
 *
 * 输入原始的字符串，如 "abcaba"
 *
 * 输入处理后的字符串，如 "aaabcb"
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/28
 */

public class DrawChar {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String result = drawChar(str);
		System.out.println(result);
	}

	private static String drawChar(String str) {
		String result = "";
		Map<Character,Integer> map = new HashMap(10);
		char[] chars = str.toCharArray();
		for (char aChar : chars) {
			map.put(aChar,0);
		}
		for (char aChar : chars) {
			Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
			while (iterator.hasNext()){
				Map.Entry<Character, Integer> entry = iterator.next();
				if (aChar == entry.getKey()){
					Integer value = entry.getValue();
					value++;
					map.put(aChar,value);
					break;
				}
			}
		}
		Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
		int max = 0;
		char maxChar = 0;
		while (iterator.hasNext()){
			Map.Entry<Character, Integer> next = iterator.next();
			int value = next.getValue();
			if (value>max){
				max = value;
				maxChar =next.getKey();
			}
		}
		for (int i = 0;i<max;i++){
			result+=maxChar;
		}
		for (char aChar : chars) {
			if (aChar != maxChar){
				result += aChar;
			}
		}
		return result;
	}
}
