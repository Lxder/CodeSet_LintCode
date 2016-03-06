package stage203.fibonacci;
class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
	public static void main(String args[]){
		System.out.println(fibonacci(10));
	}
    public static int fibonacci(int n) {
        // write your code here
    	if(n==1) return 0;
    	if(n==2) return 1;
    	int a = 0 ;
    	int b = 1 ;
    	int solu =0 ;
    	for(int i = 2 ; i <n ; i++){
    		solu  = a + b;
    		System.out.println(solu);
    		a = b ;
    		b = solu;
    	}
    	return solu;
    }
}


