package com.MinimumSizeSubarraySum;
public class Solution {
	public static void main(String args[]){
		int[] nums = {2,3,1,2,4,3};
		System.out.println(new Solution().minimumSize(nums, 117));
	}
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
    	int len = nums.length;
    	if(len == 0) return -1;
    	int slen = Integer.MAX_VALUE;
    	int cursum = nums[0];
    	int curlen = 1;
    	int st = 0 ;
    	int ed = 0 ;
    	while(st<=ed && ed<len){
    		if(cursum < 0){
    			ed ++ ;
    			st = ed;
    			cursum = nums[st];
    		}else if(cursum < s){
    			ed ++;
    			if(ed<len)
    				cursum+=nums[ed];
    		}else {
    			curlen = ed-st+1;
    			if(curlen < slen){
    				slen = curlen;
    			}
    			cursum-=nums[st];
    			st++;
    		}
    	}
    	if(slen == Integer.MAX_VALUE) return -1;
    	return slen;
    }
}