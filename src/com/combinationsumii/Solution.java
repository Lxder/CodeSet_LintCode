package com.combinationsumii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
	public static void main(String[] args){
		int[] num = {10,1,6,7,2,1,5};
		System.out.println(new Solution().combinationSum2(num, 8));
	}
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
    	Arrays.sort(num);
        List<List<Integer>> solu = new ArrayList<List<Integer>>();
        helper(num,target,0,num.length-1,0,solu,new ArrayList<Integer>());
        return solu;
        
    }
    
    public void helper(int[] num , int target , int st , int ed ,int sum,
                        List<List<Integer>> solu, List<Integer> curr){
    	
        if(sum == target){        	
            solu.add(curr);
            return;
        }
        else if(sum > target){
            return;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = st ; i <= ed ; i ++){
        	if(set.contains(num[i])){ //ÅÅ³ıÖØ¸´½á¹û
        		continue;
        	}else{
        		set.add(num[i]);
        	}
            List<Integer> temp = new ArrayList<Integer>(curr);
            temp.add(num[i]);
            helper(num,target,i+1,ed,sum+num[i],solu,temp);
        }
    }
}