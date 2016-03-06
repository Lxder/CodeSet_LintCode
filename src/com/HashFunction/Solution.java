package com.HashFunction;
public class Solution {
	
	public static void main(String args[]){
		char[] key = {'a','b','c','d'};
		System.out.println(new Solution().hashCode(key,100));
	}
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here	
    	int len = key.length;
    	long solu = 0;
    	for(int i = len-1 , n =0 ; i >= 0 ; i--,n++){
    		long temp =1;
    		temp =  getNK(33,i,HASH_SIZE);    		
    		solu  = solu + temp * key[n]%HASH_SIZE;
    	}
    	solu %= HASH_SIZE;
    	return (int) solu;
    }
    
    
    public long getNK(int n , int k , int size){
    	if( k == 0 ) return 1 ;
    	long half = getNK(n,k/2,size)%size;
    	if(k%2 ==0){
    		return half * half % size;
    	}else{
    		return half * half % size * n %size;
    	}    	
    }
    
    
};