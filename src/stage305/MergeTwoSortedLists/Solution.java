package stage305.MergeTwoSortedLists;
public class Solution {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
    	ListNode nhead = new ListNode(0);
    	ListNode p1 = l1;
    	ListNode p2 = l2;
    	ListNode rear = nhead;
    	while(p1!=null&&p2!=null){
    		if(p1.val<p2.val){
    			rear.next = p1;
    			p1=p1.next;
    		}
    		else{
    			rear.next = p2;
    			p2 = p2.next;
    		}
    		rear = rear.next;
    		
    	}
    	
    	if(p1!=null) rear.next = p1;
    	if(p2!=null) rear.next = p2;
    	return nhead.next;
    }
}
