package com.DecodeWays;
public class Solution {
	public static void main(String[] args){
		System.out.println(new Solution().numDecodings("11111878787676172120121101212918291829819"));
	}
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
	
	//分如下几种情况：
	/*
	 * 1.长度为0	||开头为0：返回0
	 * 2.长度为1
	 * 2.1 只有一个0 	： 返回0
	 * 2.2 其他数字	：返回1
	 * 3.长度为2
	 * 3.1 11~26 返回2
	 * 3.2 10，27~99 返回1
	 * 4.长度大于2
	 * 4.1当前为0 &&（前一个为0 || 前一个大于等于3）	：返回0
	 * 4.2(前一个'1' || 前一个为'2'且当前<='6')&&当前大于'0' ： dp[idx] = dp[idx-1] + dp[idx-2];
	 * 4.3否则
	 * 4.3.1当前为0：dp[idx] = dp[idx-2];
	 * 4.3.2当前不为0：dp[idx] = dp[idx-1];
	 * 
	 * 最终结果返回dp[len-1]
	 * */
    public int numDecodings(String s) {
        // Write your code here
    	int len = s.length();
    	if(len ==0 ||s.charAt(0)=='0') return 0;
    	if(len == 1) return 1;
    	
    	int[] dp = new int[len];
    	dp[0] = 1;
    	char c1 = s.charAt(1);
    	if((s.charAt(0)=='1' || s.charAt(0)=='2' && c1 <= '6') && c1>'0'){
    		dp[1] = 2 ;
    	}else{
    		dp[1] = 1;
    	}    	
    	
    	int idx = 2;
    	while(idx < len){
    		char curchar = s.charAt(idx);
    		char prechar = s.charAt(idx-1);
    		if(curchar=='0' && (prechar=='0'||prechar>='3')){
    			return 0;
    		}
    		
    		if((prechar == '1' || (prechar =='2' && curchar <='6') ) && curchar>'0'){
    			dp[idx] = dp[idx-1] + dp[idx-2];
    		}else{
    			if(curchar == '0'){
    				dp[idx] = dp[idx-2];
    			}else{
    				dp[idx] = dp[idx-1];
    			}
    		}
    		idx++;
    	}
    	for(int i= 0 ; i < len ; i ++){
    		System.out.println(s.charAt(i)+" "+dp[i]);
    	}
    	return dp[len-1];
    }
}