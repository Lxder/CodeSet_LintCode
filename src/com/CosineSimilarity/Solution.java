package com.CosineSimilarity;
class Solution {
	public static void main(String args[]){
		int[] A = {1,2,3};
		int[] B = {2,3,4};
		System.out.println(new Solution().cosineSimilarity(A, B));
	}
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: Cosine similarity.
     */
    public double cosineSimilarity(int[] A, int[] B) {
        double up = 0;
        double dw1 = 0;
        double dw2 = 0;
        int len = A.length ;
        for(int i = 0 ; i < len ; i++){
        	up += A[i]*B[i];
        	dw1 += A[i]*A[i];
        	dw2 += B[i]*B[i];
        }
        if(Math.abs(dw1)<Math.exp(-10) || Math.abs(dw2)<Math.exp(-10)) return 2;
        double solu = up /Math.sqrt(dw1)/Math.sqrt(dw2);
        return solu;
    	
    }
}
