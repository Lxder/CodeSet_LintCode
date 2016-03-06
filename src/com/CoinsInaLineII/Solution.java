package com.CoinsInaLineII;
public class Solution {
	
	public static void main(String args[]){
		
		int[] values = {5,1,6};
		Solution s = new Solution();
		System.out.println(s.firstWillWin(values));
	}
	
	/**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
	//n����ͬ��ֵӲ�ң������������1��������Ӳ�ң��ܼ۸��߻�ʤ���̵����1�Ƿ��ʤ
	
	//dp[i]��dp[i-1]  dpd[i-2]�й�
	//��dp[i] ��ʾ����i��Ӳ��ʱʹ��������������״̬��
    public boolean firstWillWin(int[] values) {
    	int len = values.length;
    	if(len < 2) return true;
    	int[] dp1 = new int[len];
    	int[] dp2 = new int[len];
    	
    	dp1[len-1] = values[len-1];
    	dp2[len-1] = 0;
    	
    	dp1[len-2] = values[len-2];
    	dp2[len-2] = 0;
    	
    	for(int i = len-3 ; i>=0 ; i--){
    		if(dp2[i+1] + values[i] > dp2[i+2]+values[i] + values[i+1]){
    			dp1[i] = dp2[i+1]+values[i];//���1����1��������ı��������2��һ�εĲſ��Ա�֤��
    			dp2[i] = dp1[i+1];//���2����һ�����1�õ�
    		}else{
    			//���1����2����������������2���ϴβſ��Ա�֤���
    			//(���2���ϴεĽ���ض������1���ã�1����2����֮�����õģ�
    			//��˲���Ҫ�ж��Ƿ������õ���������2������Ϊ�Ѿ������1������)
    			dp1[i] = dp2[i+2]+values[i]+ values[i+1]; 
    			dp2[i] = dp1[i+2];//���2�����1���ϴε�
    		}
    	}
    	for(int i = 0 ; i < len ; i++){
    		System.out.print(dp1[i]+"\t");    		
    	}
    	System.out.println();
    	for(int i = 0 ; i < len ; i++){
    		System.out.print(dp2[i]+"\t");    		
    	}
    	return dp1[0] > dp2[0];
    }    
}

/*
		int n = values.size();  
        if(n<=2)  
            return true;  
        vector<pair<int,int> > dp(n,make_pair(0,0));  
        dp[n-1] = make_pair(values[n-1],0);  
        dp[n-2] = make_pair(values[n-1]+values[n-2],0);  
        for(int i=n-3;i>=0;i--)  
        {  
            pair<int,int> p1 = dp[i+1];  
            pair<int,int> p2 = dp[i+2];  
            if(p1.second+values[i]>p2.second+values[i]+values[i+1])  
            {  
                dp[i] = make_pair(p1.second+values[i],p1.first);  
            }  
            else  
            {  
                dp[i] = make_pair(p2.second+values[i]+values[i+1],p2.first);  
            }  
        }  
        return dp[0].first>dp[0].second;  
 */
