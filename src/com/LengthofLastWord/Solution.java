package com.LengthofLastWord;
public class Solution {
	
	public static void main(String args[]){
		String str = "   ";
		Solution s = new Solution();
		System.out.println(s.lengthOfLastWord(str));
	}
	
    /**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
        // Write your code here
    	String[] sarr = s.split("\\s+");
    	if(sarr.length ==0 ) return 0;
    	else return sarr[sarr.length-1].length();
    }
}