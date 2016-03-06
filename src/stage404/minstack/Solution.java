package stage404.minstack;

import java.util.Stack;

public class Solution {
	Stack<Integer> stack ;
	Stack<Integer> mstack ;
    
    public Solution() {
        // do initialize if necessary
    	this.stack = new Stack<Integer>();
    	this.mstack = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
    	stack.push(number);
    	if(mstack.isEmpty()||number<mstack.peek())
    		mstack.add(number);
    	else
    		mstack.add(mstack.peek());
    }

    public int pop() {
        // write your code here
    	mstack.pop();
    	return stack.pop();
    	
    }

    public int min() {
        // write your code here
    	return mstack.peek();
    }
}

