package com.NumberofIslands;
public class Solution {
    
	
	int row ;
	int col ;
    public int numIslands(boolean[][] grid) {
    	row = grid.length;
    	
    	if(row == 0 ) return 0;
    	col = grid[0].length;
    	int num = 0;
    	for(int i = 0 ; i < row ; i++){
    		for(int j = 0 ; j < col ; j++){
    			if(grid[i][j] == true){
    				dfs(grid,i,j);
    				num++;
    				
    			}    			
    		}    		
    	}
    	return num;
    	
    }
    public void dfs(boolean[][] grid, int i , int j ){
    	if(i <0 || i>=row || j<0 || j >= col){
    		return;
    	}
    	if(grid[i][j] == true){
    		grid[i][j] = false;
    		dfs(grid,i-1,j);
    		dfs(grid,i+1,j);
    		dfs(grid,i,j-1);
    		dfs(grid,i,j+1);
    	}
    }
    
    
    public static void main(String args[]){
    	boolean[][] grid = {
    			{true,true,false,false,false},
    			{false,true,false,false,true},
    			{false,false,false,true,true},
    			{false,false,false,false,false},
    			{false,false,false,false,true}    			
    	};
    	Solution s = new Solution();
    	System.out.println(s.numIslands(grid));
    	for(int i = 0 ; i < s.row ;i++){
    		for(int j = 0 ; j < s.col ; j++){
    			System.out.print(grid[i][j]+"\t");
    		}
    		System.out.println();
    	}
    }
    
}