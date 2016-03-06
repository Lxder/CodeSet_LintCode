package com.BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;





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
		Solution s = new Solution();
		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(3);
		TreeNode r21 = new TreeNode(5);
		TreeNode r22 = new TreeNode(6);
		TreeNode r31 = new TreeNode(7);
		TreeNode r32 = new TreeNode(8);
		root.left = l1;
		root.right = r1;
		r1.left = r21;
		r1.right = r22;
		r21.left  =r31;
		r21.right = r32;
		System.out.println(s.binaryTreePaths(root));
	}
	public List<String> binaryTreePaths(TreeNode root) {
		// Write your code here
		List<String> solu = new ArrayList<String>();
		if(root == null ) return solu;
		StringBuffer currsb = new StringBuffer();
		helper(solu,currsb,root);
		return solu;
				
	}
	
	public void helper(List<String> solu , StringBuffer currsb ,  TreeNode root ){
		if(root == null) return ;
		if(root.left == null && root.right == null){
			StringBuffer csb = new StringBuffer(currsb);
			csb.append("->"+root.val);
			solu.add(csb.toString().substring(2));
			return ;
		}		
		StringBuffer nsb = new StringBuffer(currsb);
		nsb.append("->"+root.val);
		helper(solu,nsb,root.left);
		helper(solu,nsb,root.right);
		
	}
}