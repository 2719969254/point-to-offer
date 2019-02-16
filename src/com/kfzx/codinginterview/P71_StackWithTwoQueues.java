package com.kfzx.codinginterview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用两个队列实现栈
 * <p>
 * (1）对于插入操作，栈与队列都是从队尾进行，因此很容易完成。但是一定要保证有一个队列是空的
 *（2）对于弹出操作，队列从队头开始，而栈从队尾开始，要想取到队尾元素，需要第二个队列的协助：
 * 假设queue1不为空，queue2为空，将queue1的原书依次取出放到queue2中，同时判断，当queue1的长度为1时，不要将该元素放到queue2中，而是直接取出丢弃，此时即完成了栈的弹出操作
 * 也就是说，弹出一个元素，其他元素的存储位置就会从本队列移动到另一个队列中。
 * <p>
 * 运作过程中，queue，queue2一定至少一个为空。插入操作选择queue1，queue2中不为空的那个队列插入（如果都为空，随意选择一个）
 * 弹出时将不为空的队列除最后一个队列的其他元素依次取出放到另一个队列中，而将最后那一个元素取出丢弃即可
 */
public class P71_StackWithTwoQueues {

	public static void main(String[] args) {
		MyStack<Integer> myStack = new MyStack<>();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		myStack.push(4);
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
	}
}

class MyStack<T> {
	private Queue<T> queue1 = new LinkedList<>();
	private Queue<T> queue2 = new LinkedList<>();

	public void push(T data) {
		if (!queue2.isEmpty()) {
			queue2.offer(data);
		} else {
			queue1.offer(data);
		}
	}

	public T pop() {
		if (!queue2.isEmpty()) {
			int size = queue2.size();
			for (int i = 0; i < size - 1; i++) {
				queue1.offer(queue2.poll());
			}
			return queue2.poll();
		}
		if (!queue1.isEmpty()) {
			int size = queue1.size();
			for (int i = 0; i < size - 1; i++) {
				queue2.offer(queue1.poll());
			}
			return queue1.poll();
		}

		return null;
	}
}