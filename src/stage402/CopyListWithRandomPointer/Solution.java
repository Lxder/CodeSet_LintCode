package stage402.CopyListWithRandomPointer;

import java.util.HashMap;


class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}

public class Solution {
	
	
	public static void main(String[] args) {
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		RandomListNode n4 = new RandomListNode(4);
		RandomListNode n5 = new RandomListNode(5);
		RandomListNode n6 = new RandomListNode(6);
		RandomListNode n7 = new RandomListNode(7);
		n1.next = n2 ; 
		n2.next = n3 ; 
		n3.next = n4 ; 
		n4.next = n5 ; 
		n5.next = n6 ; 
		n6.next = n7 ; 
		n7.next = null ;
		
		n1.random = n3;
		n2.random = n4;
		n3.random = n6;
		n4.random = n6;
		n5.random = n7;
		RandomListNode solu = copyRandomList(n1);
		RandomListNode p = solu; 
		
		
		
		while(p.next!=null){
			System.out.print("p.val:"+p.label+" p.next.val:"+p.next.label );
			if(p.random!=null)
				System.out.println(" p.random.val:"+p.random.label);
			else System.out.println();
			p = p.next;
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
		
	}
	/**
	 * @param head
	 *            : The head of linked list with a random pointer.
	 * @return: A new head of a deep copy of the list.
	 */
	public static RandomListNode copyRandomList(RandomListNode head) {
		// write your code here
		HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
		RandomListNode nhead = new RandomListNode(0);
		RandomListNode rear = nhead;
		RandomListNode p = head;
		while(p!=null){
			
			RandomListNode c = map.get(p);
			if(c==null){
				RandomListNode curr = new RandomListNode(p.label);
				map.put(p, curr);
				rear.next = curr;
				
			}else{
				rear.next =c;
			}
			rear = rear.next;
			
			if(p.random!=null){
				RandomListNode r = map.get(p.random);
				if(r==null){
					RandomListNode rand = new RandomListNode(p.random.label);
					rear.random = rand;
					map.put(r, rand);
				}else{
					rear.random = r;
				}
			}
			p = p.next;
		}
		return nhead.next;
		
	}
}
