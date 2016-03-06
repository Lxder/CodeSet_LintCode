package com.FlipBits;
class Solution {
	public static void main(String args[]){
		System.out.println(bitSwapRequired(1, -1));
	}
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
    	int c = a^b;
    	int num = 0;
    	
//方法1：
//    	int base = 1;
//    	for(int i = 0 ; i < 32 ; i ++){
//    		if((c&base) != 0) num++;
//    		base = base<<1;
//    	}
    	
//方法2：
    	while(c!=0){
    		c = c&(c-1);
    		num++;
    	}

    	return num;
    }
};
