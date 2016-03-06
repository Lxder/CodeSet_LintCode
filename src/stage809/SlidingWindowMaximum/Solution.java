package stage809.SlidingWindowMaximum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static void main(String args[]){
		int[] nums = {1,2,7,7,2,10,3,4,5};
		System.out.println(maxSlidingWindow(nums,2));
	}
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
	
	//方法1 时间复杂度未必O(n)
    public static ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
    	
    	List<Integer> window = new ArrayList<Integer>();
    	ArrayList<Integer> solu = new ArrayList<Integer>();
    	if(nums.length==0) return solu;
    	
    	int currmax = Integer.MIN_VALUE;
    	
    	for(int i = 0 ; i < k && i < nums.length  ;i++){
    		currmax = Math.max(currmax, nums[i]);
    		window.add(nums[i]);
    	}
    	
    	solu.add(currmax);
    	
    	for(int i = k ; i < nums.length ; i++){
    		int head = window.remove(0);
			window.add(nums[i]);
			if(currmax != head){    			
				if(currmax<nums[i]){
					currmax = nums[i];
				}
				solu.add(currmax);

			}else{
    			
    			    			
    			currmax = Integer.MIN_VALUE;    			
    			for(int temp :window){
    				if(temp>currmax) currmax = temp;
    			}
    			solu.add(currmax);
    		}
    	}
    	return solu;
    	
    }
}

