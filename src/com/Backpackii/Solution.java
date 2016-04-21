package com.Backpackii;
public class Solution {
	public static void main(String[] args){
		
		int m = 200;
		int[] A = {79,58,86,11,28,62,15,68};
		int[] V = {83,14,54,79,72,52,48,62};
		System.out.println(new Solution().backPackII(m, A, V));
	}
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        int len = A.length;
        int[][] dp = new int[len][m+1];
        for(int j = 1 ; j <=m ;j  ++){
        	if(A[0]<=j)
        		dp[0][j] = V[0];
        }
        for(int i = 1 ; i < len ; i ++){
        	for(int j = 1 ; j <= m ; j ++){
        		if(j-A[i]>=0){
        			dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-A[i]]+V[i]);
        		}else{
        			dp[i][j] = dp[i-1][j];
        		}
        	}
        }
        return dp[len-1][m];
        
    }
}