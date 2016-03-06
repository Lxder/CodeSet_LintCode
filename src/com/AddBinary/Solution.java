package com.AddBinary;
public class Solution {
	public static void main(String args[]){
		Solution s = new Solution();
		System.out.println(s.addBinary("1", "11111"));
	}
	
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        // Write your code here
    	StringBuffer sb = new StringBuffer();
    	int tri = 0;
    	int lena = a.length();
    	int lenb = b.length();
    	int ia=lena-1;
    	int ib=lenb-1 ;
    	for( ; ia >=0 && ib >=0 ; ia-- , ib--){
    		int na = a.charAt(ia)-'0';
    		int nb = b.charAt(ib)-'0';
    		int c = na + nb + tri;
    		if(c <= 1){
    			sb.append(c);
    			tri = 0;
    		}else if(c == 2){
    			sb.append(0);
    			tri = 1;
    		}else {
    			sb.append(1);
    			tri = 1;
    		}
    	} 
    	while( ia >= 0){
    		int c = a.charAt(ia)-'0' + tri;
    		if(c <= 1){
    			sb.append(c);
    			tri = 0;
    		}else if(c == 2){
    			sb.append(0);
    			tri = 1;
    		}
    		ia--;
    	}
    	while( ib >= 0){
    		int c = b.charAt(ib)-'0' + tri;
    		if(c <= 1){
    			sb.append(c);
    			tri = 0;
    		}else if(c == 2){
    			sb.append(0);
    			tri = 1;
    		}
    		ib--;
    	}
    	if(tri == 1)
    		sb.append(1);
    	return sb.reverse().toString();
    }
}