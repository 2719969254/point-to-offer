package com.kfzx.codinginterview;

/**
 * 反转链表
 * <p>
 * 想要链表反转时不断裂，至少需要3个变量记录，pre，cur，post。
 * 与前面的题目类似，初始化pre为null，cur为head，post为head.next。
 * 初始化之前要注意检查链表的长度。
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/25
 */
public class P142_ReverseList {
	static class ListNode<T> {
		T val;
		ListNode<T> next;

		ListNode(T val) {
			this.next = null;
			this.val = val;
		}

		@SuppressWarnings("all")
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

	private static ListNode reverseList(ListNode head) {
		if (head == null ) {
			return null;
		}
		// 说明两边搜长度为一，可以直接返回它本身
		if (head.next == null){
			return head;
		}
		ListNode pre = null;
		ListNode cur = head;
		ListNode post = head.next;
		while (true) {
			cur.next = pre;
			pre = cur;
			cur = post;
			if (post != null) {
				post = post.next;
			} else {
				return pre;
			}
		}
	}
	public static void main(String[] args){
		ListNode<Integer> head = new ListNode<>(1);
/*		head.next= new ListNode<>(2);
		head.next.next = new ListNode<>(3);*/
		System.out.println(head);
		head = reverseList(head);
		System.out.println(head);
	}

}
