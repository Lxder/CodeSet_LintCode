package com.ValidPalindrome;
public class Solution {
	public static void main(String args[]){
		System.out.println(isPalindrome("race a car"));
	}
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public static boolean isPalindrome(String s) {
        // Write your code here
        String str = s.toLowerCase();
        int len = str.length();
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < len ; i++){
        	char c  =str.charAt(i);
        	if(c>='a'&&c<='z' || c>='0'&&c<='9')
        		sb.append(str.charAt(i));
        }
        
        str = sb.toString();
        len = str.length();
        int st = 0 , ed = len-1;
        while(st<=ed){
        	if(str.charAt(st)!=str.charAt(ed)){
        		break;
        	}else{
        		st++;
        		ed--;
        	}
        }
        
        if(st>=ed) return true;
        return false;
    }
}
