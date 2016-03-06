package stage509.MaximumSubarrayiii;

import java.util.ArrayList;

public class Solution {

	// �൱�����Ʊ����(k�ν���) ע�⣺�����Ʊ���ⲻͬ�����������Ԫ�ؿ���Ϊ��

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
		// k partitions of array with length len ,��i�д������i����������
		int[][] globalMax = new int[k + 1][len + 1];
		for (int i = 1; i <= k; i++) {
			int localMax = Integer.MIN_VALUE;
			// ���鳤��С��i���ܽ��л���
			for (int j = i - 1; j < len; j++) {
				localMax = Math.max(localMax, globalMax[i - 1][j])	+ nums.get(j);
				if (j == i - 1) //ÿһ�еĵ�һ��Ҫ��������
					globalMax[i][j + 1] = localMax;
				else
					globalMax[i][j + 1] = Math.max(globalMax[i][j], localMax);
			}
		}
		//���DP����
		for(int i = 0 ; i <=k ; i++){
			for(int j = 0 ; j <= len ; j++){
				System.out.print(globalMax[i][j]+"\t");
			}
			System.out.println();
		}
		return globalMax[k][len];
	}

}
