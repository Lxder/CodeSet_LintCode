package com.anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public static void main(String[] args){
		String[] strs = {"","","b"};
		System.out.println(new Solution().anagrams(strs));
	}
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        
        List<String> solu = new ArrayList<String>();
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        for(String s: strs){
            int[] iarr = new int[26];
            char[] carr = s.toCharArray();
            for(char c:carr){
                iarr[c-'a']++;
            }
            StringBuffer sb =new StringBuffer();
            for(int i = 0 ; i < 26 ; i ++){
                while(iarr[i]!=0){
                    sb.append('a'+i);
                    iarr[i]--;
                }
            }
            String sortedstr = sb.toString();
            if(!map.containsKey(sortedstr)){
                List<String> clist = new ArrayList<String>();
                clist.add(s);
                map.put(sortedstr,clist);
            }else{
                map.get(sortedstr).add(s);
            }
        }
        for(List<String> clist : map.values()){
            if(clist.size()>1){
                solu.addAll(clist);
            }
        }
        return solu;
    }
}