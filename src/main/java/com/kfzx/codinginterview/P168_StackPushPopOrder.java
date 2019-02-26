package com.kfzx.codinginterview;

import java.util.Stack;

/**
 * 栈的压入弹出序列
 * <p>
 * 输入两个整数序列，第一个序列表示栈的压入顺序，判断第二个序列是否为该栈的弹出序列。假设压入栈的所有数字均不相等。
 * 例如，压入序列为(1,2,3,4,5)，序列(4,5,3,2,1)是它的弹出序列，而(4,3,5,1,2)不是。
 * <p>
 * 对于一个给定的压入序列，由于弹出的时机不同，会出现多种弹出序列。
 * 如果是选择题，依照后进先出的原则，复现一下栈的压入弹出过程就很容易判断了。
 * 写成程序同样如此，主要步骤如下：
 * <p>
 * 步骤1：栈压入序列第一个元素，弹出序列指针指弹出序列的第一个；
 * 步骤2：判断栈顶元素是否等于弹出序列的第一个元素：
 * 步骤2.1：如果不是，压入另一个元素，进行结束判断，未结束则继续执行步骤2；
 * 步骤2.2：如果是，栈弹出一个元素，弹出序列指针向后移动一位，进行结束判断，未结束则继续执行步骤2；
 * <p>
 * 结束条件：如果弹出序列指针还没到结尾但已经无元素可压入，则被测序列不是弹出序列。
 * 如果弹出序列指针以判断完最后一个元素，则被测序列是弹出序列。
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/26
 */
public class P168_StackPushPopOrder {
	private static boolean isPopOrder(int[] pushSeq, int[] popSeq) {
		if (pushSeq == null || popSeq == null || pushSeq.length != popSeq.length) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		int pushSeqIndex = 0, popSeqIndex = 0;
		while (popSeqIndex < popSeq.length) {
			if (stack.isEmpty() || stack.peek() != popSeq[popSeqIndex]) {
				if (pushSeqIndex < pushSeq.length) {
					stack.push(pushSeq[pushSeqIndex++]);
				} else {
					return false;
				}
			} else {
				stack.pop();
				popSeqIndex++;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] push = {1, 2, 3, 4, 5};
		int[] pop1 = {4, 5, 3, 2, 1};
		int[] pop2 = {4, 3, 5, 1, 2};
		System.out.println(isPopOrder(push, pop1));
		System.out.println(isPopOrder(push, pop2));
	}
}
