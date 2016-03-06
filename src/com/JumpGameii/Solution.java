package com.JumpGameii;
public class Solution {
	public static void main(String args[]){
		int[] A = {2,3,1,1,4};
		System.out.println(new Solution().jump(A));
	}
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
    	int len = A.length;
        int[] dp = new int[len];
        dp[len-1] = 0;
        for(int i = len-2 ; i >=0 ; i--){
        	dp[i] = len + 1;
        	int curr = A[i];
        	for(int j = i+1 ; j <= Math.min(i+curr, len-1) ; j++){
        		dp[i] = Math.min(dp[i],	dp[j]+1);
        		
        	}
        	System.out.println(dp[i]);
        }
        return dp[0];
    	
    	
    }
}
