package com.ConvertExpressionToReversePolishNotation;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
	public static void main(String args[]){
		
		String[] expression = {"2","*","6","-","(","23","+","7",")","/","(","1","+","2",")"};
		System.out.println(new Solution().convertToRPN(expression));
	}
    /**
     * @param expression: A string array
     * @return: The Reverse Polish notation of this expression
     */
    public ArrayList<String> convertToRPN(String[] expression) {
        // write your code here
    	Stack<String> stack = new Stack<String>();
    	ArrayList<String> solu = new ArrayList<String>();
    	int len = expression.length;
    	for(int i = 0 ; i < len ;i++){
    		String curr = expression[i];
    		if(curr.equals("+")||curr.equals("-")){
    			while(!stack.isEmpty() && (!stack.peek().equals("("))){
    			//while(!stack.isEmpty() && (stack.peek().equals("+")||stack.peek().equals("-"))||){
    				solu.add(stack.pop());
    			}
    			stack.add(curr);
    		}else if(curr.equals("*") || curr.equals("/")){
    			while(!stack.isEmpty() && (stack.peek().equals("*")||stack.peek().equals("/"))){
    				solu.add(stack.pop());
    			}
    			
    			stack.add(curr);
    		}else if(curr.equals("(")){
    			stack.add(curr);
    		}else if(curr.equals(")")){
    			while(!stack.peek().equals("(")){
    				solu.add(stack.pop());
    			}
    			stack.pop();
    			
    		}else{
    			solu.add(curr);
    		}
    	}
    	while(!stack.isEmpty()){
    		solu.add(stack.pop());
    	}
    	return solu;
    }
}