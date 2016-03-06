package stage304.RemoveNthNodeFromEndofList;


public class Solution {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		ListNode p = removeNthFromEnd(n15, 1);
		while(p!=null){
			System.out.println(p.val);
			p=p.next;
		}
		
	}
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    static ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
    	ListNode nhead = new ListNode(0);
    	nhead.next = head;
    	ListNode p = nhead;
    	int i = 0 ;
    	while(i<=n){
    		p=p.next;
    		i++;
    	}
    	ListNode q =nhead;
    	while(p!=null){
    		p=p.next;
    		q=q.next;
    	}

    	q.next = q.next.next;
    	return nhead.next;
    }
}
