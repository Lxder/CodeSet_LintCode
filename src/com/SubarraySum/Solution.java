package com.SubarraySum;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	public static void main(String args[]){
		int[] nums = {-3,1,2,-3,4};
		System.out.println(new Solution().subarraySum(nums));
	}
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
    	ArrayList<Integer> solu = new ArrayList<Integer>();
    	int len = nums.length;
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    	int[] sum = new int[len+1];
    	
    	map.put(0, -1);
    	for(int i = 0 ;i < len ;i++){
    		sum[i+1] = sum[i] + nums[i];
    		map.put(sum[i+1],i);
    	}
    	
    	for(int i = -1 ; i < len ;i++){
    		if(map.get(sum[i+1])!=i){
    			solu.add(i+1);
    			solu.add(map.get(sum[i+1]));
    			return solu;
    		}
    	}
    	return solu;
    	
    	
    	
    }
}