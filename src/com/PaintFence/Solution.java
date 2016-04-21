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
    	//N����������  k������ɫ����
    	if(n == 0 ) return 0;
    	if(n == 1 ) return k;
    	if(n == 2 ) return k*k;
    	
    	int g = 1; 	//���������з��������
    	int b = (k-g);	//���������з��������
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