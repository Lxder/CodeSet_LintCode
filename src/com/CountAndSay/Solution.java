package com.CountAndSay;
public class Solution {
	public static void main(String args[]){
		
		System.out.println(new Solution().countAndSay(5));
	}
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        // Write your code here
    	if(n==1) return "1";
    	String curr = "1";
    	
    	for(int i = 2 ;i <= n ; i++){
    		StringBuffer sb = new StringBuffer();
    		int len = curr.length();
    		char prec = curr.charAt(0);
    		int count = 0;
    		for(int j = 0 ; j < len ; j++){
    			if(curr.charAt(j) == prec){
    				count++;
    			}else{
    				sb.append(String.valueOf(count));
    				sb.append(prec);
    				prec = curr.charAt(j);    				
    				count = 1;
    			}
    		}
    		sb.append(String.valueOf(count));
    		sb.append(prec);
    		curr = sb.toString();
    	}
    	return curr;
    }
}