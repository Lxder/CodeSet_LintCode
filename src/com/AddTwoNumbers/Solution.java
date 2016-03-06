package com.AddTwoNumbers;

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
		ListNode l11 = new ListNode(9);
		ListNode l12 = new ListNode(9);
		ListNode l13 = new ListNode(9);
		
		ListNode l21 = new ListNode(1);
		ListNode l22 = new ListNode(9);
		ListNode l23 = new ListNode(2);
		
		l11.next = l12;
		l12.next = l13;
		
		l21.next = l22;
		l22.next = l23;
		ListNode solu = new Solution().addLists(l11,l21);
		while(solu!=null){
			System.out.println(solu.val);
			solu = solu.next;
		}
	}
	public ListNode addLists(ListNode l1, ListNode l2) {
		ListNode solu = new ListNode(0);
		ListNode p = solu;
		int temp = 0;
		int sum = 0;
		while(l1 != null && l2 != null){
			sum = l1.val+l2.val + temp;
			ListNode curr  ;
			if(sum >= 10){
				curr = new ListNode(sum%10);
				temp = sum / 10;
			}else{
				curr = new ListNode(sum);
				temp = 0; 
			}
			p.next = curr;
			p = p.next ;
			l1 = l1.next ;
			l2 = l2.next ;
		}
		ListNode poi1;
		if(l2 != null){
			poi1 = l2;
		}else{
			poi1 = l1;
		}
		
		while(poi1!=null){
			sum = poi1.val + temp;
			ListNode curr ; 
			if(sum>=10){
				curr = new ListNode(sum%10);
				temp = sum/10;
			}else{
				curr = new ListNode(sum);
				temp = 0;
			}
			p.next = curr;
			p = p.next;
			poi1 = poi1.next;
		}
		if(temp!=0){
			p.next = new ListNode(temp);
		}
		return solu.next;
		
	}
}