package com.Candy;
public class Solution {
	public static void main(String args[]){
		int[] ratings = {4,2,3,4,1};
		System.out.println(new Solution().candy(ratings));
	}
    /**
     * @param ratings Children's ratings
     * @return the minimum candies you must give
     */
    public int candy(int[] ratings) {
        // Write your code here
    	int len = ratings.length;
    	int[] dp = new int[len];
    	for(int i = 1 ; i < len ; i++){
    		if(ratings[i]>ratings[i-1]){
    			dp[i] = dp[i-1]+1;
    		}   
    		
    	}
    	System.out.println();
    	for(int i = len-1 ; i>0 ; i--){
    		if(ratings[i-1]>ratings[i]){
    			dp[i-1] = Math.max(dp[i-1],dp[i]+1);
    		}
    	}
    	int solu = len;
    	
    	return solu;
    	
    }
}