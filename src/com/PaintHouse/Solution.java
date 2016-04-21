package com.PaintHouse;
public class Solution {
	public static void main(String[] args){
		int[][] costs = {{14,2,11},{11,14,5},{14,3,10}};
		System.out.println(new Solution().minCost(costs));
		
	}
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // Write your code here
    	int row = costs.length;
    	if(row ==0) return 0;
    	int col =3 ;
    	int[][] dp = new int[row][col];
    	for(int i = 0 ; i < 3 ; i ++){
    		dp[0][i] = costs[0][i];
    	}
    	for(int i = 1 ; i < row ; i ++){
    		dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
    		dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
    		dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
    	}
    	return Math.min(Math.min(dp[row-1][0], dp[row-1][1]), dp[row-1][2]);
    	
    }
}