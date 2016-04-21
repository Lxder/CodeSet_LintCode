package com.LargestNumber;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args){
		
		int[] num = {8,1,20,24};
		System.out.println(new Solution().largestNumber(num));
		
	}
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
        // write your code here
    	int len = num.length;
    	int idx  = 0;
    	for(; idx < len ; idx ++){
    		if(num[idx]!=0) break;
    	}
    	if(idx == len)return "0";
    	Number[] num_str = new Number[len];
    	for(int i = 0 ; i < len ; i ++){
    		num_str[i] = new Number(num[i]);
    	}
    	Arrays.sort(num_str);
    	StringBuffer sb = new StringBuffer();
    	for(int i = len-1 ; i >=0 ; i --){
    		sb.append(num_str[i].n);
    	}
    	
    	
    	return sb.toString();
    }
}

class Number implements Comparable<Number>{
	String n;
	public Number(int n){
		this.n = String.valueOf(n);
	}
	@Override
	public int compareTo(Number other) {
		char[] c1 = n.toCharArray();
		char[] c2 = other.n.toCharArray();
		int len1 = c1.length;
		int len2 = c2.length;
		int idx = 0;
		
		while(idx < len1 && idx < len2){
			if(c1[idx] > c2[idx]){
				return 1;
			}else if(c1[idx] < c2[idx]){
				return -1;
			}
			idx++;
		}
		if(idx == len1 && idx == len2){ //比较到最后一位还相等
			return 0;
		}
		else if(idx == len1){ //c1 为c2的子串
			if(c2[idx]>c1[0]) return -1;
			return 1;
		}
		else { //c2为c1的子串
			if(c1[idx] > c2[0]) return  1;
			return -1;
		}
	}
}