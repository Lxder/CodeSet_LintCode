package com.RestoreIpAddresses;

import java.util.ArrayList;

public class Solution {
	public static void main(String args[]){
		Solution s = new Solution();
		System.out.println(s.restoreIpAddresses("010010"));
//		System.out.println("asdf".substring(0,1));
//		System.out.println("asdf".substring(1));
	}
    /**
     * @param s the IP string
     * @return All possible valid IP addresses
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        // Write your code here
    	ArrayList<String> solu = new ArrayList<String>();
    	helper(solu,new StringBuffer(), s , 0);
    	return solu;
    }
    
    public void helper(ArrayList<String> solu ,StringBuffer currsb , String left ,int num){
    	if(num == 4){
    		if(left.equals("")){
    			solu.add(new String(currsb).substring(0,currsb.length()-1));
    		}
    		return ;
    	}
    	for(int i = 1 ; i <= 3 && i <=left.length() ; i++){
    		String cstr = left.substring(0,i);
    		int tempn = Integer.valueOf(cstr);
    		if(!String.valueOf(tempn).equals(cstr)) continue;
    		if(tempn <256){
    			StringBuffer tsb = new StringBuffer(currsb);
    			tsb.append(tempn+".");
    			helper(solu,new StringBuffer(tsb),left.substring(i),num+1);
    		}
    			
    	}
    }
}