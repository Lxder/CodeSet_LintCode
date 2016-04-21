package com.LongestConsecutiveSequence;

import java.util.HashMap;
import java.util.Map.Entry;

public class Solution {
	public static void main(String[] args){
		int[] num = {1,2,0,1};
		System.out.println(new Solution().longestConsecutive(num));
		
	}
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
    	int maxlen = 0;
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    	for(int i = 0 ; i < num.length; i ++){
    		map.put(num[i], 1);
    	}
    	for(int i = 0 ; i < num.length ; i ++){
    		if(map.get(num[i]) == 0){
    			continue;
    		}else{
    			int st = num[i]+1;
    			int currlen = 1;
    			while(map.containsKey(st)){
    				currlen++;
    				map.put(st, 0);
    				st++;
    			}
    			st = num[i]-1;
    			while(map.containsKey(st)){
    				currlen++;
    				map.put(st, 0);
    				st--;    				
    			}
    			if(currlen > maxlen) maxlen = currlen;
    		}
    	}
    	
    	return maxlen;
    	
    	
    }
}