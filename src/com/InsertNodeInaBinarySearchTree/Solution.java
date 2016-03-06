package com.InsertNodeInaBinarySearchTree;

class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}

public class Solution {
	public TreeNode insertNode(TreeNode root, TreeNode node) {
		TreeNode curr = root;
		if(root == null) return node;
		while(true){
			if(node.val > curr.val){
				if(curr.right == null){
					curr.right = node;
					break;
				}
				curr = curr.right;
			}else{
				if(curr.left == null){
					curr.left = node;
					break;
				}
				curr = curr.left;
			}
		}
		return root;
		
	}
}