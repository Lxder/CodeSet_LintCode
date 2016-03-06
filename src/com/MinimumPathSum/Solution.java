package com.MinimumPathSum;
public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
    	int row = grid.length;
    	if(row==0) return 0;
    	int col = grid[0].length;
    	
    	int[][] dp = new int[row][col];
    	dp[0][0] = grid[0][0];
    	for(int i = 1 ; i < row ; i++){
    		dp[i][0] = dp[i-1][0] + grid[i][0];
    	}
    	for(int j = 1 ; j < col ; j++){
    		dp[0][j] = dp[0][j-1] + grid[0][j]; 
    	}
    	
    	for(int i = 1 ; i < row ; i++){
    		for(int j = 1 ; j < col ;j++){
    			dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
    		}
    	}
    	return dp[row-1][col-1];
    	
    }
}
