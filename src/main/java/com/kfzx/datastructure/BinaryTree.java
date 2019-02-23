package com.kfzx.datastructure;

/**
 * TreeNode
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/8
 */
class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode() {
	}

	TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

/**
 * 根据二叉树前序、中序遍历求出后续遍历
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/8
 */
public class BinaryTree {
	private TreeNode root;

	private BinaryTree() {
		this.root = null;
	}

	private void initTree(int[] preOrder, int[] inOrder) {
		this.root = this.initTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
	}

	private TreeNode initTree(int[] preOrder, int start1, int end1, int[] inOrder, int start2, int end2) {
		if (start1 > end1 || start2 > end2) {
			return null;
		}
		int rootData = preOrder[start1];
		TreeNode head = new TreeNode(rootData);
		// 找到根节点所在位置
		int rootIndex = findIndexInArray(inOrder, rootData, start2, end2);
		int offSet = rootIndex - start2 - 1;
		// 构建左子树
		TreeNode left = initTree(preOrder, start1 + 1, start1 + 1 + offSet, inOrder, start2, start2 + offSet);
		// 构建右子树
		TreeNode right = initTree(preOrder, start1 + offSet + 2, end1, inOrder, rootIndex + 1, end2);
		head.left = left;
		head.right = right;
		return head;
	}

	private int findIndexInArray(int[] a, int x, int begin, int end) {
		for (int i = begin; i <= end; i++) {
			if (a[i] == x) {
				return i;
			}
		}
		return -1;
	}

	private void postOrder() {
		this.postOrder(this.root);
	}

	private void postOrder(TreeNode localRoot) {
		if (localRoot != null) {
			postOrder(localRoot.left);
			postOrder(localRoot.right);
			System.out.print(localRoot.data + "   ");
		}
	}

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		int[] preOrder = {1, 2, 4, 8, 9, 5, 10, 3, 6, 7};
		int[] inOrder = {8, 4, 9, 2, 10, 5, 1, 6, 3, 7};
		binaryTree.initTree(preOrder, inOrder);
		System.out.println("二叉树的后续遍历");
		binaryTree.postOrder();
	}
}
