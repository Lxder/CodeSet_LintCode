package com.GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String args[]){
		Solution s = new Solution();
		System.out.println(s.generateParenthesis(0));
	}
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
        // Write your code here
    	ArrayList<String> solu = new ArrayList<String>();
    	helper(solu,new StringBuffer(),n,n);
    	return solu;
    	
    }
    public void helper(List<String> solu , StringBuffer csb ,int lnum , int rnum){
    	if(lnum ==  0 && rnum ==0){
    		solu.add(csb.toString());
    		return ;
    	}
    	
    	if(lnum!=0){
    		StringBuffer tempsb = new StringBuffer(csb);
    		tempsb.append("(");
    		helper(solu,tempsb,lnum-1,rnum);
    	}
    	if(rnum>lnum){
    		StringBuffer tempsb = new StringBuffer(csb);
    		tempsb.append(")");
    		helper(solu,tempsb,lnum,rnum-1);
    	}
    	
    	
    	
    }
}