package com.kfzx.datastructure;

import java.util.LinkedList;

/**
 * 利用数组实现队列，为了实现多线程操作，增加了对队列操作的同步
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/21
 */
public class MyQueueForArray<E> {
	private LinkedList<E> list = new LinkedList<>();
	private int size = 0;

	public synchronized void put(E e) {
		list.addLast(e);
		size++;
	}

	public synchronized E pop() {
		size--;
		return list.removeFirst();
	}
	public synchronized Boolean isEmpty(){
		return size == 0;
	}
	public synchronized int size(){
		return size;
	}
}
