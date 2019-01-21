package datastructure;

/**
 * 用O(1)的时间复杂度求栈中最小元素
 * <p>
 * 要找到栈里的最小元素，最简单的方法是对栈进行遍历，找出最小值，但是这样的方法的时间复杂度为O(n)
 * 在算法设计中，我们可以采取用空间换时间的方法来提高算法的时间复杂度，也就是采用额外的存储空间来降低操作的时间复杂度
 * 具体实现就是使用两个栈结构，一个栈用来存储数据，另一个栈用来存储栈的最小元素，如果当前入栈的元素比原来栈的最小值还小，则把这个栈压入最小元素的栈中
 * 在出栈时，如果当前出栈的元素刚好是最小元素，保存最小值的栈顶元素也出栈，使得当前最小值变成它入栈之前的最小值
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/21
 */
public class FindMinValByStack {
	MyStackByLinkedList<Integer> elem;
	MyStackByLinkedList<Integer> min;

	public FindMinValByStack() {
		elem = new MyStackByLinkedList<>();
		min = new MyStackByLinkedList<>();
	}

	/**
	 * 压栈操作
	 */
	public void push(int data) {
		elem.push(data);
		// 如果最小值栈为空，将值压入
		if (min.isEmpty()) {
			min.push(data);
		} else {
			// 如果当前值比最小值栈的栈顶元素值还小，则将其压入最小值栈 这儿一定要用<= 号
			// 没有等于号的情况下，如果入栈的数据有重复的，例如1，6，1，5，3，2，那么栈顶的1出栈后，min中的最小值就为2了
			if (data <= min.peek()) {
				min.push(data);
			}
		}
	}

	/**
	 * 出栈操作
	 */
	public int pop() {
		// 将当前要出栈元素值储存在topData里
		int topData = elem.peek();
		// 值出栈
		elem.pop();
		// 如果刚才出栈的值刚好是最小值栈的最小值，将最小值栈的此值也出栈
		if (topData == this.min()) {
			min.pop();
		}
		return topData;
	}

	private int min() {
		if (min.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return min.peek();
		}
	}

	public static void main(String[] args) {
		FindMinValByStack stack = new FindMinValByStack();
		stack.push(5);
		stack.push(1);
		stack.push(2);
		stack.push(1);
		stack.push(0);
		stack.push(5);
		System.out.println("stack.min.peek() = " + stack.min.peek());
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println("stack.min.peek() = " + stack.min.peek());
	}
}
