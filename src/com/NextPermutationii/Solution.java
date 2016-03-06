package com.NextPermutationii;
public class Solution {
	public static void main(String args[]){
		int[] nums = {1,2,3};
		new Solution().nextPermutation2(nums);
		for(int i : nums){
			System.out.print(i+" ");
		}
	}
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
	
	public void nextPermutation2(int[] nums){
		int len = nums.length;
		if(len ==0 || len ==1 ) return ;
		int ismal = len -2;
		while(ismal >=0 && nums[ismal] >= nums[ismal+1])
			ismal--;
		if(ismal == -1){
			InvertArray(nums,0,len-1);
			return;
		}
		int imbiger = ismal+1;
		for(int i = ismal+1 ; i <len ; i++){
			if(nums[i] > nums[ismal] && nums[i] < nums[imbiger]){
				imbiger = i;
			}
		}
		Swap(nums,ismal,imbiger);
		InvertArray(nums,ismal+1,len-1);
		
	}
	
    public void nextPermutation(int[] nums) {
    	if(nums.length==0||nums.length==1)
            return;
        int len = nums.length;
        int ismal = len-2;
        while(ismal>=0 && nums[ismal]>=nums[ismal+1])
            ismal--; //1. 向前找出第一个比右边数字小的数字的序号j

        if(ismal==-1){ //如果整个数组都是递增的，就返回第一个序列，即变为递减的那个序列
            InvertArray(nums, 0,len-1);
            return;
        }        
        int i_min = ismal+1;//2. 在P[j]的右边的数字中，找出所有比P[j]大的数中最小的数字Pk(右侧为递增的)
        
        while(i_min<len&& nums[i_min]> nums[ismal]) 
            i_min++;
        i_min--;
        Swap(nums,ismal,i_min);    //3. 交换nums[ismal]和nums[i_min]
        InvertArray(nums,ismal+1,len-1);//4. 将ismal+1到len-1的元素逆置
    	
    }
    
    public static void Swap(int[] nums, int i , int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void InvertArray(int[] nums, int start , int end){
        int temp;
        while(start<end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++; end--;
        }
    }
}