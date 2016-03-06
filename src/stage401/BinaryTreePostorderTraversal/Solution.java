package stage401.BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.Stack;




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
		System.out.println(postorderTraversal2(root));
	}

	
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
    	ArrayList<Integer> solu = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode curr = root; //指向当前要访问的节点
    	TreeNode pre = null; //指向前一个被访问的节点
    	while(curr!=null||!stack.isEmpty()){
    		while(curr!=null){
    			stack.push(curr);
    			curr = curr.left;
    		}
    		curr = stack.peek();
    		//如果当前节点的右节点已被访问或者为空，则访问该节点
    		if(curr.right==null || curr.right==pre){
    			solu.add(curr.val);
    			pre = curr;
    			stack.pop();
    			curr = null;
    		}else{ //否则，访问该节点的右孩子
    			curr = curr.right;
    		}
    	}
    	return solu;    	
    }
    
    
    public static ArrayList<Integer> postorderTraversal2(TreeNode root) {
	    ArrayList<Integer> solu = new ArrayList<Integer>();
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode curr = root; //指向当前要访问的节点
	    TreeNode pre = null; //指向前一个被访问的节点
	    while(curr!=null||!stack.isEmpty()){
	        if(curr!=null){
	            stack.push(curr);
	            curr = curr.left;
	        }else{
	        	curr = stack.peek();
	        	//如果当前节点的右节点已没有访问 且 不为空，则将右节点加入到stack
		        if(curr.right!=null && curr.right!=pre){
		        	curr = curr.right;
		        }else{ //否则，说明该节点为最右边，或者它的右边均已访问，应该访问此节点。
		        	solu.add(curr.val);
		            pre = curr;
		            stack.pop();
		            curr = null;
		        }
	        }
	    }
	    return solu;        
	}
}
