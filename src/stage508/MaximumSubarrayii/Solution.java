package stage508.MaximumSubarrayii;

import java.util.ArrayList;

public class Solution {
//相当于买股票问题(两次交易) 注意：与买股票问题不同的是这里面的元素可能为负
	
	public static void main(String args[]){
		int[] arr = {-1,-2,-3,-100,-1,-50};
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 0 ; i < arr.length ; i++){
			nums.add(arr[i]);
		}
		System.out.println(maxTwoSubArrays(nums));
	}
	
	/**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public static int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
    	int len = nums.size();
    	int[] lr = new int[len];
    	int[] rl = new int[len];
    	int maxsum = Integer.MIN_VALUE;
    	int currsum = 0;
    	for(int i = 0 ; i < len ;i++){
    		currsum = currsum + nums.get(i);
    		if(currsum>maxsum){
    			maxsum=currsum;    			
    		}
    		if(currsum<0){
    			lr[i]=maxsum;
    			currsum=0;    			
    		}else
    			lr[i] = maxsum;
    		System.out.print(lr[i]);
    	}
    	System.out.println();
    	maxsum = Integer.MIN_VALUE;
    	currsum = 0;
    	for(int i = len-1 ; i>=0 ; i--){
    		currsum = currsum + nums.get(i);
    		if(currsum>maxsum){
    			maxsum=currsum;    			
    		}
    		if(currsum<0){
    			rl[i]=maxsum;
    			currsum=0;    			
    		}else
    			rl[i] = maxsum;
    		System.out.print(rl[i]);
    	}
    	
    	maxsum = Integer.MIN_VALUE;
    	currsum  =0;
    	for(int i = 1 ; i < len ; i++){
    		currsum = lr[i-1]+rl[i];
    		if(maxsum<currsum) maxsum=currsum;
    	}
    	return maxsum;
    }
}


