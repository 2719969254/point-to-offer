package datastructure;

/**
 * 定义一个链表的节点
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/21
 */
class NodeForStack<E> {
	NodeForStack<E> next = null;
	E data;

	NodeForStack(E data) {
		this.data = data;
	}
}
/**
 * 通过链表实现栈
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/21
 */
public class MyStackByLinkedList<E> {
	private NodeForStack<E> top = null;

	Boolean isEmpty() {
		return top == null;
	}

	void push(E data) {
		NodeForStack<E> newNode = new NodeForStack<>(data);
		newNode.next = top;
		top = newNode;
	}

	E pop() {
		if (this.isEmpty()) {
			return null;
		}
		E data = top.data;
		top = top.next;
		return data;
	}
	 E peek(){
		if (this.isEmpty()){
			return null;
		}
		return top.data;
	}
	/**
	 * 测试
	 */
	public static void main(String[] args) {
		MyStackByLinkedList<Integer> myStack = new MyStackByLinkedList<>();
		myStack.push(1);
		myStack.push(2);
		System.out.println("myStack.peek() = " + myStack.peek());
		System.out.println("myStack.pop() = " + myStack.pop());
		System.out.println("myStack.pop() = " + myStack.pop());
	}
}
