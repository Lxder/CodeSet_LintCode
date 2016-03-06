package stage609.SingleNumberii;


public class Solution {
	public static void main(String args[]){
		int[] A =  { 1,1,2,3,3,3,2,2,400,1};
		System.out.println(new Solution().singleNumberII(A));
	}
	
    public int singleNumberII(int[] A) {
        // write your code here
    	int len = A.length;
    	int temp ;
    	int solu = 0;
    	//求每一位数的和
    	for(int i = 0 ; i < 32 ; i++){
    		temp = 0;
    		for(int j = 0 ; j < len ; j++){
    			temp = temp+((A[j]>>i)&1);
    		}
    		solu = solu+ ((temp%3)<<i);
    	}
    	
    	return solu;
    }
}
