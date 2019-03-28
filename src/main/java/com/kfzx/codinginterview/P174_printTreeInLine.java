package com.kfzx.codinginterview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 分行从上到下打印二叉树
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/3/28
 */
@SuppressWarnings("all")
public class P174_printTreeInLine {
	private static class TreeNode<T> {
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
			for(int size=queue.size();size>0;size--){
				temp = queue.poll();
				System.out.print(temp.val + "\t");
				if (temp.left != null) {
					queue.offer(temp.left);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		//             1
		//          /    \
		//         2      3
		//       /  \    /  \
		//      4    5  6    7
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
