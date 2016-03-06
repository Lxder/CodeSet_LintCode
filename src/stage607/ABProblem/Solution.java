package stage607.ABProblem;
class Solution {
	
	public static void main(String args[]){
		System.out.println(new Solution().aplusb(1,2));
	}
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        int ans;  
        while(b!=0)   {   //ֱ��û�н�λ  
            ans = a^b;        //������λ�ӷ�  
            b = ((a&b)<<1);   //��λ  
            a = ans;  
        }  
        return a;  
     }
};
