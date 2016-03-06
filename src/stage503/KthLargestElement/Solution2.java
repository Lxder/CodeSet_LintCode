package stage503.KthLargestElement;

import java.util.ArrayList;

//寻找第K大的元素
class Solution2 {
	public static void main(String args[]){
		int[] nums = {1,2,3,4,5};
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i = 0  ;i < nums.length ; i++){
			numbers.add(nums[i]);
		}
		int solu = kthLargestElement(5,numbers);
		System.out.println(solu);
		
	}
	
	public static int kthLargestElement(int k, ArrayList<Integer> numbers) {
		int len = numbers.size();
    	Integer[] nums = (Integer[])numbers.toArray(new Integer[len]);
    	int solu = kbig(nums,0,len-1,len-k);
    	return solu;
    }
	public static  int kbig(Integer[] nums, int left , int right , int k ){
        
		if(left>right) return -1;
		
		int key = nums[left];
        int low = left; 
        int high = right;
        
        while(low < high){
            while(low < high && nums[high]>=key)
                high--;
            nums[low] = nums[high];
            while(low<high && nums[low]<=key)
                low++;
            nums[high] = nums[low];
        }
        nums[low] = key;
        //一趟快排结束, low位置的元素已经在最终位置上了 ,左侧均比low小，右侧均比low大
        
        if(low==k) return nums[low];

        if(low<k)
        	return kbig(nums,low+1,right,k);
        else return kbig(nums,left,low-1,k);
	}
	
	
    
};
