package com.PalindromePartitioningII;

import java.util.ArrayList;
import java.util.List;


//======================³¬Ê±£¡£¡£¡£¡
public class Solution {
	public static void main(String args[]){
		Solution s = new Solution();
		String str = "ababababababababababababcbabababababababababababa";
		System.out.println(s.minCut(str));
	}
	
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
	
	public int minCut(String s) {
        // write your code here
		List<Integer> solu = new ArrayList<Integer>();
    	if(s.length()==0) 
    		return 0;
    	helper(solu,new ArrayList<String>(),s);
    	int min = Integer.MAX_VALUE;
    	for(int i :solu){
    		if(i<min) min = i;
    	}
    	return min-1;
    	
    }
    
    public void helper(List<Integer> solu, List<String> currsolu , String s){
    	if(s.length() == 0){
    		solu.add(currsolu.size());
    		return;
    	}
    	
    	for(int i = 0 ; i < s.length() ; i++){
    		if(isPalin(s.substring(0,i+1))){
    			currsolu.add(s.substring(0,i+1));
    			helper(solu,currsolu,s.substring(i+1));
    			currsolu.remove(currsolu.size()-1);
    		}
    	}
    }
    public boolean isPalin(String s){
		int len = s.length();
		for(int i = 0 , end = s.length()/2; i < end ; i++){
			if(s.charAt(i)!=s.charAt(len-i-1)) return false;
		}
		return true;
	}
}
