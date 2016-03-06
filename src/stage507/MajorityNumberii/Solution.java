package stage507.MajorityNumberii;

import java.util.ArrayList;

public class Solution {
	public static void main(String args[]){
		int[] arrs = {0,0,2,2,2,2,3};
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 0 ; i < arrs.length ; i++){
			nums.add(arrs[i]);
		}
		System.out.println(majorityNumber(nums));
	}
	
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public static int majorityNumber(ArrayList<Integer> nums) {
        // write your code
    	int n1 = Integer.MIN_VALUE ;
    	int n2 = Integer.MIN_VALUE ;
    	int count1 = 0;
    	int count2 = 0;
    	int len = nums.size();
    	for(int i = 0 ; i < len ; i++){
    		if( n1==nums.get(i) ){
    			count1++;
    		}else if(n2==nums.get(i)){
    			count2++;
    		}else{
    			if(count1==0){
    				n1=nums.get(i);
    				count1 = 1;
    			}else if(count2==0){
    				n2=nums.get(i);
    				count2 = 1;
    			}else{
    				count1--;
    				count2--;
    			}
    		}
    	}
    	count1 = 0;
    	count2 = 0;
    	for(int i = 0 ; i < len ; i++){
    		if(nums.get(i)==n1) count1++;
    		else if(nums.get(i)==n2) count2++;
    	}
    	if(count1>len/3) return n1;
    	return n2;
    	
    			
    }
}

