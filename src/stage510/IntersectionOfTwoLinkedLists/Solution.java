package stage510.IntersectionOfTwoLinkedLists;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		// Write your code here
		if(headA==null||headB==null) return null;
		ListNode p1 = headA;
		ListNode p2 = headB;
		int len1 = 0;
		int len2 = 0;
		while(p1!=null){
			len1++;
			p1 = p1.next;
		}
		while(p2!=null){
			len2++;
			p2 = p2.next;
		}
		//保持p1指向长的那个
		if(len1<len2){
			p1 = headB;
			p2 = headA;
		}
		int diff = Math.abs(len1-len2);
		while(diff>0){
			p1 = p1.next;
		}
		while(p1!=null){
			if(p1==p2) return p1;
			p1 = p1.next ; 
			p2 = p2.next;
		}
		return null;
		
		
	}

}
