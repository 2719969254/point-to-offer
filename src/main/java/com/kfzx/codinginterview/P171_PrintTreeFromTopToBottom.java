package com.kfzx.codinginterview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印二叉树(层序遍历)
 * <p>
 * 这道题实质上考察的就是树的遍历算法，只是这种遍历不是我们熟悉的前序、中序或者后序遍历。
 * 由于我们不太熟悉这种按层遍历的方法，可能一下也想不清楚遍历的过程。
 * 因为按层打印的顺序决定应该先打印的根节点，所以我们从树的根节点开始分析。
 * 为了接下来能够打印1的节点的两个子节点，我们应该在遍历到该节点时把值为2和3的两个节点保存到一个容器中，现在容器内就有两个节点了。
 * 按照从左到右打印的要求，我们先取出值为2的节点。打印出2后把它的值分别为4和5的两个节点放入数据容器。
 * 此时数据容器中有三个节点，值分别为3，4，5.接下来我们从数据容器中取出值为3的节点。
 * 注意到值为3的节点比值为4，5，的节点先放入容器，此时又比这两个节点先取出，这就是我们通常说的先入先出，
 * 因此不难看出这个容器应该是一个队列。由于值为4,5,6,7的节点都没有子节点，因此只要依次打印即可。
 * 通过分析具体例子，我们可以找到从上到下打印二叉树的规律：
 * 每一次打印一个节点的时候，如果该节点有子节点，把该节点的子节点放到一个队列的尾。
 * 接下来到队列的头部取出最早进入队列的节点，重复前面打印操作，直到队列中所有的节点都被打印出为止。
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/3/28
 */

public class P171_PrintTreeFromTopToBottom {
	static class TreeNode<T> {
		T val;
		TreeNode<T> left;
		TreeNode<T> right;

		TreeNode(T val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	private static void printFromTopToBottom(TreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		TreeNode<Integer> temp;
		while (!queue.isEmpty()) {
			temp = queue.poll();
			System.out.print(temp.val + "\t");
			if (temp.left != null) {
				queue.offer(temp.left);
			}
			if (temp.right != null) {
				queue.offer(temp.right);
			}
		}

	}

	public static void main(String[] args) {
		//            1
		//          /   \
		//         2     3
		//       /  \   / \
		//      4    5 6   7
		TreeNode<Integer> root = new TreeNode<>(1);
		root.left = new TreeNode<>(2);
		root.right = new TreeNode<>(3);
		root.left.left = new TreeNode<>(4);
		root.left.right = new TreeNode<>(5);
		root.right.left = new TreeNode<>(6);
		root.right.right = new TreeNode<>(7);
		printFromTopToBottom(root);
	}
}
