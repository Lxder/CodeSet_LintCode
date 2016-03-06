package com.PalindromePartitioningII;


public class Solution2 {
	public static void main(String args[]){
		Solution2 s = new Solution2();
		String str = "ababababababababababababcbabababababababababababa";
		System.out.println(s.minCut(str));
	}
	
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
	
	public int minCut(String s) {
		int len = s.length();
		if(len<=1) return 0;
		boolean[][] isPalin = new boolean[len][len]; //isPalin[i][j]=true表示i到j的子串为回文串
		
		int[] minCuts = new int[len+1]; //第i个元素表示0到i的最小切割次数
        for(int i = 0 ; i <= len ;i++) minCuts[i] = i-1; //初始化

        for(int j = 1 ; j < len ; j++){
        	for(int i = j ; i >= 0 ; i --){
        		if(s.charAt(i)==s.charAt(j) && ( (j-i<2) || isPalin[i+1][j-1])){
        			isPalin[i][j] = true;
        			minCuts[j+1] = Math.min(minCuts[j+1], minCuts[i]+1);//更新0到j最小切割次数
        		}
        	}
        }
        
        return minCuts[len];
    }
}
