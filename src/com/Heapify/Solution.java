package com.Heapify;
public class Solution {
	public static void main(String[] args){
		
	}
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
    	for(int i = (A.length-1)/2 ; i >=0 ; i --){
    		helper(A,i);
    	} 
    	
    }
    
    public void helper(int[] A , int idx){
    	int s1 = idx*2 + 1;
    	int s2 = idx*2 + 2;
    	
    	if(s2<A.length){
    		if(A[idx] > A[s2] && A[s1] > A[s2]){
				int temp = A[idx];
    			A[idx] = A[s2];
    			A[s2] = temp;
    			helper(A,s2);    			    			
    		}else if(A[idx] > A[s1] && A[s2] > A[s1]){
    			int temp = A[idx];
    			A[idx] = A[s1];
    			A[s1] = temp;
    			helper(A,s1);
    		}
    	}
    	else if(s1<A.length){
    		if(A[idx] > A[s1]){
    			int temp = A[idx];
    			A[idx] 	= A[s1];
    			A[s1] = temp;
    			helper(A,s1);
    		}
    	}
    }
}