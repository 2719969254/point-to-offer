package com.kfzx.codinginterview;

import com.sun.istack.internal.localization.NullLocalizable;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/4/8
 */
@SuppressWarnings("all")
public class Test {
	private static class ListNode<T> {
		T val;
		ListNode<T> next;

		ListNode(T val) {
			this.next = null;
			this.val = val;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		String[] arr = str.split(",");
		ListNode listNode = new ListNode(arr[0]);
		ListNode flag = listNode;
		for (int i = 1; i < arr.length; i++) {
			ListNode node = new ListNode(arr[i]);
			listNode.next = node;
			listNode = node;
		}

		System.out.println(entryNodeOfLoop(flag));

	}

	private static Boolean entryNodeOfLoop(ListNode pHead) {
		Map map = new HashMap();
		try {
			while (pHead.val != null) {
				if (!map.containsValue(pHead.val)) {
					map.put(pHead.val, pHead.val);
					pHead = pHead.next;
				} else {
					return true;
				}
			}
		}catch (NullPointerException e){
			return false;
		}
		return false;
	}
}
