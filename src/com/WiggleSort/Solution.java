package com.WiggleSort;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args){
		int[] nums = {3,5,2,1,6,4};
		new Solution().wiggleSort(nums);
		for(int i :nums){
			System.out.println(i);
		}
	}
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 1 ; i < len-1 ; i+=2){
        	int temp = nums[i];
        	nums[i] = nums[i+1];
        	nums[i+1] = temp;
        }
    }
}