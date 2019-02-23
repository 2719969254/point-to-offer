package com.kfzx.datastructure;

import java.util.Arrays;

/**
 * 利用java数组实现栈
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/21
 */
public class MyStackByArray<E> {
	/**
	 * 定义一个栈
	 */
	private Object[] stack;
	/**
	 * 定义数组中存储元素的个数
	 */
	private int size;

	private MyStackByArray() {
		// 栈的初始长度为10
		stack = new Object[10];
	}

	/**
	 * 判断堆栈是否为空
	 */
	private Boolean isEmpty() {
		return this.size == 0;
	}
	/**
	 * 返回栈顶元素，却不删除
	 */
	@SuppressWarnings("unchecked")
	private E peek(){
		if (isEmpty()){
			return null;
		}
		return (E) stack[size-1];
	}

	/**
	 * 弹栈
	 */
	private E pop(){
		E e = peek();
		stack[size -1] = null;
		size--;
		return e;
	}

	/**
	 * 压栈
	 * @param item 要压栈的数据
	 */
	private void push(E item){
		ensureCapacity(size+1);
		stack[size ++] = item;
	}
	/**
	 * 判断数组容器是否已满，若已满则扩充空间
	 */
	private void ensureCapacity(int size){
		int length = stack.length;
		if(size > length){
			int newLen = 10;
			// copyOf()是系统自动在内部新建一个数组，
			// 调用arraycopy()将original内容复制到copy中去，并且长度为newLength。
			// 返回copy; 即将原数组拷贝到一个长度为newLength的新数组中，并返回该数组
			stack = Arrays.copyOf(stack,newLen);
		}
	}
	/**
	 * 测试
	 */
	public static void main(String[] args) {
		MyStackByArray<Integer> myStack = new MyStackByArray<>();
		myStack.push(1);
		myStack.push(2);
		System.out.println("myStack.size = " + myStack.size);
		System.out.println("myStack.pop() = " + myStack.pop());
		System.out.println("myStack.pop() = " + myStack.pop());
	}
}
