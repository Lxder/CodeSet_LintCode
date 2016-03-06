package com.LongestWords;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        // write your code here
    	if(dictionary == null)
    		 return new ArrayList<String>();
    	int maxlen = 0;
    	HashMap<Integer,ArrayList<String>> map = new HashMap<Integer,ArrayList<String>>();
    	for(int i = 0 ; i < dictionary.length ; i++){
    		int len = dictionary[i].length();
    		if (len > maxlen) maxlen = len ;
    		if(map.containsKey(len)){
    			map.get(len).add(dictionary[i]);
    		}else{
    			ArrayList<String> calist = new ArrayList<String>();
    			calist.add(dictionary[i]);
    			map.put(len, calist);
    		}
    	}
    	return map.get(maxlen);
    	
    }
};