package stage215.ReverseLinkedListII;


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
		ListNode solu  = reverseBetween(n15,1,1);
		ListNode p = solu;
		System.out.println("=======");
		while(p!=null){
			System.out.println(p.val);
			p=p.next;
			
		}
		
	}
	
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
	
    public static ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
    	ListNode nhead = new ListNode(0);
    	nhead.next = head;
    	
    	ListNode p = head;
    	ListNode pre = nhead;
    	for(int i = 1 ;i < m ; i++){
    		p = p.next;
    		pre = pre.next;
    	}
    	System.out.println(p.val);
    	System.out.println(pre.val);
    	System.out.println(m+"========");
    	ListNode currend = p;
    	ListNode q;
    	for(int curr = m  ;curr<=n ; curr++){
    		System.out.println(p.val+" "+curr);
    		q = p.next;
    		p.next = pre.next;
    		pre.next = p;
    		p=q;
    	}
    	
    	currend.next = p;
    	
    	return nhead.next;
    	
    }
}
