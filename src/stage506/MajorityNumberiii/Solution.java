package stage506.MajorityNumberiii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
	public static void main(String args[]) {
		int[] arrs = { 32, 125, 176, 234, 170, 147, 151, 243, 67, 62, 20, 149,
				191, 129, 131, 107, 126, 50, 194, 63, 191, 191, 13, 139, 191,
				164, 239, 119, 234, 79, 51, 160, 194, 140, 191, 165, 80, 191,
				26, 26, 191, 26, 16, 252, 196, 12, 191, 191, 249, 52, 161, 169,
				94, 140, 250, 75, 110, 143, 57, 255, 90, 143, 191, 71, 16, 22,
				50, 252, 191, 138, 191, 142, 221, 104, 182, 57, 47, 191, 179,
				63, 191, 68, 91, 185, 225, 183, 69, 216, 146, 152, 164, 172,
				169, 68, 245, 123, 191, 191, 219, 207, 244, 147, 215, 42, 121,
				112, 241, 179, 27, 162, 243, 133, 148, 178, 214, 191, 208, 138,
				45, 62, 191, 56, 232, 74, 197, 154, 225, 31, 136, 191, 244,
				166, 41, 48, 50, 94, 245, 239, 103, 191, 191, 161, 180, 82,
				210, 191, 191, 253, 163, 171, 140, 249, 198, 51, 85, 93, 55,
				76, 32, 191, 191, 27, 57, 231, 163, 205, 134, 165, 40, 11, 191,
				133, 183, 164, 138, 75, 191, 22, 232, 248, 54, 136, 106, 109,
				229, 242, 121, 210, 218, 28, 72, 252, 90, 177, 184, 60, 229,
				81, 98, 36, 48, 21, 230, 120, 19, 202, 76, 196, 236, 44, 162,
				94, 89, 151, 72, 191, 242, 187, 218, 228, 62, 169, 62, 187,
				162, 232, 24, 236, 164, 28, 63, 117, 212, 191, 206, 15, 209,
				85, 37, 177, 23, 250, 30, 126, 246, 48, 115, 96, 198, 106, 198,
				139, 19, 118, 153 };
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < arrs.length; i++) {
			nums.add(arrs[i]);
		}
		System.out.println(majorityNumber(nums, 9));
	}

	public static int majorityNumber(ArrayList<Integer> nums, int k) {
		// write your code
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums) {
			if (map.containsKey(i)) {// key包含在内
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}

			if (map.size() == k) {
				myremove(map);
				// map.put(i, 1);
			}

		}

		int maxkey = 0, maxnum = 0;
		Set<Integer> keySet = map.keySet();
		for (int key : keySet) {
			map.put(key, 0);
		}
		for (int i : nums) {
			if (map.containsKey(i))
				map.put(i, map.get(i) + 1);
		}
		for (int key : keySet) {
			System.out.println(key + " " + map.get(key));
			if (maxnum < map.get(key)) {
				maxkey = key;
				maxnum = map.get(key);
			}

		}
		return maxkey;

	}

	// 所有的key的数量都减去1 ， 如果数量为0，则删除这个key
	public static void myremove(HashMap<Integer, Integer> map) {
		Set<Integer> keySet = map.keySet();
		List<Integer> remlist = new LinkedList<Integer>();
		for (Integer key : keySet) {
			if (map.get(key) == 1)
				remlist.add(key);
			else
				map.put(key, map.get(key) - 1);
		}

		System.out.print("要移除的key ");
		for (Integer key : remlist) {
			System.out.print(key + " ");
			map.remove(key);
		}
		System.out.println();
	}

}
