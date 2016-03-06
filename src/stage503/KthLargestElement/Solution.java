package stage503.KthLargestElement;

import java.util.ArrayList;

//寻找第K大的元素
class Solution {
	public static void main(String args[]){
		int[] nums = {1,2,3,4,5};
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i = 0  ;i < nums.length ; i++){
			numbers.add(nums[i]);
		}
		int solu = kthLargestElement(2,numbers);
		System.out.println(solu);
		
	}
	
	
    //param k : description of k
    //param numbers : array of numbers
    //return: description of return
    public static int kthLargestElement(int k, ArrayList<Integer> numbers) {
        // write your code here
    	int len = numbers.size();
    	Integer[] nums = (Integer[])numbers.toArray(new Integer[len]);
    	int solu = helper(k-1,nums,0,len);    	
    	return solu;
    }
    
    public static int helper(int k,Integer[] nums,int start , int end){    	
    	int divide = nums[start];
    	int st = start ;
    	int ed = end-1;
    	while(st<ed){    		
    		while(st<ed && divide>=nums[ed]){
    			ed--;
    		}
    		nums[st] = nums[ed];
    		while(st<ed && divide<=nums[st]){
    			st++;
    		}
    		nums[ed]=nums[st];
    	}
    	nums[st] = divide;
    	System.out.println("loc:"+st+" num:"+divide);
    	if(k==st) return nums[k]; //寻找到第K大的元素
    	else if(st>k){ //没有找到第K大的元素,找到的元素位置>k，则第K大的元素一定在左边
    		System.out.println("向左找");
    		return helper(k,nums,start,st);
    	}
    	else{
    		System.out.println("向右找");
    		return helper(k,nums,st+1,end); //第K大的元素一定在右边
    	}
    	
    	
    }
        
    //快排
    public static void quicksort(int nums[],int start , int end){
    	if(start>=end) return;
    	int divide = nums[start];
    	int st = start ;
    	int ed = end-1;
    	while(st<ed){    		
    		while(st<ed && divide>=nums[ed]){
    			ed--;
    		}
    		nums[st] = nums[ed];
    		while(st<ed && divide<=nums[st]){
    			st++;
    		}
    		nums[ed]=nums[st];
    	}
    	nums[st] = divide;
    	quicksort(nums,start,st);
    	quicksort(nums,st+1,end);
    }
};
