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
    	long iCount = 0;  //i�ĸ���
		long iFactor = 1;
		
		long iLowerNum = 0;
		int iCurrNum = 0;
		long iHigherNum = 0;
		
		while(n/iFactor !=0){
			iLowerNum = n%(iFactor); //���������������
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
    
	//���� ����10134�������0~10134����1�ĸ���
	//��λ1�ĸ�����(1013+1)*1
	//ʮλ1�ĸ�����(101+1)*10
	//��λ1�ĸ�����10*100+34+1
	//ǧλ1�ĸ�����1*1000  (ʵ��Ϊ��01000��01999,��λΪ1�Ķ�������)
	//��λ1�ĸ�����0*10000+134+1 (�Ѿ������λ�ˣ�iHigherNum=0)
    
};

