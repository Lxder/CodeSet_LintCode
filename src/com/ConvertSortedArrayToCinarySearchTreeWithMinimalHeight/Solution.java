package com.ConvertSortedArrayToCinarySearchTreeWithMinimalHeight;

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
		int[] A ={};
		new Solution().sortedArrayToBST(A);
		
		
	}
	/**
	 * @param A
	 *            : an integer array
	 * @return: a tree node
	 */
	public TreeNode sortedArrayToBST(int[] A) {
		// write your code here
		int len = A.length;
		TreeNode  root = helper(A,0 , len-1);
		return root;
		
	}
	
	public TreeNode helper( int[] A , int st , int ed){
		if(st > ed ) return null;
		int mid = (st+ed)/2;
		TreeNode root = new TreeNode(A[mid]);
		root.left = helper(A,st,mid-1);
		root.right = helper(A,mid+1,ed);
		return root;
		
	}
}
