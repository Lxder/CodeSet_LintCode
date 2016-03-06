package com.MergeSortedArray;
class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
    	int end = m+n-1;
    	int ia = m-1;
    	int ib = n-1;
    			
    	while(ia >=0 && ib>=0){
    		if(A[ia]>B[ib]){
    			A[end--] = A[ia--];
    		}else{
    			A[end--] = B[ib--];
    		}
    	}
    	while(ia>=0){
    		A[end--] = A[ia--];
    	}
    	while(ib>=0){
    		A[end--] = B[ib--];
    	}
    }
}