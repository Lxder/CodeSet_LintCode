package com.PaintHouseII;
public class Solution {
	public static void main(String[] args){
		int[][] costs = {{14,2,11},{11,14,5},{14,3,10}};
		System.out.println(new Solution().minCostII(costs));
		
	}
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        // Write your code here
    	int row = costs.length;
    	if(row ==0) return 0;
    	int col = costs[0].length;
    	int[][] dp = new int[row][col];
    	for(int i = 0 ; i < col ; i ++){
    		dp[0][i] = costs[0][i];
    	}
    	
    	for(int i = 1 ; i < row ; i ++){
    		for(int j = 0; j < col ; j++){
    			dp[i][j] = Integer.MAX_VALUE;
    			for(int k = 0 ; k < col ; k ++){
    				if(k==j) continue;
    				dp[i][j] = Math.min(dp[i][j], dp[i-1][k]);
    			}
    			dp[i][j] += costs[i][j];
    		}
    	}
    	int solu = Integer.MAX_VALUE;
    	for(int i = 0 ; i < col ; i ++){
    		solu = Math.min(solu, dp[row-1][i]);
    	}
    	return solu;
    	
    	
    }
}