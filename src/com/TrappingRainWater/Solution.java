package com.TrappingRainWater;
public class Solution {
	public static void main(String args[]){
		int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new Solution().trapRainWater2(heights));
	}
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
	//时间 空间复杂度均为O(n)
    public int trapRainWater(int[] heights) {
        // write your code here
    	int len = heights.length;
    	int[] dpl = new int[len];
    	int[] dpr = new int[len];
    	for(int i = 1 ;i < len ;i++){
    		dpl[i] = Math.max(dpl[i-1], heights[i-1]);
    	}
    	for(int i= len-2 ; i>=0 ; i--){
    		dpr[i] = Math.max(dpr[i+1], heights[i+1]);
    	}
    	int solu = 0;
    	for(int i = 0 ; i < len ;i++){
    		solu+= Math.max(0, Math.min(dpl[i], dpr[i]) - heights[i]);
    	}
    	return solu;
    }
    
    //方法2 时间复杂度O(n) 空间复杂度O(1)
    public int trapRainWater2(int[] heights){
    	int len = heights.length;
    	if(len <= 2) return 0;
    	int mindex = 0;
    	for(int i = 1 ; i < len ; i++){
    		if(heights[i] > heights[mindex])
    			mindex = i;
    	}
    	int solu = 0;
    	int maxlh = heights[0];
    	int maxrh = heights[len-1];
    	for(int i = 1 ;i < mindex ; i++){    		
    		solu += Math.max(0, maxlh - heights[i]);
    		if(maxlh < heights[i]){
    			maxlh = heights[i];
    		}
    	}
    	
    	for(int i = len-2 ; i > mindex ; i-- ){
    		solu += Math.max(0, maxrh - heights[i]);
    		if(maxrh < heights[i]){
    			maxrh = heights[i];
    		}
    	}
    	return solu;
    }
}