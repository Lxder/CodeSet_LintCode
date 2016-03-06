package com.LongestCommonSubsequence;
public class Solution {
	
	public static void main(String args[]){
		Solution s = new Solution();
		System.out.println(s.longestCommonSubsequence("BDCABA", "ABCBDAB"));
	}
	
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
    	int lenA = A.length();
    	int lenB = B.length();
    	
    	//c[i][j]��ŵ�ΪA[0..i-1] B[0..j-1]���ַ��������������
    	/*
    	 * �� i==0 || j ==0			�� 	c[i][j]=0 
    	 * �� i,j>0 && A[i]==B[j]	��	c[i][j]=c[i-1][j-1]+1
    	 * �� i,j>0 && A[i]!=B[j]	��	c[i][j]=max(c[i-1][j],c[i][j-1]) 
    	 */
    	int[][] c = new int[lenA+1][lenB+1];
    	for(int i = 1 ; i <= lenA ; i ++ ){
    		for(int j = 1 ; j <= lenB ; j ++ ){
    			if(A.charAt(i-1) == B.charAt(j-1)){
    				c[i][j] = c[i-1][j-1]+1;
    			}else if(c[i-1][j] >= c[i][j-1]){
    				c[i][j] = c[i-1][j];
    			}else{
    				c[i][j] = c[i][j-1];
    			}
    		}
    	}
    	for(int  i = 0 ; i <= lenA ; i++){
    		for(int j = 0 ; j <=lenB ; j ++){
    			System.out.print(c[i][j]+" ");
    		}
    		System.out.println();
    	}
    	return c[lenA][lenB];
    	
    	
    }
}
