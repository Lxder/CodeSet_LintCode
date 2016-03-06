package com.SortColorsii;
class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
	public void sortColors22(int[] colors, int k) {
        // write your code here
    	
    	for(int i = 0 ; i < colors.length ; i ++){
    		while(colors[i] > 0){
    			int num = colors[i];
    			if(colors[num-1] > 0){
    				colors[i] = colors[num-1];
    				colors[num-1] =  -1;
    			}else{
    				colors[num-1] -=1;
    				colors[i] = 0;
    			}
    		}
    	}
    	int idx = colors.length-1;
    	for(int i = k-1 ; i >=0 ; i --){
    		int temp = colors[i];
    		while(temp < 0){
    			colors[idx] = i+1;
    			temp ++ ;
    			idx --;
    		}
    	}
    }
	
	
	public void sortColors2(int[] colors, int k) {
        // write your code here
    	int[] clr = new int[k+1];
    	for(int i = 0 ; i < colors.length ; i ++){
    		clr[colors[i]] ++;
    	}
    	
    	int idx = 0;
    	for(int i = 1 ; i <=k ; i ++){
    		while(clr[i]!=0){
    			colors[idx++] = i;
    			clr[i]--;
    		}
    	}
    }
}