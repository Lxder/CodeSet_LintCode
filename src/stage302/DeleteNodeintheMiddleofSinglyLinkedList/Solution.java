package stage302.DeleteNodeintheMiddleofSinglyLinkedList;
public class Solution {
    /**
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // write your code here
    	node.val = node.next.val;
    	node.next = node.next.next;
    }
}
