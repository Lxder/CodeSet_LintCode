package com.MinimumDepthOfBinaryTree;

class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}

public class Solution {
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		TreeNode r1 = new TreeNode(2);
		
		TreeNode r21 = new TreeNode(3);
		TreeNode r2 = new TreeNode(4);
		root.right = r1;
		r1.left = r21;
		root.left = r2;
		System.out.println(new Solution().minDepth(r1));
	}
	
	public int minDepth(TreeNode root) {
		if(root == null ) return 0;
		if(root.left == null && root.right == null) return 1;
		int lh ;
		int rh ;
		if(root.left == null) {
			lh = Integer.MAX_VALUE;
		}else{ 
			lh = minDepth(root.left);
		}
		if(root.right == null){
			rh = Integer.MAX_VALUE;
		}else{
			rh = minDepth(root.right);
		}
		return Math.min(lh, rh)+1;
		
	}
}