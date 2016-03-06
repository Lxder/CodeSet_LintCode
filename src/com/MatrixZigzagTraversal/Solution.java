package com.MatrixZigzagTraversal;
public class Solution {
	public static void main(String args[]){
		int[][] matrix = {
		                  {1, 2,  3,  4},
		                  {5, 6,  7,  8},
		                  {9,10, 11, 12}
		};
		int[] solu = new Solution().printZMatrix(matrix);
		for(int i = 0 ; i < solu.length ; i ++){
			System.out.print(solu[i]+ "\t");
		}
	}
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */ 
    public int[] printZMatrix(int[][] matrix) {
        // write your code here
    	int row = matrix.length;
    	if(row == 0) return new int[0];
    	int col = matrix[0].length;
    	int sum = row + col-2;
    	int[] solu = new int[row*col];
    	
    	solu[0] = matrix[0][0];
    	int idx = 1;
    	for(int s = 1 ; s <= sum ; s++ ){
    		int i , j;
    		int maxr = Math.min(s, row-1);
    		int minr = Math.max(0, s-col+1); 
    		for(i = minr ; i <= maxr ; i ++){
    			j = s - i;
    			solu[idx++] = matrix[i][j];    			
    		}
    		s ++ ; 
    		if(s > sum) break;
    		maxr = Math.min(s, row-1);
    		minr = Math.max(0, s-col+1);
    		for(i = maxr ; i >= minr ; i --){
    			j = s - i;
    			solu[idx++] = matrix[i][j];
    		}
    	}
    	return solu;
    }
}