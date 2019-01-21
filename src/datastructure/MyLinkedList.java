package datastructure;

import java.util.Hashtable;

/**
 * 单链表及单链表的相关操作
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/20
 */
class Node {
	Node next = null;
	private int data;

	Node(int data) {
		this.data = data;
	}

	int getData() {
		return data;
	}

	void setData(int data) {
		this.data = data;
	}
}

/**
 * 单链表及单链表的相关操作
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/20
 */
public class MyLinkedList {
	/**
	 * 链表头的引用
	 */
	Node head = null;

	/**
	 * 向链表中插入数据
	 *
	 * @param data 插入数据的内容
	 */
	private void addNode(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		// add node to end
		temp.next = newNode;
	}

	/**
	 * 根据索引删除节点
	 *
	 * @param index 删除第index个节点
	 * @return Boolean
	 */
	private Boolean deleteNode(int index) {
		if (index < 1) {
			return false;
		}
		//删除链表第一个元素
		if (index == 1) {
			head = head.next;
			return true;
		}
		int i = 1;
		Node preNode = head;
		Node curNode = preNode.next;
		while (curNode != null) {
			if (i == index) {
				preNode.next = curNode.next;
				return true;
			} else {
				preNode = curNode;
				curNode = curNode.next;
				i++;
			}
		}
		return false;
	}

	/**
	 * 计算链表长度
	 *
	 * @return 链表长度
	 */
	private int length() {
		int length = 0;
		Node temp = head;
		while (temp != null) {
			length++;
			temp = temp.next;
		}
		return length;
	}

