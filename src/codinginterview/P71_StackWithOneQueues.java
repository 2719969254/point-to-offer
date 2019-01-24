package codinginterview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 利用一个队列实现栈
 * <p>
 * 插入操作与之前一样，对于弹出操作，假设队列长度为n（假设存储内容为头2,5,1,3,4尾），
 * 对从队头poll出来的元素执行offer存入队尾，依次进行n-1次poll与offer（此时存储的内容为头4,2,5,1,3尾），
 * 然后再执行一次poll（此时为2,5,1,3），即完成了自实现栈的弹出。
 * 这样将在时间不变情况下节约一半的空间
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/23
 */
class MyStack2<T>{
	Queue<T> queue = new LinkedList<>();
	public void push(T data){
		queue.offer(data);
	}
	public T pop(){
		if (queue.isEmpty()){
			return null;
		}
		int size = queue.size();
		for (int i = 0;i<size-1;i++){
			queue.offer(queue.poll());
		}
		return queue.poll();
	}
}
public class P71_StackWithOneQueues {
	public static void main(String[] args) {
		MyStack2<Integer> myStack = new MyStack2<>();
		System.out.println(myStack.pop());
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
