package stage209.searcha2dmatrixii38;
public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
    	int row = matrix.length;
    	if(row==0) return 0;
    	int col = matrix[0].length;
    	int stx = 0;
    	int sty = col-1;
    	int tnum = 0;
    	while(stx<row && sty>=0){
    		if(matrix[stx][sty]==target){
    			tnum++;
    			sty--;
    		}else if(matrix[stx][sty]>target){
    			sty--;
    		}else
    			stx++;
    	}
    	return tnum;
    }
}

