package com.SortColors;

class Solution {
	/**
	 * @param nums
	 *            : nums list of integer which is 0, 1 or 2
	 * @return: nothing
	 */
	public void sortColors(int[] nums) {
		// write your code here

		int red,white,blue; //三个flag， blue跑的最快，white次之，red跑的最慢
	    red=0;white=0;blue=0;
	    for(int i=0;i<nums.length;i++){
	        int current=nums[i];
	        if (current<=2)
	            nums[blue++]=2;
	        if (current<=1)
	            nums[white++]=1;
	        if (current==0)
	            nums[red++]=0;
	    }
	}
}