package stage208.implementqueuebytwostacks;

import java.util.Stack;

public class Solution {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Solution() {
       // do initialization if necessary
    	stack1 = new Stack<Integer>();
    	stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        // write your code here
    	stack1.add(element);
    }

    public int pop() {
        // write your code here
    	if(stack2.isEmpty()){
    		while(!stack1.isEmpty()){
    			stack2.push(stack1.pop());
    		}    		
    	}
    	return stack2.pop();
    }

    public int top() {
        // write your code here
    	if(stack2.isEmpty()){
    		while(!stack1.isEmpty()){
    			stack2.push(stack1.pop());
    		}    		
    	}
    	return stack2.peek();
    	
    }
}

