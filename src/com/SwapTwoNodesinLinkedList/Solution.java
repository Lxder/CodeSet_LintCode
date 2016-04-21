package com.SwapTwoNodesinLinkedList;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	public static void main(String[] args){
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		ListNode solu = new Solution().swapNodes(l1, 2, 2);
		ListNode p = solu;
		while(p!=null){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(p.val);
			p = p.next;
		}
	}
	
	/**
	 * @param head
	 *            a ListNode
	 * @oaram v1 an integer
	 * @param v2
	 *            an integer
	 * @return a new head of singly-linked list
	 */
	public ListNode swapNodes(ListNode head, int v1, int v2) {
		// Write your code here
		if(head == null||head.next==null) return head;
		ListNode nhead = new ListNode(0);
		nhead.next = head;
		ListNode p = nhead;
		ListNode pre1 = null;
		ListNode pre2 = null;
		while(p!= null){
			if(p.next!=null){
				if(p.next.val == v1){
					pre1 = p;
				}
				if(p.next.val == v2){
					pre2 = p;
				}
			}
			p = p.next;
		}
		if(pre1 == null || pre2 == null){
			return head;
		}
		
		
		ListNode t1 = pre1.next;
		ListNode t2 = pre2.next;
		ListNode post1 = t1.next;
		ListNode post2 = t2.next;
		
		if(pre1.next == pre2){
			pre1.next = t2;
			t1.next=post2;
			t2.next = t1;
			return nhead.next;
		}
		if(pre2.next == pre1){
			pre2.next = t1;
			t2.next = post1;
			t1.next = t2;
			return nhead.next;
		}
		
		pre1.next = t2;
		t2.next = post1;
		
		pre2.next = t1;
		t1.next = post2;
		
		return nhead.next;		
	}
}