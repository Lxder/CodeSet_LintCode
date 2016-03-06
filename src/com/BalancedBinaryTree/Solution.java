package com.BalancedBinaryTree;

class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}

public class Solution {
	public boolean isBalanced(TreeNode root) {
		// write your code here
		if(helper(root)==-1)
			return false;
		return true;
	}
	
	public int helper(TreeNode root){
		if(root == null) return 0;
		int lh = helper(root.left);
		int rh = helper(root.right);
		if(lh == -1 || rh ==-1 ||Math.abs(lh-rh)>1){
			return -1;
		}
		return 1+Math.max(lh, rh);
			
	}

}