package com.LongestSubstringWithoutTepeatingCharacters;

import java.util.HashSet;

public class Solution {
	public static void main(String args[]){
		System.out.println(new Solution().lengthOfLongestSubstring("ccccccabcabcbb"));
	}
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
    	HashSet<Character> set = new HashSet<Character>();
    	int len = s.length();
    	int maxlen = 0;
    	int st = 0;    	
    	int ed = 0;
    	for( ; ed < len ; ed++){
    		char c = s.charAt(ed);
    		if(!set.contains(c)){
    			set.add(c);
    		}else{
    			maxlen = Math.max(maxlen, ed-st);
    			while(c!=s.charAt(st)){
    				set.remove(s.charAt(st));
    				st++;
    			}
    			st++;
    		}
    	}
    	
    	maxlen = Math.max(maxlen, ed-st);
    	return maxlen;
    	
    }
}