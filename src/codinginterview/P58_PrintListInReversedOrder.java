package codinginterview;

import java.util.Stack;

/**
 * 从尾到头打印链表
 * <p>
 * 遍历的顺序是从过头到尾，输出顺序是从尾到头，这是一个典型的后进先出，我们可以用栈来实现相关操作。
 * 每经过一个节点时，把该结点放入一个栈中。当遍历完整个链表后，再从栈顶逐个输出节点的值。
 * 既然是个栈结构，我们自然也可以想到递归
 * 但是基于递归的代码看起来很简洁，但有个问题：当链表非常长的时候，就会导致函数调用的层级很深，从而有可能导致函数调用栈溢出
 * 所以显式用栈基于循环实现的代码的鲁棒性要好一些。
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/23
 */

public class P58_PrintListInReversedOrder {
	/**
	 * 用栈实现PrintListInReversedOrder
	 */
	public static void printReversinglyIteratively(ListNode<Integer> node) {
		Stack<Integer> stack = new Stack<>();
		for (ListNode<Integer> tmp = node; tmp != null; tmp = tmp.next) {
			stack.add(tmp.val);
		}
		while (!stack.isEmpty()) {
			System.out.println("stack.pop() = " + stack.pop());
		}
	}

	/**
	 * 用递归实现PrintListInReversedOrder
	 */
	public static void printReversinglyRecursively(ListNode<Integer> node) {
		if (node == null) {
			return;
		} else {
			printReversinglyRecursively(node.next);
			System.out.println("node.val = " + node.val);
		}
	}

	public static void main(String[] args) {
		ListNode<Integer> head = new ListNode<>(1);
		head.next = new ListNode<>(2);
		head.next.next = new ListNode<>(3);
		printReversinglyRecursively(head);
		System.out.println();
		printReversinglyIteratively(head);
	}

}

class ListNode<T> {
	public T val;
	public ListNode<T> next;

	public ListNode(T val) {
		this.val = val;
		this.next = null;
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