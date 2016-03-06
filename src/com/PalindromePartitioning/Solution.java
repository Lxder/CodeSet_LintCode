package com.PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
    	List<List<String>> solu = new ArrayList<List<String>>();
    	if(s.length()==0) 
    		return solu;
    	helper(solu,new ArrayList<String>(),s);
    	return solu;
    }
    
    public void helper(List<List<String>> solu, List<String> currsolu , String s){
    	if(s.length() == 0){
    		solu.add(new ArrayList<String>(currsolu));
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
