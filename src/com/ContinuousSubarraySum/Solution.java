package com.ContinuousSubarraySum;

import java.util.ArrayList;

public class Solution {
	public static void main(String args[]){
		int[] A = {-3,-1,-3,-3,-4};
		System.out.println(new Solution().continuousSubarraySum(A));
	}
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
    	int len = A.length;
    	int maxsum = Integer.MIN_VALUE;
    	int st = 0 , ed = 0;
    	int sum = 0;
    	int currst = 0 , curred = 0;
    	for(int i = 0 ; i < len ; i ++ ){
    		sum+=A[i];
    		curred = i;
    		if(sum>maxsum){
    			maxsum = sum;
    			st = currst;
    			ed = curred;
    		}
    		if(sum<0){
    			sum = 0;
    			currst = i+1;
    			curred = i+1;
    		}
    	}
    	ArrayList<Integer> solu = new ArrayList<Integer>();
    	solu.add(st);
    	solu.add(ed);
    	return solu;
    	
    	
    }
}