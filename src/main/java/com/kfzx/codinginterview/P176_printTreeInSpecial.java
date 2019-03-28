package com.kfzx.codinginterview;

import java.util.Stack;

/**
 * 之字形打印二叉树
 * <p>
 * 按之字形顺序打印二叉树需要两个栈。我们在打印某一行结点时，把下一层的子结点保存到相应的栈里。
 * 如果当前打印的是奇数层，则先保存左子结点再保存右子结点到一个栈里；
 * 如果当前打印的是偶数层，则先保存右子结点再保存左子结点到第二个栈里。
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/3/28
 */
@SuppressWarnings("all")
public class P176_printTreeInSpecial {
	private static class TreeNode<T> {
		public T val;
		public TreeNode<T> left;
		public TreeNode<T> right;

		public TreeNode(T val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}

		public static void printTreeInSpeical(TreeNode<Integer> root) {
			if (root == null) {
				return;
			}
			Stack<TreeNode<Integer>> stack1 = new Stack<>();
			Stack<TreeNode<Integer>> stack2 = new Stack<>();

			TreeNode<Integer> temp;

			stack1.push(root);

			while (!stack1.isEmpty() || !stack2.isEmpty()) {
				if (!stack1.isEmpty()) {
					while (!stack1.isEmpty()) {
						temp = stack1.pop();
						System.out.print(temp.val + "\t");
						if (temp.left != null) {
							stack2.push(temp.left);
						}
						if (temp.right != null) {
							stack2.push(temp.right);
						}

					}
				} else {
					while (!stack2.isEmpty()) {
						temp = stack2.pop();
						System.out.print(temp.val + "\t");
						if (temp.right != null) {
							stack1.push(temp.right);
						}
						if (temp.left != null) {
							stack1.push(temp.left);
						}
					}
				}
				System.out.println();
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
			printTreeInSpeical(root);
		}
	}
}
