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
    	TreeNode curr = root; //ָ��ǰҪ���ʵĽڵ�
    	TreeNode pre = null; //ָ��ǰһ�������ʵĽڵ�
    	while(curr!=null||!stack.isEmpty()){
    		while(curr!=null){
    			stack.push(curr);
    			curr = curr.left;
    		}
    		curr = stack.peek();
    		//�����ǰ�ڵ���ҽڵ��ѱ����ʻ���Ϊ�գ�����ʸýڵ�
    		if(curr.right==null || curr.right==pre){
    			solu.add(curr.val);
    			pre = curr;
    			stack.pop();
    			curr = null;
    		}else{ //���򣬷��ʸýڵ���Һ���
    			curr = curr.right;
    		}
    	}
    	return solu;    	
    }
    
    
    public static ArrayList<Integer> postorderTraversal2(TreeNode root) {
	    ArrayList<Integer> solu = new ArrayList<Integer>();
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode curr = root; //ָ��ǰҪ���ʵĽڵ�
	    TreeNode pre = null; //ָ��ǰһ�������ʵĽڵ�
	    while(curr!=null||!stack.isEmpty()){
	        if(curr!=null){
	            stack.push(curr);
	            curr = curr.left;
	        }else{
	        	curr = stack.peek();
	        	//�����ǰ�ڵ���ҽڵ���û�з��� �� ��Ϊ�գ����ҽڵ���뵽stack
		        if(curr.right!=null && curr.right!=pre){
		        	curr = curr.right;
		        }else{ //����˵���ýڵ�Ϊ���ұߣ����������ұ߾��ѷ��ʣ�Ӧ�÷��ʴ˽ڵ㡣
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