	/**
	 * 打印链表
	 */
	private void print() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + "\t");
			temp = temp.next;
		}
		System.out.println();
	}

	/**
	 * 对链表进行排序
	 *
	 * @return 排序后的链表的头结点
	 */
	private Node orderList() {
		Node nextNode = null;
		int temp = 0;
		Node curNode = head;
		while (curNode != null) {
			nextNode = curNode.next;
			while (nextNode != null) {
				if (curNode.getData() > nextNode.getData()) {
					temp = curNode.getData();
					curNode.setData(nextNode.getData());
					nextNode.setData(temp);
				}
				nextNode = nextNode.next;
			}
			curNode = curNode.next;

		}
		return head;
	}

	/**
	 * 去掉链表中的重复数据，
	 * 思路一：便利链表，把遍历到的值储存在一个Hashtable中，若当前访问的值在Hashtable中已经存在，说明这个值是重复的，可以删除。
	 * 此算法的时间复杂度较低，但需要额外的空间来保存已经遍历过的值
	 * 时间复杂度：O(n) 空间复杂度：O(n)
	 */
	public void deleteDuplecate1() {
		Hashtable<Integer, Integer> table = new Hashtable<>();
		Node temp = head;
		Node pre = null;
		while (temp != null) {
			if (table.containsKey(temp.getData())) {
				pre.next = temp.next;
			} else {
				table.put(temp.getData(), 1);
				pre = temp;
			}
			temp = temp.next;
		}
	}

	/**
	 * 删除重复元素节点的第二种方法，对链表进行双重循环遍历，外循环正常遍历链表，内循环从外循环的地方开始遍历，找到相同则删除
	 * 优点是不需要额外的储存空间，缺点也很明显，时间复杂度较高
	 * 也可以有第三种方法：外循环当前遍历的节点为cur，内循环从量表头开始遍历至cur，只要遇到与cur值相同的节点就删除该节点，同时循环结束
	 * 因为与cur值相等的情况只可能存在一个，如果存在多个，则在之前的遍历中就已经被删除了，这种算法在特定的数据中会提高算法的时间复杂度
	 * 时间复杂度
	 */
	private void deleteDuplecate2() {
		Node p = head;
		while (p != null) {
			Node q = p;
			while (q.next != null) {
				if (p.getData() == q.next.getData()) {
					q.next = q.next.next;
				} else {
					q = q.next;
				}
			}
			p = p.next;
		}
	}

	/**
	 * 查找单链表中的倒数第K个元素
	 * 为了找出单链表中倒数第k个元素，最容易想到的办法是首先遍历一遍单链表，求出链表长度n，然后将倒数第k个转换成正数第n-k个，按下去遍历一次就可以得到结果
	 * 这样的方法需要对链表遍历两次，于是优化出第二种方法
	 * 如果沿从头至尾的方向从链表的某个元素开始，遍历k的元素后刚好达到链表尾，那么该元素就是要找的倒数第k个元素，根据这一特性可以设置如下算法
	 * 从头结点开始，依次对链表的每一个节点元素进行这样的测试，遍历k个元素，查看是否达到链表尾部。此种方法对同一批元素进行反复多次遍历，如果链表长度为n，该算法时间复杂度为O(kn)，效率太低
	 * 存在更加高效的办法，只需要一次遍历就可以查找到倒数第k个元素
	 * 由于单链表只能从头到尾依次访问链表的各个节点，因此，要找出链表的倒数第k个元素的话，也只能从有到尾进行遍历查找，在查找过程中设置两个指针，一个指针比另一个指针先前移k-1步，然后两个指针同时往前移动。循环直到先行指针的值为NULL时，另一个指针的位置就是要找的位置
	 * 这样的时间复杂度为O(n)，空间复杂度为O(1)
	 */
	private Node findElement(int k) {
		if (k < 1 || k > this.length()) {
			return null;
		}
		Node p1 = head;
		Node p2 = head;
		for (int i = 0; i < k - 1; i++) {
			p1 = p1.next;
		}
		while (p1.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}

	/**
	 * 反转链表，翻转后链表的头结点的原始链表的尾结点，即next为空指针的节点
	 */
	private Node reverseIteratively() {
		Node pReversedHead = null;
		Node pNode = head;
		Node pPrev = null;
		while (pNode != null) {
			// 查看pNode节点的下一个节点是否为空，如果为空说明这个就是原始链表的尾结点（翻转后链表的头结点）
			Node pNext = pNode.next;
			if (pNext == null) {
				pReversedHead = pNode;
			}
			// 先将下一节点纪录下来，然后让当前节点指向上一节点，再将当前节点纪录下来,再让下一节点变为当前节点
			pNode.next = pPrev;
			pPrev = pNode;
			pNode = pNext;
		}
		this.head = pReversedHead;
		return this.head;
	}

	/**
	 * 从尾到头输出单链表
	 * 方法一：从头到尾开始遍历链表，每经过一个结点，把该结点放入一个栈中，遍历完整个链表后 从栈顶开始输出结点的值。
	 * 该方法尽管只需要遍历一次，却需要维护一个额外的栈空间
	 * 这时就可以想到递归，因为递归的本质就是一个栈结构。
	 */
	private void printListReversely(Node pListHead) {
		if (pListHead != null) {
			printListReversely(pListHead.next);
			System.out.print(pListHead.getData() + "\t");
		}
	}

	/**
	 * 寻找单链表的中间节点
	 * 最容易的思路是想求出长度length，然后遍历length/2的距离即可求出中间节点，但是此方法需要遍历两次链表，时间复杂度太高，可以优化
	 * 如果是双链表，可以首尾并行，利用两个指针一个从头到尾遍历，一个从尾到头遍历，当两个指针相遇就是中间节点
	 * 类似的，单链表也可以采用双指针办法，有两个指针同时从头开始遍历，一个快指针一次走两步，一个慢指针一次走一步。
	 * 当快指针到达链表尾部时，满指针刚好到达中间。
	 * 当链表长度为奇数时，慢指针指向的是中间结点，当链表长度为偶数时，慢指针指向的节点和指向节点的下一个节点都是链表的中间节点
	 */
	private void searchMid() {
		Node fast = this.head;
		Node slow = this.head;
		int length = 1;
		while (fast != null && fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			length += 2;
		}
		if (fast.next != null && fast.next.next == null) {
			length += 1;
		}
		if (length % 2 != 0) {
			System.out.println("链表长度为奇数，中间结点为：q.getData() = " + slow.getData());
		} else {
			System.out.println("链表长度为偶数，中间结点为：" + slow.getData() + " 和 " + slow.next.getData());
		}
	}

	/**
	 * 检测一个链表是否有环
	 * 定义两个指针，二者初始值都指向表头，两个指针移动速度一快一慢，快指针每次都与慢指针比较，如果两个相等，就说明有环
	 */
	private Boolean isLoop() {
		Node fast = head;
		Node slow = head;
		if (fast == null) {
			return false;
		}
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 上面的方法只能判断链表是否有环，如果单链表有环，按上述思路，当走得快的指针与走得慢的指针相遇时，
	 * slow肯定没有遍历完列表，而fast已经在圈内循环了n（n>1）圈了。
	 * 假设slow指针走了s步，则fast指针走了2s步，
	 * 设环的长度为r，则满足如下关系式
	 * 2 * s = s + n * r 化简得 s = n * r
	 * 设整个链表长L，入口环与相遇点距离为x，起点到环入口点的距离为a，则满足如下关系式表达式：
	 * a + x = n * r
	 * a + x = ( n - 1) * r + r = (n - 1) * r + L -a
	 * a = ( n - 1 ) * r + (L - a - x )
	 * (L - a - x )为相遇点到环入口点的距离，从链表头到环入口点等于（n-1)循环内环 + 相遇点到环入口，
	 * 于是在链表头与相遇点分别设置一个指针，每次各走一步，两个指针必定相遇，且相遇低一点为环的入口点
	 */
	private Node findLoopPort() {
		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		if (fast == null || fast.next == null) {
			return null;
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	/**
	 * 在不知道头指针的情况下删除指定结点
	 * 可分为两种情况讨论
	 * ①待删除结点为链表尾结点，无法删除，因为删除后无法使其前驱结点的next指针置为null
	 * ②待删除节点不是尾结点，则可以通过交换这个结点与其后继结点的值，然后删除后继结点
	 */
	private boolean deleteNode(Node n) {
		if (n == null || n.next == null) {
			return false;
		}
		int temp = n.getData();
		n.setData(n.next.getData());
		n.next.setData(temp);
		n.next = n.next.next;
		return true;
	}

	/**
	 * 测试
	 */
	public static void main(String[] args) {
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.addNode(5);
		linkedList.addNode(3);
		System.out.println("linkedList.length() = " + linkedList.length());
		linkedList.print();
		linkedList.orderList();
		linkedList.print();
		linkedList.deleteNode(1);
		System.out.println("linkedList.length() = " + linkedList.length());
		linkedList.addNode(5);
		linkedList.addNode(4);
		linkedList.addNode(6);
		linkedList.addNode(7);
		linkedList.addNode(9);
		linkedList.deleteDuplecate2();
		linkedList.print();
		System.out.println("linkedList.findElement(3) = " + linkedList.findElement(3).getData());
		linkedList.reverseIteratively();
		linkedList.print();
		linkedList.printListReversely(linkedList.head);
		System.out.println();
		linkedList.searchMid();
		System.out.println("linkedList.isLoop() = " + linkedList.isLoop());
	}
}
