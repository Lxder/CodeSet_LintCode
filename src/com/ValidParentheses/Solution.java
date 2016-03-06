package com.ValidParentheses;

import java.util.Stack;

public class Solution {
	public static void main(String args[]){
		System.out.println(new Solution().isValidParentheses(""));
	}
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
    	char[] ch = s.toCharArray();
    	Stack<Character> stack = new Stack<Character>();
    	for(char c : ch){
    		if(c=='{' || c =='[' || c =='('){
    			stack.add(c);
    		}else{
    			if(stack.isEmpty()) return false;
    			else{
    				char ctop = stack.pop();
    				if(ctop=='[' && c ==']') continue;
    				else if(ctop == '{' && c == '}') continue;
    				else if(ctop == '(' && c == ')') continue;
    				else return false;
    			}
    		}
    	}
    	if(stack.isEmpty()) return true;
    	return false;
    }
}