package com.ReverseInteger;
public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        // Write your code here
    	boolean flag = false;
    	if(n<0){
    		flag = true;
    	}
    	long num = Math.abs(n);
    	StringBuffer sb = new StringBuffer(String.valueOf(num));
    	num = Long.valueOf(sb.reverse().toString());
    	if(flag == true){
    		num = -num;
    	}
    	if(num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) return 0;
    	return (int)num;
    	
    }
}