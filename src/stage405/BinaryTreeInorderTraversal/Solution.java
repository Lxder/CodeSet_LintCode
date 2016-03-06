package stage405.BinaryTreeInorderTraversal;

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
		l1.left = l11;
		l1.right = l12;
		r1.right = r12;
		System.out.println(inorderTraversal(root));
	}

	/**
	 * @param root
	 *            : The root of binary tree.
	 * @return: Inorder in ArrayList which contains node values.
	 */

	public static ArrayList<Integer> inorderTraversal(TreeNode root) {
		
		ArrayList<Integer> solu = new ArrayList<Integer>();
		if(root == null) return solu;
		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode temp = root;

		while (temp != null || !stack.isEmpty()) {
			if (temp != null) { // ��������ջ
				stack.add(temp);
				temp = temp.left;
			} else {
				temp = stack.pop();
				solu.add(temp.val);
				temp = temp.right;
			}
		}
		return solu;

	}
}
