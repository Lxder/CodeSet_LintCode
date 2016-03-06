package com.SimplifyPath;

import java.util.ArrayList;

public class Solution {
	public static void main(String args[]){
		String path = "/home//foo/";
		String solu = new Solution().simplifyPath(path);
		System.out.println(solu);
	}
    /**
     * @param path the original path
     * @return the simplified path
     */
    public String simplifyPath(String path) {
        // Write your code here
    	String[] parr = path.split("/+");
    	ArrayList<String> solulist = new ArrayList<String>();
    	for(String s: parr){
    		if(s.equals("")||s.equals(".")){
    			continue;
    		}else if(s.equals("..") ){
    			if(solulist.size()!=0)
    				solulist.remove(solulist.size()-1);
    		}else{
    			solulist.add(s);
    		}
    	}
    	if(solulist.size()==0) return "/";
    	StringBuffer sb = new StringBuffer();
    	for(String s : solulist){
    		sb.append("/");
    		sb.append(s);
    	}
    	return sb.toString();
    }
}