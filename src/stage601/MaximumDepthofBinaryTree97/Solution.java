package stage601.MaximumDepthofBinaryTree97;

import java.util.LinkedList;
import java.util.Queue;


public class Solution {
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(5);
		TreeNode l11 = new TreeNode(3);
		TreeNode l12 = new TreeNode(4);
		TreeNode r12 = new TreeNode(6);
		root.left = l1;
		root.right = r1;
		l1.left =l11;
		l1.right = l12; 
		r1.right = r12;
		System.out.println(maxDepth(null));
		
	}
	
	
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public static int maxDepth(TreeNode root) {
        // write your code here
    	if(root==null) return 0;
    	int maxh = 1;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	queue.add(null);
    	TreeNode temp = null;
    	while(!queue.isEmpty()){
    		temp = queue.poll();
    		if(temp!=null){
    			if(temp.left!=null) queue.add(temp.left);
    			if(temp.right!=null) queue.add(temp.right);
    		}else{
    			if(queue.isEmpty()) break;
    			maxh++;
    			queue.add(null);
    		}
    	}
    	return maxh;
    }
}