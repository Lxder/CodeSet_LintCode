package com.PowxN;
public class Solution {
	
	public static void main(String args[]){
		System.out.println(new Solution().myPow(34.00515, -3));
	}
    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public double myPow(double x, int n) {
        // Write your code here
    	if(n < 0)
    		return 1.0/helper(x,-n);
    	else return helper(x,n);
    	
    }
    public double helper(double x , int n){
    	if(n==0) return 1;
    	double temp = myPow(x,n/2);
    	if(n%2 == 0) return temp*temp;
    	else return temp*temp*x;
    }
}