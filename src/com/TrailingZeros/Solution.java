package com.TrailingZeros;
class Solution {
	public static void main(String args[]){
		Solution s = new Solution();
		long l = 5555550000000L;
		System.out.println(s.trailingZeros(l));
		
	}
    public long trailingZeros(long n) {
    	long base = 5;
    	long num = 0;
    	
    	while(base <= n){
    		num+=n/base;
    		base*=5;
    	}
    	return num;
    }
    
};
