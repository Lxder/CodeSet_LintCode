package com.MinimumSubarray;

import java.util.ArrayList;

public class Solution {
	public static void main(String args[]){
		int[] numarr = {1,2,3,4,5};
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(Integer i :numarr){
			nums.add(i);
		}
		Solution s = new Solution();
		System.out.println(s.minSubArray(nums));
		
	}
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
    	int sum = 0;
    	int numsmin = Integer.MAX_VALUE;
    	int currsum = 0;
    	for(Integer curr : nums){
    		if(curr < numsmin)
    			numsmin = curr;
    		currsum += curr;
    		if(currsum > 0){
    			currsum = 0;
    		}
    		if(currsum < sum ) sum = currsum;
    	}
    	if(numsmin > 0) return numsmin;
    	return sum;
    }
}
