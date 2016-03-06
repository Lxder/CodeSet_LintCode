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
	//n个不同价值硬币，从左边依次拿1个或两个硬币，总价高者获胜。盘点玩家1是否获胜
	
	//dp[i]和dp[i-1]  dpd[i-2]有关
	//用dp[i] 表示到第i个硬币时使得先手数量最大的状态。
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
    			dp1[i] = dp2[i+1]+values[i];//玩家1先拿1个，后面的必须拿玩家2上一次的才可以保证大
    			dp2[i] = dp1[i+1];//玩家2拿上一轮玩家1拿的
    		}else{
    			//玩家1先拿2个，后面必须拿玩家2上上次才可以保证最大
    			//(玩家2上上次的结果必定是玩家1先拿（1个或2个）之后再拿的，
    			//因此不需要判断是否连续拿的数量大于2个，因为已经被玩家1隔开了)
    			dp1[i] = dp2[i+2]+values[i]+ values[i+1]; 
    			dp2[i] = dp1[i+2];//玩家2拿玩家1上上次的
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
