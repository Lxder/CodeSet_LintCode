package stage207.ConstructBinarytreefromPrerderandInorderTraversal;



public class Solution {
	
	public static void main(String args[]){
		int[] preorder = {1,2,3};
		int[] inorder  = {2,1,3};
		TreeNode t =buildTree(preorder,inorder);
		System.out.println(t.val);
		System.out.println(t.left.val);
		System.out.println(t.right.val);
	}
    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
    	int len = preorder.length;
    	return helper(preorder,inorder,0,len-1,0,len-1);
    	
    	
    }
    
    public static TreeNode helper(int[] preorder, int[] inorder,
    		int prest, int preed,int inst,int ined){
    	if(prest>preed||inst>ined) return null;
    	int rootval = preorder[prest]; //根的数值
    	TreeNode root = new TreeNode(rootval);
    	
    	int rloc = 0;
    	for(int i = inst ; i <= ined ; i++){//在中序序列中找先序第一个（作为左右子树的划分）
    		if(inorder[i]==rootval){
    			rloc = i; //找到了根的位置
    			break;
    		}
    	} 
   
    	root.left = helper(preorder,inorder,prest+1,prest+rloc-inst,inst,rloc-1);
    	root.right = helper(preorder,inorder,prest+rloc-inst+1,preed,rloc+1,ined);
    	
    	
    	return root;
    }
}
