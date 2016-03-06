package com.HouseRobber;
public class Solution {
	public static void main(String args[]){
		int[] A = {2,4,6,8,10};
		System.out.println(new Solution().houseRobber(A));
	}
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
    	
    	int len = A.length;
    	if(len == 0)return 0;
    	if(len == 1) return A[0];
    	long[] dp = new long[len];
    	dp[len-1] = A[len-1];
    	dp[len-2] = Math.max(A[len-1], A[len-2]);
    	for(int i = len -3 ; i >=0 ; i--){
    		dp[i] = Math.max(dp[i+1], dp[i+2]+A[i]);
    	}
    	return dp[0];
    }
}