package stage808.DataStreamMedian;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static void main(String args[]){
		int[] arrs = {2,20,13,18,15,8,3,5,4,25};
		int[] solu = medianII(arrs);
		for(int i = 0 ;i<solu.length ;i ++){
			System.out.print(solu[i]+" ");
		}
	}
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public static int[] medianII(int[] nums) {
        // write your code here
    	List<Integer> list = new ArrayList<Integer>();
    	List<Integer> solu = new ArrayList<Integer>();
    	
    	int len = nums.length;
    	if(len == 0) return new int[0];
    	list.add(nums[0]);
    	solu.add(nums[0]);
    	int start;
    	int end;
    	
    	for(int i = 1 ; i < len ; i++){
    		start = 0;
    		end = list.size()-1;
    		while(start <= end){
    			int mid = (start + end)/2;
    			
    			if(nums[i]>=list.get(mid)){
    				start = mid +1;
    			}else{
    				end = mid - 1;
    			}    			
    		}    		
    		list.add(start, nums[i]);
    		int currlen = list.size();
    		if(currlen%2==1)
    			solu.add(list.get(currlen/2));
    		else solu.add(list.get(currlen/2-1));
    		
    	}
    	int[] arr = new int[solu.size()];
    	for(int i =0  ; i < solu.size() ;i++){
    		arr[i] = solu.get(i);
    	}
    	return arr;
    	
    	
    }
}
