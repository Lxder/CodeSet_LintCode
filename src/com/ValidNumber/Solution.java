package com.ValidNumber;
public class Solution {
	public static void main(String args[]){
		String s = "  ";
		System.out.println(new Solution().isNumber(s));
	}
    /**
     * @param s the string that represents a number
     * @return whether the string is a valid number
     */
    public boolean isNumber(String s) {
        // Write your code here
    	s = s.trim();
    	
    	String[] nums = s.split("e");
    	if(nums.length!=1 && nums.length!=2) return false;
    	boolean flag = true;
    	for(int i = 0 ; i < nums.length ; i++){
    		System.out.println(nums[i]);
    		if(helper(nums[i])==false)
    			flag = false;
    	}
    	return flag;
    }
    public boolean helper(String s){
    	if(s.equals("")) return false;
    	int len = s.length();
    	int pnum = 0;
    	//int ploc = 0;
    	int st = 0;
    	if(s.charAt(0)=='-'||s.charAt(0)=='+'){
    		st++;    		
    	}
    	if(s.charAt(st)=='.'&&st==len-1) return false; 
    	for(int i = st ; i < len ; i++){
    		char c = s.charAt(i);
    		if(c=='.'){
    			if(pnum == 0) {
    				pnum++; //只能有1个小数点
    				//ploc = i; //记录小数点的位置
    			}
    			else return false;
    		}else if(c>'9'||c<'0'){
    			return false;
    		}
    	}
    	//if(pnum==1 && ploc==len-1) return false;
    	return true;
    }
}