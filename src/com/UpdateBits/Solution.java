package com.UpdateBits;

public class Solution {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
	
		
	}

	public int updateBits(int n, int m, int i, int j) {
		// write your code here
		int st = 0;
		int solu = n;
		for(int idx = i ; idx <=j ; idx++){
			if(((m>>st)&1) == 0){ //m当前位是0
				solu = solu & (-1 ^ (1<<idx));
			}else{//m当前位是1
				solu = solu | (1<<idx);
			}
			st++;
		}
		return solu;
	}
}
