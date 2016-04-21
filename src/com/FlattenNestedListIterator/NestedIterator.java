package com.FlattenNestedListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

	List<NestedInteger> nestedList ;
	List<Integer> flatList;
	int curridx ;
	int length;
	
    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
    	this.nestedList = nestedList;
    	flatList = new ArrayList<Integer>();
    	curridx = -1;
    	
    	helper(this.nestedList,flatList);
    	length = flatList.size();
    }
    
    public void helper(List<NestedInteger> nlist,List<Integer> soluList){
    	for(NestedInteger curr : nlist){
    		if(curr.isInteger()){
    			soluList.add(curr.getInteger());
    		}else{
    			helper(curr.getList(),soluList);
    		}
    	}
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
    	if(hasNext()){
    		curridx ++;
    		return flatList.get(curridx);
    	}
    	else {
    		return -1;
    	}
    	
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
    	if(curridx+1 < length){
    		return true;
    	}else{
    		return false;
    	}
    }

    @Override
    public void remove() {}
}


/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext())
 * v.add(i.next());
 */

interface NestedInteger {

	// @return true if this NestedInteger holds a single integer,
	// rather than a nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds,
	// if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds,
	// if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}
