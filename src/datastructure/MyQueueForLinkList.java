package datastructure;

class NodeForQueue<E>{
	NodeForQueue<E> next = null;
	E data;

	public NodeForQueue(E data) {
		this.data = data;
	}
}

/**
 * 链表方式实现队列
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/21
 */
public class MyQueueForLinkList<E> {
	private NodeForQueue<E> head = null;
	private NodeForQueue<E> tail = null;
	public Boolean isEmpty(){
		return head == tail;
	}
	public void put(E data){
		NodeForQueue<E> newNode = new NodeForQueue<>(data);
		// 队列为空
		if (head == null || tail == null){
			head = tail = newNode;
		}else{
			tail.next = newNode;
			tail = newNode;
		}
	}
	public E pop(){
		if (isEmpty()){
			return null;
		}
		E data = head.data;
		head  =head.next;
		return data;
	}
	public int size(){
		NodeForQueue<E> temp = head;
		int size = 0;
		while (temp != null){
			size++;
			temp = temp.next;
		}
		return size;
	}

	public static void main(String[] args) {
		MyQueueForLinkList<Integer> queue = new MyQueueForLinkList<>();
		queue.put(1);
		queue.put(2);
		queue.put(3);
		queue.put(4);
		System.out.println("queue.size() = " + queue.size());
		System.out.println("queue.pop() = " + queue.pop());
		System.out.println("queue.pop() = " + queue.pop());
	}
}
