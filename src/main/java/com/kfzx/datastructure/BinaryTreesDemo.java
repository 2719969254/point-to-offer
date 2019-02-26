package com.kfzx.datastructure;

/**
 * 实现二叉排序树
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/26
 */

public class BinaryTreesDemo {
	static class Node {
		private int data;
		private Node left;
		private Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	private Node root;

	private BinaryTreesDemo() {
		root = null;
	}

	/**
	 * 将data插入到有序二叉树中
	 */
	private void insert(int data) {
		Node newNode = new Node(data);
		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent;
			// 寻找插入的位置
			while (true) {
				parent = current;
				if (data < current.data) {
					current = current.left;
					if (current == null) {
						parent.left = newNode;
						return;
					}
				} else {
					current = current.right;
					if (current == null) {
						parent.right = newNode;
						return;
					}
				}

			}
		}
	}

	/**
	 * 将数值输入，构建二叉树
	 */

	private void buildTree(int[] data) {
		for (int i : data) {
			insert(i);
		}
	}

	/**
	 * 中序遍历方法递归实现
	 */

	private void inOrder(Node localRoot) {
		if (localRoot != null) {
			inOrder(localRoot.left);
			System.out.print(localRoot.data + "\t");
			inOrder(localRoot.right);
		}
	}

	private void inOrder() {
		this.inOrder(this.root);
	}

	/**
	 * 先序遍历递归实现
	 */
	private void preOrder(Node localRoot) {
		if (localRoot != null) {
			System.out.print(localRoot.data + "\t");
			preOrder(localRoot.left);
			preOrder(localRoot.right);
		}
	}

	private void preOrder() {
		this.preOrder(this.root);
	}

	/**
	 * 后续遍历递归实现
	 */
	private void postOrder(Node localRoot) {
		if (localRoot != null) {
			preOrder(localRoot.left);
			preOrder(localRoot.right);
			System.out.print(localRoot.data + "\t");
		}
	}
	private void postOrder(){
		this.postOrder(this.root
		);
	}

	public static void main(String[] args) {
		BinaryTreesDemo demo = new BinaryTreesDemo();
		int[] data = {2,8,7,4,9,3,1,6,7,5};
		demo.buildTree(data);
		System.out.println("二叉树的中序遍历");
		demo.inOrder();
		System.out.println();
		System.out.println("二叉树的先序遍历");
		demo.preOrder();
		System.out.println();
		System.out.println("二叉树的后序遍历");
		demo.postOrder();
		System.out.println();
	}
}
