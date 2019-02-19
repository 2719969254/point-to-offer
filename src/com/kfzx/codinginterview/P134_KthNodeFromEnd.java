package com.kfzx.codinginterview;

/**
 * 链表中倒数第k个节点
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/19
 */
public class P134_KthNodeFromEnd {
	static class ListNode<T> {
		T val;
		ListNode<T> next;

		ListNode(T val) {
			this.val = val;
			this.next = null;
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

	private static ListNode findKthToTail(ListNode head, int k) {
		if (head == null || k < 1) {
			return null;
		}
		// 指向头结点
		ListNode node = head;
		for (int i = 0; i<k - 1;i++){
			if (node.next != null){
				node = node.next;
			}
			// 已经没有节点了，但是i还没有到达k-1说明k太大，链表中没有那么多的元素
			else {
				return null;
			}
		}

		// node还没有走到链表的末尾，那么node和head一起走，
		// 当node走到最后一个结点即，node.next=null时，head就是倒数第k个结点
		while (node.next !=null){
			head = head.next;
			node = node.next;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode<Integer> head = new ListNode<>(1);
		head.next= new ListNode<>(2);
		head.next.next = new ListNode<>(3);
		System.out.println(findKthToTail(head,1).val);
		System.out.println(findKthToTail(head,2).val);
		System.out.println(findKthToTail(head,3).val);
		System.out.println(findKthToTail(head,4));
	}

}
