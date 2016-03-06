package com.BestTimetoBuyandSellStockii;
class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
    	int sum = 0;
    	int len = prices.length;
    	for(int i = 1 ; i<len ; i++){
    		if(prices[i]-prices[i-1]>0)
    			sum+=prices[i]-prices[i-1];
    	}
    	return sum;
    }
};