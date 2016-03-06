package com.SearchRangeInBinarySearchTree;

import java.util.ArrayList;

class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}

public class Solution {
	/**
	 * @param root
	 *            : The root of the binary search tree.
	 * @param k1
	 *            and k2: range k1 to k2.
	 * @return: Return all keys that k1<=key<=k2 in ascending order.
	 */
	public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
		// write your code here
		ArrayList<Integer> solu = new ArrayList<Integer>();

		helper(root, k1, k2, solu);
		return solu;

	}

	public void helper(TreeNode root, int k1, int k2, ArrayList<Integer> solu) {
		if (root == null)
			return;
		if (root.left != null && root.val > k1) {
			helper(root.left, k1, k2, solu);
		}
		if (root.val >= k1 && root.val <= k2) {
			solu.add(root.val);
		}
		if (root.right != null && root.val < k2) {
			helper(root.right, k1, k2, solu);
		}
	}
}