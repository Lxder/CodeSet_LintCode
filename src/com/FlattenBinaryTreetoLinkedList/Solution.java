package com.FlattenBinaryTreetoLinkedList;

class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}

//将二叉树按照前序遍历变成链表
public class Solution {
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(5);
		TreeNode l11 = new TreeNode(3);
		TreeNode l12 = new TreeNode(4);
		TreeNode r12 = new TreeNode(6);
		root.left = l1;
		root.right = r1;
		l1.left = l11;
		l1.right = l12;
		r1.right = r12;
		Solution s = new Solution();
		s.flatten(root);
		TreeNode p = root;
		while(p != null){
			System.out.println(p.val);
			p = p.right;
		}
	}
	public void flatten(TreeNode root) {
		if(root == null) return ;
		TreeNode temp = root.right;
		root.right = root.left;
		root.left = null;
		flatten(root.right);
		
		TreeNode p = root;
		while(p.right!=null){
			p=p.right;
		}
		p.right = temp;
		flatten(temp);
	}
	
	
}