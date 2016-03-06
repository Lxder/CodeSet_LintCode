package com.PalindromeLinkedList;


class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	
	public static void main(String args[]){
		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(2);
		ListNode n13 = new ListNode(2);
		ListNode n14 = new ListNode(2);
		ListNode n15 = new ListNode(2);
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;
		n15.next = null;
		System.out.println(isPalindrome(n11));
	}
	/**
	 * @param head
	 *            a ListNode
	 * @return a boolean
	 */
	public static boolean isPalindrome(ListNode head) {
		// Write your code here
		if(head==null||head.next == null) return true;
		
		int len = 0;
		ListNode p = head;
		while(p!=null){
			p = p.next;
			len ++;
		}
		
		ListNode h = new  ListNode(0);
		
		p = head;
		ListNode pn = p.next;		
		int mid = len/2;
		
		for(int i = 0 ; i < mid ; i++){
			p.next = h.next;
			h.next = p;
			p = pn;
			pn = pn.next;
		}
		
		
		if(len%2==0) pn = p;
		p = h.next;		
		
		
		for(int i = 0 ; i < mid ; i++){
			if(p.val != pn.val) return false;
			p=p.next;
			pn = pn.next;
		}
		return true;
		
	}
}
