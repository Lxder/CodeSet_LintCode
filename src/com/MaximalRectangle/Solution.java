package com.MaximalRectangle;

import java.util.Stack;

public class Solution {
	
	public static void main(String[] args){
//		int[][] rect = {
//				{1, 1, 0, 0, 1},
//				{0, 1, 0, 0, 1},
//				{0, 0, 1, 1, 1},
//				{0, 0, 1, 1, 1},
//				{0, 0, 0, 0, 1}	
//		};
		int[][] rect = {
				{1},
				{0},
				{1},
				{1},
				{0}	
		};
		boolean[][] b = new boolean[rect.length][rect[0].length];
		for(int i = 0 ; i < b.length ; i ++){
			for(int j = 0 ; j < b[0].length ; j ++){
				if(rect[i][j] == 1){
					b[i][j] = true;
				}
			}
		}
		System.out.println(new Solution().maximalRectangle(b));
	}
	
    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        // Write your code here
    	int row = matrix.length;
    	if(row == 0 ) return 0;
    	int col  = matrix[0].length;
    	int[][] dp = new int[row][col];
    	for(int j = 0 ;j< col ;j ++){
    		if(matrix[0][j]==true){
    			dp[0][j] = 1;
    		}
    	}
    	for(int i = 1 ; i < row ;i ++){
    		for(int j = 0 ; j < col ; j++){
    			if(matrix[i][j] == true)
    				dp[i][j] = dp[i-1][j]+1;
    		}
    	}
    	int[] maxsize = new int[row]; //每行有一个最大size
    	
    	for(int i = 0 ; i < row ; i ++){
    		Stack<Integer> stk = new Stack<Integer>();
    		stk.add(dp[i][0]);
    		for(int j = 1 ; j < col ; j ++){
    			if(dp[i][j] >= stk.peek()){
    				stk.add(dp[i][j]);
    			}else{
    				int num = 1;
    				int currmax = 0;
    				while(!stk.isEmpty()&&dp[i][j]<stk.peek()){
    					currmax = Math.max(currmax, stk.pop()*num);
    					num++;
    				}
    				for(int k = 0 ; k < num ; k ++){
    					stk.push(dp[i][j]); //用当前的元素进行补充，保证栈是升序的
    				}    				
    				maxsize[i] = Math.max(maxsize[i], currmax);
    				//System.out.println(currmax);
    			}
    		}
    		//System.out.println(stk);
    		int num = 1;
    		while(!stk.isEmpty()){
    			maxsize[i] = Math.max(maxsize[i], stk.pop()*num);
    			num++;
    		}
    	}
    	int solu = 0;
    	for(int i = 0 ; i < maxsize.length ; i ++){
    		solu = Math.max(solu, maxsize[i]);
    	}
    	return solu;
    }
}