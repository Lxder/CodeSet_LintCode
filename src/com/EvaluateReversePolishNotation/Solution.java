package com.EvaluateReversePolishNotation;

import java.util.Stack;

public class Solution {
	public static void main(String args[]){
		String[] tokens = {};
		System.out.println(new Solution().evalRPN(tokens));
	}
    /**
     * @param tokens The Reverse Polish Notation
     * @return the value
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int len = tokens.length;
        if(len == 0) return 0;
        int t1 , t2;
        int curr;
        for(int i = 0 ; i < len ; i++){
        	if(tokens[i].equals("+")){
        		curr = stack.pop() + stack.pop();
        		stack.push(curr);
        	}else if(tokens[i].equals("-")){
        		t2 = stack.pop();
        		t1 = stack.pop();
        		curr = t1 - t2;
        		stack.push(curr);
        	}else if(tokens[i].equals("*")){
        		curr = stack.pop() * stack.pop();
        		stack.push(curr);
        	}else if(tokens[i].equals("/")){
        		t2 = stack.pop();
        		t1 = stack.pop();
        		curr = t1 / t2;
        		stack.push(curr);
        	}else{
        		stack.add(Integer.valueOf(tokens[i]));
        	}
        }
        return stack.peek();
    	
    }
}