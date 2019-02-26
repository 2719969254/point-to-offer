package com.kfzx.codinginterview;

/**
 * 树的子结构
 * <p>
 * 输入两棵二叉树A和B，判断B是不是A的子结构。
 * <p>
 * 当A有一个节点与B的根节点值相同时，则需要从A的那个节点开始严格匹配，对应于下面的tree1HasTree2FromRoot函数。
 * 如果匹配不成功，则返回到开始匹配的那个节点，对它的左右子树继续判断是否与B的根节点值相同，重复上述过程。
 * 应注意，必须先比较root2的节点是否为空
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/26
 */
public class P148_SubstructureInTree {
	static class TreeNode<T> {
		T val;
		TreeNode<T> left;
		TreeNode<T> right;

		TreeNode(T val) {
			this.left = null;
			this.right = null;
			this.val = val;
		}
	}

	private static boolean hasSubtree(TreeNode<Integer> root1, TreeNode<Integer> root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}
		if (root1.val.equals(root2.val)) {
			if (tree1HasTree2FromRoot(root1, root2)) {
				return true;
			}
		}
		return hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
	}

	private static boolean tree1HasTree2FromRoot(TreeNode<Integer> root1, TreeNode<Integer> root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}

		return root1.val.equals(root2.val) && tree1HasTree2FromRoot(root1.left, root2.left) && tree1HasTree2FromRoot(root1.right, root2.right);
	}

	public static void main(String[] args) {
		TreeNode<Integer> root1 = new TreeNode<>(8);
		root1.left = new TreeNode<>(8);
		root1.right = new TreeNode<>(7);
		root1.left.left = new TreeNode<>(9);
		root1.left.right = new TreeNode<>(2);
		root1.left.right.left = new TreeNode<>(4);
		root1.left.right.right = new TreeNode<>(7);
		TreeNode<Integer> root2 = new TreeNode<>(8);
		root2.left = new TreeNode<>(9);
		root2.right = new TreeNode<>(2);
		TreeNode<Integer> root3 = new TreeNode<>(2);
		root3.left = new TreeNode<>(4);
		root3.right = new TreeNode<>(3);
		System.out.println(hasSubtree(root1, root2));
		System.out.println(hasSubtree(root1, root3));
	}
}
