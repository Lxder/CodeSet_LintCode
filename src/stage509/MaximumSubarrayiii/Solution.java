package stage509.MaximumSubarrayiii;

import java.util.ArrayList;

public class Solution {

	// 相当于买股票问题(k次交易) 注意：与买股票问题不同的是这里面的元素可能为负

	public static void main(String args[]) {
		int[] arr = {1,3,-1,2,-1,2 };
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			nums.add(arr[i]);
		}
		System.out.println(maxSubArray(nums, 2));
	}

	public static int maxSubArray(ArrayList<Integer> nums, int k) {
		if (nums == null)
			return 0;
		int len = nums.size();
		if (len < k)
			return 0;
		// k partitions of array with length len ,第i行代表进行i次连续计算
		int[][] globalMax = new int[k + 1][len + 1];
		for (int i = 1; i <= k; i++) {
			int localMax = Integer.MIN_VALUE;
			// 数组长度小于i不能进行划分
			for (int j = i - 1; j < len; j++) {
				localMax = Math.max(localMax, globalMax[i - 1][j])	+ nums.get(j);
				if (j == i - 1) //每一行的第一个要单独处理
					globalMax[i][j + 1] = localMax;
				else
					globalMax[i][j + 1] = Math.max(globalMax[i][j], localMax);
			}
		}
		//输出DP数组
		for(int i = 0 ; i <=k ; i++){
			for(int j = 0 ; j <= len ; j++){
				System.out.print(globalMax[i][j]+"\t");
			}
			System.out.println();
		}
		return globalMax[k][len];
	}

}
