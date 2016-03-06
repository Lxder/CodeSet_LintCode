package com.WoodCut;


public class Solution {
	public static void main(String args[]){
		int[] L = {232,124,456};
		System.out.println(new Solution().woodCut(L,7 ));
	}
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
	

    public int woodCut(int[] L, int k) {    	
    	if(L.length ==0) return 0;
    	int maxlen = L[0];
    	for(int i = 1 ; i < L.length ; i ++){
    		maxlen = Math.max(maxlen, L[i]);
    	}
    	long l = 0 ;
    	long r = maxlen;
    	long mid = maxlen;
    	while(l<r){
    		mid = (l+r+1)/2;
    		long num = 0;
    		for(int i = 0 ; i < L.length ; i ++){    			
    			num += L[i]/mid	;
    		}
    		System.out.println(mid+" "+num);
    		if(num >= k){
    			l = mid;
    		}else{
    			r = mid -1;
    		}
    	}
    	return (int)l;
    }
}