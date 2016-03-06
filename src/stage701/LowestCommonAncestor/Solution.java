package stage701.LowestCommonAncestor;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(2);
		TreeNode l2 = new TreeNode(1);
		TreeNode r1 = new TreeNode(5);
		TreeNode r2 = new TreeNode(6);
		TreeNode r3 = new TreeNode(7);
		root.left = l1;
		l1.right = l2;
		root.right = r1;
		r1.right = r2;
		r1.left = r3;
		
//		//Ѱ��·��
//		List<TreeNode> solu = findPath(root,r2);
//		System.out.println(solu);
		TreeNode solu = lowestCommonAncestor(root,r2,r3);
		System.out.println(solu.val);
	}
	
	
	
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null||root==p||root==q)
			return root;
		//Ѱ�ҵ����������·��
		List<TreeNode> pathp = findPath(root,p); 
		List<TreeNode> pathq = findPath(root,q);
		
		int len = Math.min(pathp.size(),pathq.size());
		int i =0;
		for( ; i < len ; i++){
			System.out.println(pathp.get(i).val);
			if(pathp.get(i)!=pathq.get(i))
				break;
		}
		return pathp.get(i-1);
	}

	//Ѱ�ҵ���ĳ���ڵ��·�� 
	//�����������������
	public static List<TreeNode> findPath(TreeNode root, TreeNode p) {
		List<TreeNode> ls = new ArrayList<TreeNode>();

		Stack<TreeNode> st = new Stack<TreeNode>();
		Stack<Boolean> flag = new Stack<Boolean>();
		st.push(root);
		flag.push(false);
		
		while (!st.isEmpty()) {			
			TreeNode temp = st.peek();
			ls.add(temp);
			if(temp==p){ //����Ѿ��ҵ��������
				break;
			}			
			if(flag.pop()==true){
				st.pop();
				ls.remove(ls.size()-1); //��Ϊ�������һ�飬����Ҫɾ������
				ls.remove(ls.size()-1);
				continue;				
			}
			else flag.push(true);
			
			if (temp.right != null){
				st.push(temp.right);
				flag.push(false);
			}
			if (temp.left != null){
				st.push(temp.left);
				flag.push(false);
			}
		}		
		return ls;
	}
	
	
	public static ArrayList<Integer> postorderTraversal(TreeNode root) {
	    ArrayList<Integer> solu = new ArrayList<Integer>();
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode curr = root; //ָ��ǰҪ���ʵĽڵ�
	    TreeNode pre = null; //ָ��ǰһ�������ʵĽڵ�
	    while(!stack.isEmpty()||curr!=null){
	    	while(curr!=null){
	    		stack.push(curr);
	    		curr = curr.left;
	    	}	    	
	    	curr = stack.peek();
	    	if(curr.right==null||curr.right == pre){//�Ҳ��Ѿ��������
	    		solu.add(curr.val);
	    		pre = curr;
	    		curr = stack.pop();	    		
	    	}
	    }
	    return solu;
	}
	
}
