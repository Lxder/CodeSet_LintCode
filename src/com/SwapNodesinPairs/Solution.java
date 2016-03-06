package com.SwapNodesinPairs;


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
		ListNode n13 = new ListNode(3);
		ListNode n14 = new ListNode(4);
		ListNode n15 = new ListNode(5);
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;
		n15.next = null;
		Solution s = new Solution();
		ListNode p = s.swapPairs(null);
		
		while(p!=null){
			System.out.println(p.val);
			p = p.next;
		}
	}
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode h = new ListNode(0);
		h.next = head;
		ListNode pre = h;
		ListNode p = h.next;
		while(p!=null && p.next!=null){
			pre.next = p.next;
			p.next = pre.next.next;
			pre.next.next = p;
			pre = p ;
			p = p.next;
		}
		return h.next;
		
	}
}