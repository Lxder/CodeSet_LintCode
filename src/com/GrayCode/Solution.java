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
    //���������ɣ� ���Ƚ�ԭ���ָ�Ϊ�����ƣ���һλ���䣬�ڶ�λΪԭ���� ��һλ^�ڶ�λ,���������
}