package stage210.climbingstairs;
public class Solution {
	
	public static void main(String args[]){
		System.out.println(climbStairs(5));
	}
    /**
     * @param n: An integer
     * @return: An integer
     */
    public static int climbStairs(int n) {
        // write your code here
    	if(n<=2) return n;
    	int a1 = 1 ; 
    	int a2 = 2;
    	int num = 0;
    	for(int i = 3;  i<=n ; i++){
    		num = a1+a2;
    		a1 = a2 ;
    		a2 = num;
    	}
    	return num;
    	
    }
}