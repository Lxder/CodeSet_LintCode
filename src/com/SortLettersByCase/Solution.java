package com.SortLettersByCase;
public class Solution {
	public static void main(String args[]){
		Solution s = new Solution();
		String str = "GklvKvqYhGEMvhwNoAzAsxPRbhSizddZdKjrDEdGWykxmBCrVasurDQdleokwcpKFPQSNxzyzdmDEpksncKsgigFfLLHKlShehruoUnNpvAauasokVvgNgZpOjdzpGmsJpxtnEeqfoNyknndYPQErfGkZedhcdwplfqjekPXbolByOmyinuuqYSgGfaLOxWczusKWLfcsUoakTlVtsqfNQKbGnrdVkHqGgVoRUcsVytDredjSmDMcxxPaMHbwOLmKvWUrxcoUtkUcYtbBoCqbLOaMCFbtmwKeJnrMEWenAVMWQsobLENzgkSmWrxMtdHbZLXixstfdDzWXhdUbScskssozOEMKhtjJXiRziiBATyQKPzSKFfWauqzxlZCutCvQteLgmostYIYxpyplNRvedLmppzvIzLtkMOqvgLTErvSrRggIzuVvMCwZkujflaoakvGdZQimnTqaiMSkoCPpzcpAEdwuYJrFHDEnUIuywXvArbLbaycCkzzfRsFdCgrKuPmEvapdwgZSVloJaLIbkqhvkwcefgfTaphsXzuFozPBpFwHyjlvktiBEgbgvmoHzzJycgOtBDpnpxglBbwXhggnjBblIcsHgJY";
		char[] chars = str.toCharArray();
		
		
		s.sortLetters(chars);
		for(char c: chars){
			System.out.print(c);
		}
	}
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
    	int len = chars.length;
    	int[] nums = new int[200];
    	for(int i = 0 ; i < len ; i++){
    		nums[chars[i]]++;
    	}
    	int index = 0;
    	
    	for(int i = 'a' ; i <= 'z' ; i++){
    		while(nums[i]>0){
    			nums[i]--;
    			chars[index] = (char)i;
    			index++;
    		}
    	}
    	for(int i = 'A' ; i <= 'Z' ; i++){
    		while(nums[i] >0){
    			nums[i]--;
    			chars[index] = (char) i;
    			index ++;
    		}
    	}
    }
}
