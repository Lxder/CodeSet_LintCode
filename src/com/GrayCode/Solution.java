package com.GrayCode;

import java.util.ArrayList;

public class Solution {
    /**
     * @param n a number
     * @return Gray code
     */
    public ArrayList<Integer> grayCode(int n) {
    	ArrayList<Integer> solu = new ArrayList<Integer>();
    	int num = 1<<n;
    	for(int i =0 ; i < num ; i++){
    		int curr = (i>>1) ^ i;
    		solu.add(curr);
    	}
    	return solu;    	
    }
    //格雷码生成： 首先将原数字改为二进制，第一位不变，第二位为原数字 第一位^第二位,后面的类推
}