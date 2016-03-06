package com.kSumii;

import java.util.ArrayList;

public class Solution {
	
	public static void main(String args[]){
		int[] A = {1,2,3,4};
		Solution s = new Solution();
		System.out.println(s.kSumII(A, 3, 6));
	}
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
    	ArrayList<ArrayList<Integer>> solu = new ArrayList<ArrayList<Integer>>();
    	helper(solu,new ArrayList<Integer>(),A,0,k,target);
    	return solu;
    }
    public void helper(ArrayList<ArrayList<Integer>> solu , ArrayList<Integer> currs , 
    		int[] A, int st , int k , int target){
    	if(target == 0 && k == 0){
    		System.out.println(currs);
    		solu.add(new ArrayList<Integer>(currs));
    		return ;
    	}else if(target < 0 || k == 0){
    		return;
    	}
    	for(int i = st ; i<A.length ;i++){
    		ArrayList<Integer> temps = new ArrayList<Integer>(currs);
    		temps.add(A[i]);
    		helper(solu,temps,A,i+1,k-1,target-A[i]);
    	}    	
    } 
}