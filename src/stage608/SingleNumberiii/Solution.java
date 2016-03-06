package stage608.SingleNumberiii;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	public static void main(String args[]){
		int[] A =  {1,2,2,3,4,4,5,3};
		System.out.println(new Solution().singleNumberIII(A));
	}
	
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
    	int len = A.length;
    	int divide = 0;
    	for(int i = 0 ;i< len ; i++){
    		divide = divide^A[i];
    	}
    	int base = 1;
    	while((base&divide)==0){
    		base = base<<1;
    	}

    	int solu1 = 0;
    	int solu2 = 0;
    	for(int i =0 ; i < len ; i++){
    		if((base&A[i])!=0){
    			solu1 = solu1 ^ A[i];
    		}else{
    			solu2 = solu2 ^ A[i];
    		}
    	}
    	List<Integer> solu = new LinkedList<Integer>();
    	solu.add(solu1);
    	solu.add(solu2);
    	return solu;
    }
}
