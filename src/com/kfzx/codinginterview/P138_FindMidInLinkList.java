package com.kfzx.codinginterview;

/**
 * 寻找链表的中间节点
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/19
 */
public class P138_FindMidInLinkList {
	static class Node<T> {
		T data;
		Node<T> next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}

		@Override
		public String toString() {
			return "Node{" +
					"data=" + data +
					", next=" + next +
					'}';
		}
	}

	private static Node findMidInLinkList(Node head) {
		Node fast = head;
		Node slow = head;
		// fast.next如果为空说明链表是空表或者已经到了表的末尾
		while (fast.next != null) {
			// 快指针移动两步
			if (fast.next.next != null) {
				// 如果最后剩两步，则移动两步
				fast = fast.next.next;
				// 慢指针移动一步
				slow = slow.next;
			} else {
				// 如果最后只剩一步，则移动一步
				fast = fast.next;
			}
		}
		return slow;
	}

	public static void main(String[] args) {
		Node<Integer> L = new Node<>(0);
		Node<Integer> P = L;
		for (int i = 0; i < 20; i++) {
			P.next = new Node<>(i + 1);
			P = P.next;
		}
		System.out.println("findMidInLinkList(L) = " + findMidInLinkList(L).data);
	}
}
