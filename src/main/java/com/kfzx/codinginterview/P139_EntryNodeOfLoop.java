package com.kfzx.codinginterview;

import java.util.*;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 * <p>
 * 解决此题需要两步操作 首先确定这个链表是否包含环，若包含环，求出它的入口节点
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/24
 */
public class P139_EntryNodeOfLoop {
	static class ListNode<T> {
		T val;
		ListNode<T> next;

		ListNode(T val) {
			this.next = null;
			this.val = val;
		}

		@Override
		@SuppressWarnings("all")
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

	/**
	 * 首先判断链表是否有环，通过设置两个快慢指针，让快指针每次走两步，慢指针一次走一步、
	 * 如果快指针追上了慢指针，那么说明此链表存在环。如果走的快的节点的next为null，说明此链表没有环
	 * <p>
	 * 当相遇时，慢指针在环中走了k步，设环外长度为x，环的长度为n，则快指针一共走了x+m*n步。
	 * m是快指针在环中走的圈数，慢指针一共走了x+k步
	 * 因为快指针是慢指针的二倍，所以可以得到 2(x+k)=x+m*n+k; 化简可得x=m*n-k，慢指针在圈中还剩的步数为n-k步
	 *
	 * @param pHead
	 * @return
	 */
	private static ListNode entryNodeOfLoop(ListNode pHead) {
		if (pHead == null || pHead.next == null) {
			return null;
		}
		ListNode fast = pHead;
		ListNode slow = pHead;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			// 判断是否相遇，相遇后让快指针从头开始走，每次都是走一步，第二次相遇就是环的入口
			if (fast.val == slow.val) {
				fast = pHead;
				while (fast.val != slow.val) {
					fast = fast.next;
					slow = slow.next;
				}
			}

			if (fast.val == slow.val) {
				return slow;
			}
		}
		return null;
	}

	/**
	 * 下面的是断链法,访问过的节点都断开，最后到达的那个节点一定是循环的入口节点。
	 */
	private static ListNode entryNodeOfLoop2(ListNode pHead) {
		if (pHead == null || pHead.next == null) {
			return null;
		}
		ListNode fast = pHead.next;
		ListNode slow = pHead;
		while (fast != null) {
			slow.next = null;
			slow = fast;
			fast = fast.next;
		}
		return slow;
	}

	/**
	 * 将每个元素存储在Set集合里，每次存放的时候利用hash计算是否已经有这个结点
	 * 如果有，说明这个链表存在环。并且这个结点就是环的入口节点
	 *
	 * @param pHead
	 * @return
	 */
	private static ListNode entryNodeOfLoop3(ListNode pHead) {
		Map map = new HashMap();

		while (pHead.next != null) {
			if (!map.containsValue(pHead)) {
				map.put(pHead, pHead);
				pHead = pHead.next;
			} else {
				return pHead;
			}

		}
		return null;
	}

	public static void main(String[] args) {
		ListNode<Integer> node1 = new ListNode<>(1);
		ListNode<Integer> node2 = new ListNode<>(2);
		ListNode<Integer> node3 = new ListNode<>(3);
		ListNode<Integer> node4 = new ListNode<>(4);
		ListNode<Integer> node5 = new ListNode<>(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node3;

		System.out.println("entryNodeOfLoop(node1) = " + entryNodeOfLoop3(node1));


	}
}
