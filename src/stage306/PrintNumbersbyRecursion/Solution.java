package stage306.PrintNumbersbyRecursion;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	public static void main(String args[]){
		
		System.out.println(1+'0');
		System.out.println(new Solution().numbersByRecursion(5).size());
		
	}
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
    	List<Integer> solu = new LinkedList<Integer>();
    	numbersByRecursion(1,0,n,solu);
    	return solu;
    }
    
    public void numbersByRecursion(int curr,int k, int n , List<Integer> solu){
    	if(k<n){
    		int currmax = curr*10-1;
    		int currmin = curr;
    		for(int i = currmin ; i <= currmax;i++){
    			solu.add(i);
    		}
    		numbersByRecursion(curr*10,k+1,n,solu);
    	}
    	
    			
    }
}
