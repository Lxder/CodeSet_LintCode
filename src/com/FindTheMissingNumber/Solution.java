package com.FindTheMissingNumber;
public class Solution {
	public static void main(String args[]){
		int nums[] = {4,5,0,1,3};
		System.out.println(new Solution().findMissing(nums));
	}
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
    	int len = nums.length;
    	for(int i = 0 ; i < len ; i ++ ){    		
    		while(nums[i] != i){
    			if(nums[i] == len){    				
    				break;
    			}
    			int temp = nums[nums[i]];
    			nums[nums[i]] = nums[i];
    			nums[i] =  temp;
    		}
    	}
    	for(int i = 0 ; i < len ; i++){
    		if(nums[i]!=i)
    			return i;
    	}
    	return len;
    }
}