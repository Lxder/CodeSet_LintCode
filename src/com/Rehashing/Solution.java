package com.Rehashing;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	
	/**
	 * @param hashTable
	 *            : A list of The first node of linked list
	 * @return: A list of The first node of linked list which have twice size
	 */
	public ListNode[] rehashing(ListNode[] hashTable) {
		int len = hashTable.length;
		int nlen = len*2;
		ListNode[] solu = new ListNode[nlen];
		ListNode[] p = new ListNode[nlen];
		for(int i =  0 ; i < nlen ; i ++){
			p[i] = solu[i];
		}
		for(int i = 0 ; i < len ; i ++){
			ListNode curr = hashTable[i];
			while(curr!=null){
				int currhashcode = (curr.val%nlen+nlen)%nlen;
				ListNode node = new ListNode(curr.val);
				if(solu[currhashcode]!=null){
					p[currhashcode].next = node; 
					p[currhashcode] = p[currhashcode].next;
				}else{
					solu[currhashcode] = node;
					p[currhashcode] = node; //Ö¸ÕëÖ¸ÏòÄ©Î²
				}
				curr = curr.next;
			}
		}
		return solu;
	}
};
