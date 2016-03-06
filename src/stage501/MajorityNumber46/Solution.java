package stage501.MajorityNumber46;

import java.util.ArrayList;
import java.util.Iterator;

public class Solution {
	public static void main(String args[]){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(2);
		nums.add(1);
		nums.add(1);
		nums.add(1);
		nums.add(2);
		nums.add(2);
		System.out.println(majorityNumber(nums));
	}
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public static int majorityNumber(ArrayList<Integer> nums) {
        // write your code
    	Iterator<Integer> itr = nums.iterator();
    	int solu = itr.next() ;
    	int count= 1;
    	while(itr.hasNext()){
    		int curr = itr.next();
    		if(curr==solu){
    			count++;
    		}else{
    			count--;
    		}
    		
    		if(count==0) {
    			solu = curr;
    			count=1;
    		}
    		
    	}
    	return solu;
    }
}

