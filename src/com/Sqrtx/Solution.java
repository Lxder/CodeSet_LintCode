package com.Sqrtx;
class Solution {
	public static void main(String[] args){
		System.out.println(new Solution().sqrt(2147483647));
	}
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
    	long low = 0;
    	long high = x/2+1;
    	long mid = low + high;
    	while(low<=high){
    		mid = (low+high)/2;
    		System.out.println(mid);
    		if(mid*mid == x) return (int)mid;
    		else if(mid*mid <x){
    			low = mid +1;
    		}else{
    			high = mid -1;
    		}
    	}
    	return (int)low-1;
    }
}