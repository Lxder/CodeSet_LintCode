package stage206.Reverselinkedlist;



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
		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(3);
		ListNode n13 = new ListNode(5);
		ListNode n14 = new ListNode(7);
		ListNode n15 = new ListNode(9);
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;
		n15.next = null;
		ListNode solu  = reverse(n15);
		ListNode p = solu;
		while(p!=null){
			System.out.println(p.val);
			p=p.next;
		}
	}
	
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public static ListNode reverse(ListNode head) {
        // write your code here
    	
    	ListNode nhead = new ListNode(0);
    	ListNode p = head;
    	ListNode q = p;
    	while(p!=null){
    		q = p.next;
    		p.next = nhead.next;
    		nhead.next = p;
    		
    		p = q;
    	}
    	return nhead.next;
    }
}

