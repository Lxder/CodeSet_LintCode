package com.ContainerWithMostWater;

public class Solution {
	public static void main(String args[]) {
		int[] heights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Solution s = new Solution();
		System.out.println(s.maxArea(heights));
	}

	/**
	 * @param heights
	 *            : an array of integers
	 * @return: an integer
	 */
	public int maxArea(int[] heights) {
		// write your code here
		if (heights.length == 0 || heights.length == 1)
			return 0;
		int st = 0;
		int ed = heights.length - 1;
		int area = 0;
		area = (ed - st) * Math.min(heights[st], heights[ed]);
		int s = st, e = ed;
		while (s < e) {
			if (heights[s] < heights[e]) {
				s = st;
				while (s < e && heights[s] <= heights[st]) {
					s++;
				}
				st = s;
				area = Math.max(area,
						(e - s) * Math.min(heights[s], heights[e]));
			} else {
				e = ed;
				while (s < e && heights[e] <= heights[ed]) {
					e--;
				}
				ed = e;
				area = Math.max(area,
						(e - s) * Math.min(heights[s], heights[e]));
			}
		}
		return area;

	}
}