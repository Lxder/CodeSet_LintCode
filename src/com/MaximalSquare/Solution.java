package com.MaximalSquare;

import java.util.Stack;

public class Solution {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix2 = 	{{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
		System.out.println(new Solution().maxSquare(matrix2));
	}
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
    	int row = matrix.length;
		if(row==0) return 0;
		int col = matrix[0].length;
		if(col==0) return 0;
		
		int solu = 0;
				
		int[][] totalnum = new int[row][col];
		
		for(int i = 0 ; i < col ; i++){
			totalnum[0][i] = matrix[0][i]; //ASCII�����ֵ�ת��			
		}
		
		for(int i = 1 ; i < row ; i++){
			for(int j = 0 ; j < col ; j++){
				if(matrix[i][j]==1)
					totalnum[i][j] = totalnum[i-1][j]+1;
				else totalnum[i][j] = 0;
			}
		}
		
		for (int i = 0; i < row; i++) {
			int curr = 0;
			Stack<Integer> stack = new Stack<Integer>();
			for (int j = 0; j < col; j++) {
				if (stack.isEmpty() || stack.peek() < totalnum[i][j]) {
					stack.push(totalnum[i][j]);
				} else { // �����б�height[i]��ĵĶ���ջ����height[i]����
					int count = 0; // ��¼��ջ����
					while ((!stack.isEmpty()) && stack.peek() > totalnum[i][j]) {
						count++;						
						int minlen = Math.min(count, stack.peek());
						curr = Math.max(curr, minlen*minlen);
						stack.pop();
					}
					
					while (count != 0) {
						count--;
						stack.push(totalnum[i][j]); // ��height[i]�����ջ��Ԫ��
					}
					stack.push(totalnum[i][j]);// ����ǰ��Ԫ����ӽ�ȥ
				}
			}

			// �������һ��Ԫ��
			int count = 0;
			int minlen = 0;
			while (!stack.isEmpty()) {
				count++;
				minlen = Math.min(count, stack.pop());
				curr = Math.max(curr, minlen*minlen);
			}
			if (curr > solu)
				solu = curr;
		}		
		return solu;
    	
    }
}