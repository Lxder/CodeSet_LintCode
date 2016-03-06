package stage807.LinkedListCycleII;



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
		System.out.println(detectCycle(n15).val);
	}
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public static ListNode detectCycle(ListNode head) {  
        // write your code here
    	if(head == null||head.next==null) return null;
    	ListNode slow = head;
    	ListNode fast = head.next;
    	while(fast!=null&&fast.next != null){
    		if(slow == fast) break;
    		slow = slow.next ;
    		fast = fast.next.next;
    	}
    	
    	if(fast==null||fast.next==null) return null;
    	
    	ListNode p = head;
    	
    	
    	if(p == slow) return slow;
    	//p = p.next;
    	slow = slow.next;
    	while(p!=slow){
    		p = p.next;
    		slow = slow.next;
    	}
    	return p;
    	
    	
    }
}