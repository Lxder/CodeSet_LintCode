package stage812.SlidingWindowMedian;

import java.util.ArrayList;

public class Solution {
	public static void main(String args[]){
		int[] nums = {1,5,2,4,3};
		System.out.println(medianSlidingWindow(nums,3));
		
	}
	/**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public static ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
    	int len = nums.length;
    	ArrayList<Integer> solu = new ArrayList<Integer>();
    	if(len==0 || k<1) return solu; 
    		
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	list.add(nums[0]);
    	int start = 0;
    	int end = 0;
    	int mid;
    	for(int i = 1 ; i < k ; i++){
    		start = 0 ;
    		end = i - 1;
    		while(start <= end){
    			mid = (start + end)/2;
    			if(nums[i]>=list.get(mid)){
    				start = mid+1;
    			}else{
    				end = mid - 1;
    			}
    		}
    		list.add(start,nums[i]);
    	}
    	solu.add(list.get((k-1)/2));
    	for(int i = k ;i< len ;i++){
    		start = 0;
    		end = k-1;
    		while(start<=end){
    			mid = (start +end)/2;
    			if(nums[i]>=list.get(mid)){
    				start = mid+1;
    			}else{
    				end = mid - 1;
    			}
    		}
    		list.add(start,nums[i]);
    		for(int j = i ; j < i+k ; j++){
    			if(nums[i-k]==list.get(j-i)){
    				list.remove(j-i);
    				break;
    			}
    		}
    		solu.add(list.get((k-1)/2));
    	}
    	return solu;
    }
}

