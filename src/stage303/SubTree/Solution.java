package stage303.SubTree;



public class Solution {	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(3);
		root.left = l1;
		root.right = r1;

		TreeNode root2 = new TreeNode(4);
		TreeNode l21 = new TreeNode(2);
		TreeNode r21 = new TreeNode(2);
		root2.left = l21; 
		root2.right = r21;
		Solution s = new Solution();
		boolean solu = s.isSubtree(null,root2);
		System.out.println(solu);
		//System.out.println(s.inorder(root,root2));
		

	}
	
	
    /**
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
    	if(T2==null) return true;
    	return findroot(T1,T2,T2.val);
    	
    }
    
    public boolean findroot(TreeNode t1,TreeNode t2,int val){
    	if(t1 == null) return false;
    	if(t1.val==val) {
    		//找到一个根
    		boolean broot = inorder(t1,t2);
    		if(broot==true) {
    			System.out.println("找到");
    			return true;
    		}
    		else {
        		boolean bright = findroot(t1.left,t2,val);
        		boolean bleft = findroot(t1.right,t2,val);
        		if(bright==true) return true;
        		if(bleft==true) return true;        		
        	}
		}
    	else {
    		boolean bright = findroot(t1.left,t2,val);
    		boolean bleft = findroot(t1.right,t2,val);
    		if(bright==true) return true;
    		if(bleft==true) return true;
    		
    	}
    	return false;
    }
    
    public boolean inorder(TreeNode t1, TreeNode t2){    	
    	if(t1==null&&t2==null) return true;
    	if(t1==null&&t2!=null||t2==null&&t1!=null||t1.val!=t2.val) return false;
    	System.out.println(t1.val+" "+t2.val);
    	boolean bleft = inorder(t1.left,t2.left);
    	
    	boolean bright = inorder(t1.right,t2.right);
    	if(bleft==false||bright==false) return false;
    	return true;
    	
    }
}
