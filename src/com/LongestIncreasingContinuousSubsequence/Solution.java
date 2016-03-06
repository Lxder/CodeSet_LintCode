package com.LongestIncreasingContinuousSubsequence;
public class Solution {
	public static void main(String args[]){
		int[] A = {};
		//int[] A = {5,4,2,1,3};
		System.out.println(new Solution().longestIncreasingContinuousSubsequence(A));
	}
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
    	if(A.length ==0) return 0;
    	int maxlen = 1;
    	int len1 = 1;
    	int len2 = 1;
    	for(int i = 1 ; i <A.length ; i++){
    		if(A[i-1]<A[i]){
    			len1++;
    			if(maxlen < len2) maxlen = len2;
    			len2 = 1;
    		}else{
    			len2++;
    			if(maxlen < len1) maxlen = len1;
    			len1 = 1;
    		}
    	}
    	if(maxlen<len1) maxlen = len1;
    	if(maxlen < len2 ) maxlen = len2;
    	
    	
    	return maxlen;
    			
    }
}