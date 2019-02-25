package com.kfzx.codinginterview;

/**
 * 合并两个排序的链表
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/25
 */
@SuppressWarnings("all")
public class P145_MergeSortedLists {

	static class ListNode<T> {
		T val;
		ListNode next;

		ListNode(T val) {
			this.next = null;
			this.val = val;
		}

		@Override
		public String toString() {
			StringBuilder ret = new StringBuilder();
			ret.append("[");
			for (ListNode cur = this; ; cur = cur.next) {
				if (cur == null) {
					ret.deleteCharAt(ret.lastIndexOf(" "));
					ret.deleteCharAt(ret.lastIndexOf(","));
					break;
				}
				ret.append(cur.val);
				ret.append(", ");
			}
			ret.append("]");
			return ret.toString();
		}
	}

	private static ListNode merge(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		ListNode index1 = list1;
		ListNode index2 = list2;
		ListNode index = null;
		// 首先确定头结点位置
		if ((int) index1.val < (int) index2.val) {
			index = index1;
			index1 = index1.next;
		} else {
			index = index2;
			index2 = index2.next;
		}

		while (index1 != null && index2 != null) {
			if ((int) index1.val < (int) index2.val) {
				index.next = index1;
				index = index.next;
				index1 = index1.next;
			} else {
				index.next = index2;
				index = index.next;
				index2 = index2.next;
			}
		}
		if (index1 != null) {
			index.next = index1;
		} else {
			index.next = index2;
		}
		return (int) list1.val < (int) list2.val ? list1 : list2;
	}

	public static void main(String[] args) {
		ListNode<Integer> head1 = new ListNode<>(1);
		head1.next = new ListNode<>(3);
		head1.next.next = new ListNode<>(5);
		head1.next.next.next = new ListNode<>(7);
		ListNode<Integer> head2 = new ListNode<>(2);
		head2.next = new ListNode<>(4);
		head2.next.next = new ListNode<>(6);
		head2.next.next.next = new ListNode<>(8);
		System.out.println(head1);
		System.out.println(head2);
		ListNode head = merge(head1, head2);
		System.out.println(head);
	}
}
