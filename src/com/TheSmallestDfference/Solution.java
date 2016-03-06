package com.TheSmallestDfference;

import java.util.Arrays;

public class Solution {
	public static void main(String args[]){
		int[] A = {3,4,6,7};
		int[] B = {2,7,8,9};
		System.out.println(new Solution().smallestDifference(A, B));
	}
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
    	int lenb = B.length;
    	int solu = Integer.MAX_VALUE;
    	Arrays.sort(A);
    	Arrays.sort(B);
    	
    	int mid ;
    	for(int a : A){
    		int st = 0;
        	int ed = B.length-1;
        	int cursolu =Integer.MAX_VALUE;
    		while(st <= ed){
    			mid = (st + ed) /2;
    			if(a == B[mid]) return 0;
    			else if(a<B[mid]){
    				ed = mid -1;
    			}else{
    				st = mid +1;
    			}
    			//最小值肯定在st与ed两个之一
    			if(st < lenb){
    				cursolu = Math.min(cursolu, Math.abs(a-B[st]));
    			}
    			if(ed >= 0){
    				cursolu = Math.min(cursolu, Math.abs(a-B[ed]));
    			}
    			//cursolu = Math.min(Math.abs(a-B[st]), Math.abs(a-B[ed]));
    			solu = Math.min(solu, cursolu);
    		}
    	}
    	return solu;
    }
}
