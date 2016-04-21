package com.SubmatrixSum;

import java.util.HashMap;

public class Solution {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
    	int row = matrix.length;
    	if(row == 0 ) return new int[][]{{-1,-1},{-1,-1}};
    	int col = matrix[0].length;
    	
    	int[][] solution = new int[2][2];    	
    	for(int i = 0 ; i < row ; i ++){
    		for(int j = 0 ; j < col ; j ++){
    			if(matrix[i][j] == 0){
    				solution[0][0] = i;
    				solution[0][1] = j;
    				solution[1][0] = i;
    				solution[1][1] = j;
    				return solution;
    			}
    		}
    	}
    	for(int i = 0 ; i < row ; i ++){
    		HashMap<Integer,Integer> mapx = new HashMap<Integer,Integer>();
    		HashMap<Integer,Integer> mapy = new HashMap<Integer,Integer>();
    		//将左上角加入,方便处理从(i,0)开始这种情况
    		mapx.put(0, i-1);
    		mapy.put(0, -1);
    		
    		int[][] dp = new int[row][col];    		
        	dp[i][0] = matrix[i][0];
        	mapx.put(dp[i][0],i);
        	mapy.put(dp[i][0],0);
        	
        	//处理第一行
        	for(int k = 1 ; k < col ;k ++){
        		dp[i][k] = dp[i][k-1] + matrix[i][k];
        		if(mapx.containsKey(dp[i][k])){
    				solution[0][0] = i;
    				solution[0][1] = mapy.get(dp[i][k])+1;
    				solution[1][0] = i;
    				solution[1][1] = k;
    				return solution;
    			}else{
    				mapx.put(dp[i][k], i);
    				mapy.put(dp[i][k], k);
    			}
        	}
        	
        	//处理第一列
        	for(int k = i+1 ;k < row ; k ++){
        		dp[k][0] = dp[k-1][0] + matrix[k][0];
        		if(mapx.containsKey(dp[k][0])){
    				solution[0][0] = mapx.get(dp[k][0])+1;
    				solution[0][1] = 0;
    				solution[1][0] = k;
    				solution[1][1] = 0;    				
    				return solution;
    			}else{
    				mapx.put(dp[k][0], k);
    				mapy.put(dp[k][0], 0);
    			}
        	}
        	
        	for(int  k = i+1; k < row ; k ++){
        		//每次都要新建map，因为只能和自己同行的进行比较
        		HashMap<Integer,Integer> tempx = new HashMap<Integer,Integer>(mapx);
        		HashMap<Integer,Integer> tempy = new HashMap<Integer,Integer>(mapy);
        		for(int j = 1 ; j < col ; j ++){
        			dp[k][j] = dp[k][j-1] + dp[k-1][j] - dp[k-1][j-1] + matrix[k][j];
        			if(tempx.containsKey(dp[k][j])){
        				solution[0][0] = i;
        				solution[0][1] = tempy.get(dp[k][j])+1;
        				solution[1][0] = k;
        				solution[1][1] = j;
        				return solution;
        			}else{
        				tempx.put(dp[k][j], k);
        				tempy.put(dp[k][j], j);
        			}
        		}
        	} 
    	}    	
    	return solution;
    	
    	
    }
	public static void main(String[] args){
		//int[][] matrix = {{4037,-4688,-187,4562,835,4706,4306,-2551,3496,415,3445,-446,-1584,-2035,-160,-2075,-186,4134},{-1380,1924,289,1009,-923,2770,-1075,-926,4447,-362,-1820,4658,4802,3973,-3285,-2916,-1397,1030},{-4207,1397,2566,-489,-2036,-1260,-64,-1838,-3373,4891,3503,3916,1134,2540,-4245,-2461,-1996,-3217},{33,-144,-3775,1994,280,-2444,3659,-4798,6414,4213,1363,-1751,2579,-544,3247,-2160,1308,-4927},{-697,-4760,1786,-3548,3322,-3791,2709,3242,2355,-642,-1574,2254,-3019,3335,3596,3897,-3380,1201},{4128,2081,-448,608,-1567,-21,4427,1917,-2437,-3059,-4975,-4954,139,-2372,3196,1916,1914,-3349},{2051,-3932,-1913,666,-120,1344,1633,-2033,-4921,4513,3148,-1879,-4597,778,1731,1752,502,-2581},{-1147,-1896,-3080,372,4453,-3645,-4557,2588,-1057,-4453,-2209,1741,-117,-4624,-2118,-1072,-1010,2174},{3038,-1998,-4209,-418,-4520,4180,-571,-106,-105,-2343,-3787,3302,4482,3882,2207,-3644,-519,-3462},{-3928,-201,2724,-2056,-3510,4186,4133,-4106,2672,3326,3634,-952,4898,1010,-3072,-3837,1683,2420},{3823,1589,1806,4348,-3357,-2419,-4173,-2172,-4168,2044,2511,-4490,-4617,3565,4961,-3741,-1728,-390},{1624,-2373,-1910,4154,-682,3727,-3750,-2721,-776,-1170,-2239,-4730,490,2752,4985,-2557,-2575,-1493}};
		int[][] matrix = {{0,4},{-4,0}};
		//int[][] matrix = {{1,5,7},{3,7,-8},{4,-8,9}};
		//int[][] matrix ={{1},{1},{1},{1},{1},{1},{1},{1},{1},{1},{1},{-10},{1},{1},{1},{1},{1},{1},{1},{1},{1},{1},{1}};
		int[][] solu = new Solution().submatrixSum(matrix);
		System.out.println(solu[0][0]+" "+solu[0][1]);
		System.out.println(solu[1][0]+" "+solu[1][1]);
		
		
	}
}