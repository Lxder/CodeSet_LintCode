package com.FirstMissingPositive;

public class Solution {
	public static void main(String[] args) {
		int[] A = { 2, 1 };
		System.out.println(new Solution().firstMissingPositive(A));
	}

	/**
	 * @param A
	 *            : an array of integers
	 * @return: an integer
	 */

	public int firstMissingPositive(int[] A) {
		int n = A.length;
		for (int i = 0; i < n;) {
			if (A[i] == i + 1)
				i++;
			else {
				if (A[i] >= 1 && A[i] <= n && A[A[i] - 1] != A[i]) {
					//swap(A[i],A[A[i]-1]); 
					//注意必须先给将A[A[i]-1]赋值为temp，
					//若先赋值A[i]给temp，A[i]值改变了，那么A[A[i]-1]的下标也就变了  
					int temp = A[A[i]-1];
					A[A[i]-1] = A[i];
					A[i] = temp;
					System.out.println(A[i]+" "+(i+1));
				} else {
					i++;
				}
			}
		}
		for (int i = 0; i < n; i++){
			if (A[i] != i + 1){
				return i + 1;
			}
		}
		return n + 1;
	}
}