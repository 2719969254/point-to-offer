package com.kfzx.codinginterview;

import java.util.Stack;

/**
 * 包含min函数的栈
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。
 * 要求在该栈中，调用min，push及pop的时间复杂度都是o(1)。
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/26
 */
class StackWithMin<T extends Comparable> {
	private Stack<T> stackData = new Stack<>();
	private Stack<T> stackMin = new Stack<>();

	public void push(T data) {
		stackData.push(data);
		if (stackMin.isEmpty()) {
			stackMin.push(data);
		} else {
			T temp = stackMin.peek();
			if (temp.compareTo(data) < 0) {
				stackMin.push(temp);
			} else {
				stackMin.push(data);
			}
		}
	}

	public T pop() {
		if (stackData.isEmpty()) {
			return null;
		}
		stackMin.pop();
		return stackData.pop();
	}

	public T min() {
		if (stackMin.isEmpty()) {
			return null;
		}
		return stackMin.peek();
	}

}

public class P165_StackWithMin {
	public static void main(String[] args) {
		StackWithMin<Integer> stack = new StackWithMin<>();
		stack.push(3);
		stack.push(4);
		stack.push(2);
		stack.push(1);
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
	}
}
