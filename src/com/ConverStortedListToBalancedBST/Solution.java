package com.ConverStortedListToBalancedBST;

import java.util.ArrayList;
import java.util.List;

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

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
		
	}
	/**
	 * @param head
	 *            : The first node of linked list.
	 * @return: a tree node
	 */
	public TreeNode sortedListToBST(ListNode head) {
		// write your code here
		List<ListNode> list = new ArrayList<ListNode>();
		ListNode q = head;
		while(q!=null){
			list.add(q);
			q = q.next;
		}
		int len = list.size();
		return helper(list,0,len-1);
	}
	
	public TreeNode helper( List<ListNode> list , int st , int ed){
		if(st > ed){
			return null;
		}
		int mid = (st+ed)/2;
		TreeNode root = new TreeNode(list.get(mid).val);
		root.left  = helper(list , st , mid - 1);
		root.right = helper(list , mid + 1 , ed);
		return root;
	}
}
