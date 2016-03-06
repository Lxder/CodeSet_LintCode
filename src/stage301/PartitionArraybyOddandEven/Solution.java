package stage301.PartitionArraybyOddandEven;
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
	
	public static void main(String args[]){
		int[] nums = {1,3,5,7,9};
		partitionArray(nums);
		for(int i = 0;  i < nums.length ; i++){
			System.out.println(nums[i]);
		}
		
	}
    public static void partitionArray(int[] nums) {
        // write your code here;
    	int len = nums.length;
    	int st = 0 ;
    	int ed = len-1;
    	int temp ;
    	while(st<ed){
    		if(nums[st]%2==0){
    			temp = nums[st];
    			nums[st] = nums[ed];
    			nums[ed] = temp;
    			ed--;
    		}
    		else st++;
    	}
    }
}
