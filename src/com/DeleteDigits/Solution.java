package com.DeleteDigits;

import java.util.LinkedList;

public class Solution {
	public static void main(String[] args){
		System.out.println(new Solution().DeleteDigits("900", 2));
	}
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        int len = A.length();
        LinkedList<Character> list = new LinkedList<Character>();
        for(int i = 0 ;i<len; i++){
        	list.add(A.charAt(i));
        }
        
        for(int i = 0 ; i < k ; i ++){
        	int curlen = list.size();
            for(int j = 1 ; j < curlen ; j ++){
            	if(list.get(j-1)>list.get(j)){            		
            		list.remove(j-1);
            		break;
            	}
            }
            if(list.size() == curlen){
            	list.remove(curlen-1);
            }

        }
        StringBuffer sb = new StringBuffer();
        len = list.size();
        int st = 0;
        for( ; st < len ; st++){        	
        	if(list.get(st)!='0') break;
        }
        if(st == len) return "0";
        for(int i = st ; i < len ;i ++){
        	sb.append(list.get(i));
        }
        
        return sb.toString();
    }
}