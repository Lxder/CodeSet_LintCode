package com.MergeKSortedLists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

public class Solution {
	/**
	 * @param lists
	 *            : a list of ListNode
	 * @return: The head of one sorted list.
	 */
	public ListNode mergeKLists(List<ListNode> lists) {
		// write your code here
		ListNode solu = new ListNode(0);
		ListNode p = solu;
		
		int len = lists.size();
		
		TreeSet<ListNode> tset = new TreeSet<ListNode>(new Comparator<ListNode>(){
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if(o1.val > o2.val)
					return 1;
				else //不单独处理"="的情况，避免相同元素被覆盖
					return -1;
			}
		});
		
		for(int i = 0 ; i < len ; i++){
			
			ListNode currn = lists.get(i);
			if(currn!=null)
				tset.add(currn);			
		}
		while(!tset.isEmpty()){
			ListNode cmin = tset.pollFirst();
			ListNode cnext = cmin.next;
			p.next = cmin;
			p = p .next;
			if(cnext!=null){
				tset.add(cnext);
			}
		}
		return solu.next;
	}
}
