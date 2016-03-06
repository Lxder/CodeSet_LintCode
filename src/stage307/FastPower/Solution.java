package stage307.FastPower;

class Solution {
	public static void main(String args[]) {
		System.out.println(fastPower(2, 1, 2147483647));
		//System.out.println(PowerMod(2, 2147483647, 2147483647));
	}

	/*
	 * @param a, b, n: 32bit integers
	 * 
	 * @return: An integer
	 */

	public static int fastPower(int a,int b, int n){
		//if(b==1) return 0;
		long la = a;
		long ans = 1;
		la = la % b;
		while ( n > 0){
			if (n % 2 == 1)
				ans = (ans * la) % b;
			n = n / 2;
			la = (la * la) % b;
			
		}
		return (int)ans;
	}
	
	public static int PowerMod(int a, int b, int c)
	{
	  long ans = 1;
	  long aa=(long)a;
	  aa = aa % c;
	  while(b>0) {
		  System.out.println(ans+" "+aa+" "+ans*aa);
	    if(b % 2 == 1)
	    ans = (ans * aa) % c;
	    b = b/2;
	    
	    aa = (aa * aa) % c;
	    System.out.println(ans+" "+aa+" b "+b);
	  }
	  return (int)ans;
	}
}
