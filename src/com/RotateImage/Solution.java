package com.RotateImage;
public class Solution {

	public static void main(String args[]){
		int[][] matrix = {
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}
		};
		new Solution().rotate(matrix);
		for(int i = 0 ; i < matrix.length ; i++){
			for(int j = 0 ; j < matrix.length ; j++){
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
	}
	/**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void rotate(int[][] matrix) {
    	int len = matrix.length;
    	if(len == 0 ) return ;
    	int ctr = len / 2 ;
    	int temp;
    	for(int i = 0 ; i <= ctr ; i++){
    		for(int j = i ; j < len-i-1 ; j ++){
    			temp = matrix[i][j];
    			matrix[i][j] = matrix[len-1-j][i];
    			matrix[len-1-j][i] = matrix[len-1-i][len-1-j];
    			matrix[len-1-i][len-1-j] = matrix[j][len-1-i];
    			matrix[j][len-1-i] = temp;
    		} 
    		
    	}
    }
}