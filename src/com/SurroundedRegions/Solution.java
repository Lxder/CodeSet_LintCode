package com.SurroundedRegions;
public class Solution {
	public static void main(String args[]){
		char[][] board = {
				{'X','X','X','X'},
				{'X','O','O','X'},
				{'X','X','O','X'},
				{'X','O','X','X'}
		};
		Solution s= new Solution();
		s.surroundedRegions(board);
		for(int i = 0 ; i < board.length ; i++){
			for(int j = 0 ; j <board[0].length ; j++){
				System.out.print(board[i][j]+" ");

			}
			System.out.println();
		}
	}
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
	int row , col;
    public void surroundedRegions(char[][] board) {
        // Write your code here
    	row = board.length;
    	if(row==0) return;
    	col = board[0].length;
    	//将和边界连通的'O'全都置为'I'
    	for(int i = 0 ; i < row ; i++){
    		if(board[i][0] == 'O')
    			dfs(board,i,0);
    		if(board[i][col-1] == 'O')
    			dfs(board,i,col-1);
    	}    	
    	for(int i = 0 ;i < col ; i++){
    		if(board[0][i] == 'O')
    			dfs(board,0,i);
    		if(board[row-1][i] == 'O')
    			dfs(board,row-1,i);
    	}
    	
    	for(int i = 0 ; i < row ; i++){
    		for(int j = 0 ; j < col ; j++){
    			if(board[i][j]=='O'){
    				board[i][j] = 'X';
    			}else if(board[i][j]=='I'){
    				board[i][j] = 'O';
    			}
    		}
    	}
    }
    //四个方向深搜
    public void dfs( char[][] board , int i , int j ){
    	
    	if(i<0||i>=row||j<0||j>=col) return;
    	if(board[i][j] == 'O'){
    		board[i][j] = 'I';
    		dfs(board,i,j-1);
    		dfs(board,i,j+1);
    		dfs(board,i-1,j);
    		dfs(board,i+1,j);
    	}
    }
}