package stage408.ConvertBinarySearchTreeToDoublyLinkedList;

import java.util.ArrayList;
import java.util.Stack;

//Definition of TreeNode:
class TreeNode {
	public int val;
	public TreeNode left, right;
	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}

// Definition for Doubly-ListNode.
class DoublyListNode {
	int val;
	DoublyListNode next, prev;
	DoublyListNode(int val) {
		this.val = val;
		this.next = this.prev = null;
	}
}

public class Solution {
	/**
	 * @param root
	 *            : The root of tree
	 * @return: the head of doubly list node
	 */
	public DoublyListNode bstToDoublyList(TreeNode root) {
		// Write your code here
		if(root == null) return null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode curr = root;
		while(!stack.isEmpty()|| curr!=null){				
			if(curr!=null){
				stack.add(curr);
				curr = curr.left;
				continue;
			}
			if(!stack.isEmpty()){
				curr = stack.pop();
				list.add(curr.val);
				curr = curr.right;
			}
		}
		
		DoublyListNode head = new DoublyListNode(list.get(0));
		DoublyListNode curr_d = head;
		int len = list.size();
		for(int i = 1 ; i< len ; i++){
			DoublyListNode temp = new DoublyListNode(list.get(i));
			curr_d .next = temp;
			temp.prev = curr_d;
			curr_d = curr_d.next;
		}
		return head;
		
	}
	
	
}
