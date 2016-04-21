package com.PaintFence;
public class Solution {
	public static void main(String[] args){
		System.out.println(new Solution().numWays(5, 3));
	}
    /**
     * @param n non-negative integer, n posts
     * @param k non-negative integer, k colors
     * @return an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        // Write your code here
    	//N代表房子数量  k代表颜色数量
    	if(n == 0 ) return 0;
    	if(n == 1 ) return k;
    	if(n == 2 ) return k*k;
    	
    	int g = 1; 	//不能用所有分组的组数
    	int b = (k-g);	//可以用所有分组的组数
    	int solu = k;
    	
    	for(int i = 3 ; i <= n ; i ++){

    		solu =solu*k-g;    		
    		int temp  = b;
    		b = g * (k-1) + b * (k-1);
    		g = temp;
    	}
    	return solu*k;
    }
}