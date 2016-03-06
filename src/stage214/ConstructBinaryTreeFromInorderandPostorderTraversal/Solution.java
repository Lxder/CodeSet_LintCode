package stage214.ConstructBinaryTreeFromInorderandPostorderTraversal;

import stage207.ConstructBinarytreefromPrerderandInorderTraversal.TreeNode;

public class Solution {
    /**
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
	
	public static void main(String args[]){
		int[] inorder = {2,1,3};
		int[] postorder  = {2,3,1};
		TreeNode t =buildTree(inorder,postorder);
		
		System.out.println(t.val);
		System.out.println(t.left.val);
		System.out.println(t.right.val);
	}
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
    	int len = inorder.length;    	
    	return helper(inorder,postorder,0,len-1,0,len-1);
    }
    
    public static TreeNode helper( int[] inorder,int[] postorder,
    		int inst,int ined,int postst, int posted){
    	if(postst>posted||inst>ined) return null;
    	int rootval = postorder[posted]; //������ֵ ����ǰ���һ����
    	TreeNode root = new TreeNode(rootval);
    	
    	int rloc = 0;
    	for(int i = inst ; i <= ined ; i++){//�������������Һ������һ������Ϊ���������Ļ��֣�
    		if(inorder[i]==rootval){
    			rloc = i; //�ҵ��˸���λ��
    			break;
    		}
    	} 
   
    	root.left = helper(inorder,postorder,inst,rloc-1,postst,postst+rloc-inst-1);
    	root.right = helper(inorder,postorder,rloc+1,ined,postst+rloc-inst,posted-1);
    	
    	
    	return root;
    }
}
