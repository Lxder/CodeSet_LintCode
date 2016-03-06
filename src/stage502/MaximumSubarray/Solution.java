package stage502.MaximumSubarray;

import java.util.ArrayList;

public class Solution {
	
	public static void main(String args[]){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(-2);
		nums.add(2);
		nums.add(-2);
		nums.add(4);
		nums.add(-1);
		nums.add(2);
		nums.add(1);
		nums.add(-5);
		nums.add(3);
		System.out.println(maxSubArray(nums));
	}
	
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public static int maxSubArray(ArrayList<Integer> nums) {
        // write your code
    	int len = nums.size();
    	if(len ==0 ) return 0;
    	int sum = 0 ;
    	int msum = 0 ;
    	
    	for(int i = 0 ; i < len ; i++){
    		sum = sum+nums.get(i);
    		if(sum>msum){
    			msum = sum;
    		}
    		if(sum<0){
    			sum=0;
    		}
    	}
    	if(msum==0){//全为负数，找到最大的负数，返回之
    		msum = nums.get(0);
    		for(int i = 1 ; i < len ; i++){
    			if(msum<nums.get(i))
    				msum = nums.get(i);
    		}
    	}
    		
    	return msum;
    }
}
