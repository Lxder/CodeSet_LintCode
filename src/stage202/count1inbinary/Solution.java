package stage202.count1inbinary;
public class Solution {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
	public static void main(String args[]){
		System.out.println(countOnes(1023));
	}
    public static int countOnes(int num) {
        // write your code here
    	int numofone = 0;
    	while(num!=0){
    		if((num&1)==1)
    			numofone++;
    		num=num>>1;
    	}
    	return numofone;
    }
};
