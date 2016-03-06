package com.InsertionSortList;

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

public class Solution {
	public static void main(String args[]){
		ListNode h1 = new ListNode(1);
		ListNode h2 = new ListNode(0);
		ListNode h3 = new ListNode(2);
		h1.next = h2;
		h2.next = h3;
		ListNode s = new Solution().insertionSortList(h2);
		ListNode p =s;
		while(p!=null){
			System.out.println(p.val);
			p=p.next;
		}
	}
	
	/**
	 * @param head
	 *            : The first node of linked list.
	 * @return: The head of linked list.
	 */
	public ListNode insertionSortList(ListNode head) {
		// write your code here
		if(head == null) return null;
		ListNode h = new ListNode(0);
		h.next = head;
		
		ListNode iouter = head.next;
		head.next = null;
		
		ListNode next;
		ListNode iinner = head;
		ListNode pre = h;
		while(iouter != null){
		    next = iouter.next;
			pre = h;
			iinner = h.next;
			
			while(iinner!=null){				
				if(iinner.val <iouter.val){
					iinner = iinner.next;
					pre = pre.next;
				}else{
					iouter.next = iinner;
					pre.next = iouter;
					break;
				}
			}
			
			if(iinner == null){ //已经到了最后一个位置
				pre.next = iouter;
				iouter.next = null;
			}
			iouter = next;
		}
		return h.next;
	}
}