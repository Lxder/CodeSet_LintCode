package stage505.DigitCounts;
class Solution {
	
	public static void main(String args[]){
		System.out.println(digitCounts(1,10134));
	}
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public static int digitCounts(int k, int n) {
        // write your code here
    	long iCount = 0;  //i的个数
		long iFactor = 1;
		
		long iLowerNum = 0;
		int iCurrNum = 0;
		long iHigherNum = 0;
		
		while(n/iFactor !=0){
			iLowerNum = n%(iFactor); //利用了整数的误差
			iCurrNum = (int)(n/iFactor)%10;
			iHigherNum=n/(iFactor*10);
			if(iCurrNum<k){
				iCount += iHigherNum*iFactor ; 
			}else if(iCurrNum==k){
				iCount += iHigherNum*iFactor+iLowerNum+1;
			}else{
				iCount += (iHigherNum+1)*iFactor;
			}
			
			iFactor*=10;
		}		
		return (int)iCount;
    	
		
    }
    
	//例如 数字10134，计算从0~10134共有1的个数
	//个位1的个数：(1013+1)*1
	//十位1的个数：(101+1)*10
	//百位1的个数：10*100+34+1
	//千位1的个数：1*1000  (实际为从01000到01999,万位为1的都不可能)
	//万位1的个数：0*10000+134+1 (已经到最高位了，iHigherNum=0)
    
};

