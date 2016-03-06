package com.ValidSudoku;


class Solution {
	public static void main(String args[]){
		char[][] board = {
				{'2','8','7','6','5','4','3','2','1'},
				{'2','.','.','.','.','.','.','.','.'},
				{'3','.','.','.','.','.','.','.','.'},
				{'4','.','.','.','.','.','.','.','.'},
				{'5','.','.','.','.','.','.','.','.'},
				{'6','.','.','.','.','.','.','.','.'},
				{'7','.','.','.','.','.','.','.','.'},
				{'8','.','.','.','.','.','.','.','.'},
				{'9','.','.','.','.','.','.','.','.'},
				};
		Solution s = new Solution();
		System.out.println(s.isValidSudoku(board));
	}
	
    /**
      * @param board: the board
        @return: wether the Sudoku is valid
      */
    public boolean isValidSudoku(char[][] board) {
    	
    	int[][] row = new int[9][9];
    	int[][] col = new int[9][9];
    	int[][] sqr = new int[9][9];
    	
    	for(int i = 0 ; i < 9 ; i++){
    		for(int j = 0 ; j < 9 ; j ++){
    			if(board[i][j]=='.') continue;
    			int c = board[i][j]-'1';
    			row[i][c] = 1 ;
    			col[j][c] = 1 ;
    			sqr[i/3*3+j/3][c] = 1;
    		}
    	}   	    	
    	
    	for(int i = 0 ; i < 9 ; i ++){
    		for(int j = 0 ; j < 9 ; j ++){
    			if(board[i][j]=='.') continue;
    			int c = board[i][j] - '1';
    			if(row[i][c]==2 || col[j][c] ==2 || sqr[i/3*3+j/3][c] ==2){
    				return false;
    				
    			}
    			else{
    				row[i][c]++;
    				col[j][c]++;
    				sqr[i/3*3+j/3][c]++;
    			}
    		}
    	}
    	return true;
    }
    
}