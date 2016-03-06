package com.HappyNumber;

import java.util.HashSet;

public class Solution {
    public static void main(String args[]){
    	Solution s = new Solution();
    	s.isHappy(19);
    }
	/**
     * @param n an integer
     * @return true if this is a happy number or false
     */
	
    public boolean isHappy(int n) {
        // Write your code here
        int temp = n ;
        HashSet<Integer> set = new HashSet<Integer>();
        	while(temp!=1){
            int curr = temp;
            int sum = 0 ;
            while(curr!=0){
                int t = curr%10;
                sum = sum + t*t;
                curr = curr/10;
            }
            temp = sum;
            if(set.contains(temp))return false;
            set.add(sum);
        }
        return true;
    }
}