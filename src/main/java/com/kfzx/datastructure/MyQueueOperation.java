package com.kfzx.datastructure;

import java.util.Stack;

/**
 * 利用两个栈模拟队列操作
 *
 * 假设使用栈A和栈B模拟队列Q，A为押栈，B为弹栈，以实现队列Q
 *
 * 假设AB都为空，可以认为A提供入队列功能，B提供出队列功能
 * 要入队列，入栈A即可，要出队列，则需要两种情况：
 * 若B不为空，直接弹出B的数据
 * 若B为空，则依次弹出栈A的数据，放入B中，再弹出B的数据
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/21
 */
public class MyQueueOperation<E> {
	private Stack<E> s1 = new Stack<>();
	private Stack<E> s2 = new Stack<>();
	public synchronized void put(E e){
		s1.push(e);
	}
	public synchronized E pop(){
		if(s2.isEmpty()){
			// 依次弹出栈s1的数据，放入s2中
			while (! s1.isEmpty()){
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
	public synchronized Boolean isEmpty(){
		return s1.isEmpty() && s2.isEmpty();
	}

	public static void main(String[] args) {
		MyQueueOperation<Integer> queue = new MyQueueOperation<>();
		queue.put(1);
		queue.put(2);
		queue.put(3);
		System.out.println("queue.pop() = " + queue.pop());
		System.out.println("queue.pop() = " + queue.pop());
		System.out.println("queue.pop() = " + queue.pop());
	}
}
