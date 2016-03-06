package com.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String args[]){
		int[][] matrix = {
				
		};
		System.out.println(new Solution().spiralOrder(matrix));
	}
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> solu = new ArrayList<Integer>() ;
    	int stx = 0 , edx = matrix.length -1;
    	if(edx<0) return solu;
    	int sty = 0 , edy = matrix[0].length-1;

    	while(stx <=edx && sty <=edy){
    		int i = stx ;
    		int j = sty ;
    		while(j <= edy){
    			solu.add(matrix[i][j]);
    			j++;
    		}
    		stx++;
    		j--;
    		i = stx;
    		if(stx >edx || sty > edy) break;
    		
    		while(i <= edx){
    			solu.add(matrix[i][j]);
    			i++;
    		}
    		edy--;
    		i--;
    		j = edy;
    		if(stx >edx || sty > edy) break;
    		
    		while(j >= sty){
    			solu.add(matrix[i][j]);
    			j--;
    		}
    		edx --;
    		j++;
    		i = edx;
    		if(stx >edx || sty > edy) break;
    		
    		while(i >= stx){
    			solu.add(matrix[i][j]);
    			i--;;
    		}
    		sty++;
    	}
    	return solu;
    	
    }
}