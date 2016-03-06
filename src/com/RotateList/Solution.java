package com.RotateList;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public static void main(String args[]){
		ListNode h1 = new ListNode(1);
		ListNode h2 = new ListNode(2);
		ListNode h3 = new ListNode(3);
		ListNode h4 = new ListNode(4);
		ListNode h5 = new ListNode(5);
		h1.next = h2;
		h2.next = h3;
		h3.next = h4;
		h4.next = h5;
		ListNode solu = new Solution().rotateRight(h5, 2);
		while(solu!=null){
			System.out.println(solu.val);
			solu = solu.next;
		}
		
	}
	/**
	 * @param head
	 *            : the List
	 * @param k
	 *            : rotate to the right k places
	 * @return: the list after rotation
	 */
	public ListNode rotateRight(ListNode head, int k) {
		if(k==0||head == null) return head;
		ListNode p = head ;
		ListNode h  = new ListNode(0);
		h.next = head;
		int len = 0;
		while( p != null){
			len ++ ;
			p = p.next;
		}
		ListNode pre = h;
		p = head;
		k = k%len;
		for(int i = 0 ; i < len -k ;i ++){
			pre = pre.next;
			p = p.next;
		}
		
		if(p == null) return head;
		pre.next = null;
		pre = p;
		
		while(pre.next!=null){
			pre = pre.next;
		}		
		pre.next = head;
		return p;
		
	}
}