package stage504.UglyNumber;
class Solution {
	public static void main(String args[]){
		System.out.println(kthPrimeNumber(4));
	}
	
	/**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public static long kthPrimeNumber(int k) {
        // write your code here
    	long[] ugly = new long[k+1];
    	ugly[0] = 1;
    	int index3 = 0 , index5 =0 , index7 = 0;
    	long cur3 = 3 , cur5 = 5 , cur7 = 7;
    	for(int i  = 1 ; i <= k ; i++){
    		long curmin = Math.min(Math.min(cur3, cur5), cur7); //找到最小的
    		ugly[i] = curmin;
    		if(cur3==curmin) {cur3=ugly[++index3]*3 ;}
    		if(cur5==curmin) {cur5=ugly[++index5]*5 ;}
    		if(cur7==curmin) {cur7=ugly[++index7]*7 ;}
    		
    	}
    	
    	return ugly[k];     	
    }
    
    
};

