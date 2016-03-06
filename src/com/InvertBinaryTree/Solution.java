package com.InvertBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}

public class Solution {	
	public void invertBinaryTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode curr =root;
		TreeNode temp = null;
		queue.add(curr);		
		while(!queue.isEmpty()){
			curr = queue.poll();
			temp = curr.left ; 
			curr.left = curr.right;
			curr.right = temp;
			if(curr.left  != null) queue.add(curr.left);
			if(curr.right != null) queue.add(curr.right);
		}
	}
}