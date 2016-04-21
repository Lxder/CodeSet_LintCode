package com.PerfectSquares;
public class Solution {
    /**
     * @param n a positive integer
     * @return an integer
     */
    public int numSquares(int n) {
        // Write your code here
    	int[] dp = new int[n+1];
    	//可以直接得到平方的数字
    	for(int i = 1 ; i*i <= n ; i ++){
    		dp[i*i] = 1;
    	}
    	
    	for(int i = 1 ; i <= n ; i ++){
    		for(int j = 1 ; i+ j * j <=n ; j ++){
    			if(dp[i+j*j] == 0 || dp[i+j*j]> dp[i]+1){
    				dp[i+j*j] = dp[i]+1;
    			}
    		}
    	}
    	return dp[n];
    }
	public static void main(String[] args){
		System.out.println(new Solution().numSquares(11));
	}
}