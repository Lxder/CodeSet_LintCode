package com.PlusOne;

import java.util.ArrayList;

public class Solution {
	public static void main(String args[]){
		int[] digits = {1,2,3};
		int[] solu = new Solution().plusOne(digits);
		for(int i : solu){
			System.out.print(i);
		}
	}
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        // Write your code here
    	ArrayList<Integer> solulist = new ArrayList<Integer>();
    	int len = digits.length;
    	int t = 1; //½øÎ»
    	int sum = 0;
    	for(int i = len-1 ; i >=0 ; i--){
    		sum = digits[i]+t;
    		solulist.add(sum%10);
    		t = sum/10;
    	}
    	if(t!=0){
    		solulist.add(t);
    	}
    	int lenlist = solulist.size();
    	
    	int[] solu = new int[lenlist];
    	for(int i = 0 ; i < lenlist ; i++){
    		solu[i] = solulist.get(lenlist-i-1);
    	}
    	return solu;
    }
}