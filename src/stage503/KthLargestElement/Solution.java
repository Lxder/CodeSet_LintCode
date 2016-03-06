package stage503.KthLargestElement;

import java.util.ArrayList;

//Ѱ�ҵ�K���Ԫ��
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
    	if(k==st) return nums[k]; //Ѱ�ҵ���K���Ԫ��
    	else if(st>k){ //û���ҵ���K���Ԫ��,�ҵ���Ԫ��λ��>k�����K���Ԫ��һ�������
    		System.out.println("������");
    		return helper(k,nums,start,st);
    	}
    	else{
    		System.out.println("������");
    		return helper(k,nums,st+1,end); //��K���Ԫ��һ�����ұ�
    	}
    	
    	
    }
        
    //����
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
