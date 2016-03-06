package stage403.BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Solution {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		System.out.println(levelOrder(l1));
	}
	
	
	
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
	
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
    	ArrayList<ArrayList<Integer>> solu = new ArrayList<ArrayList<Integer>>();
    	if(root==null) return solu;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	TreeNode curr = root;
    	
    	queue.add(curr);
    	queue.add(null);
    	List<Integer> temp = new ArrayList<Integer>();
    	while(!queue.isEmpty()){
    		curr = queue.poll();
    		if(curr==null){    			
    			//将当前结果插入solu
    			solu.add(new ArrayList<Integer>(temp));
    			temp = new ArrayList<Integer>();
    			if(queue.isEmpty()) break;
    			queue.add(null);
    			
    		}
    		else{
    			temp.add(curr.val);
    			if(curr.left!=null) queue.add(curr.left);
    			if(curr.right!=null) queue.add(curr.right);
    		}
    		try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		System.out.println(curr);
    	}
    	return solu;
    }
}
