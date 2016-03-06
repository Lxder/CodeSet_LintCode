package com.NumberofAirplanesinTheSky;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

class Interval {
	int start, end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

}

public class Solution {
	public static void main(String args[]){
		Interval i0 = new Interval(1,10);
		Interval i1 = new Interval(2,3);
		Interval i2 = new Interval(5,8);
		Interval i3 = new Interval(4,7);
		List<Interval> airplanes = new ArrayList<Interval>();
		airplanes.add(i0);
		airplanes.add(i1);
		airplanes.add(i2);
		airplanes.add(i3);
		Solution s = new Solution();
		System.out.println(s.countOfAirplanes(airplanes));
		
	}
	
	public int countOfAirplanes(List<Interval> airplanes) {
		// write your code here
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		TreeSet<Integer> set = new TreeSet<Integer>(); 
		int maxnum = 0;
		
		for(Interval itr : airplanes){
			if(map.get(itr.start)==null){
				map.put(itr.start,1);
			}else{
				map.put(itr.start,map.get(itr.start)+1);
			}
			
			if(map.get(itr.end)==null){
				map.put(itr.end,-1);
			}else{
				map.put(itr.end,map.get(itr.end)-1);
			}
			
			set.add(itr.start);
			set.add(itr.end);			
		}
		int cur = 0;
		for(Integer i : set){
			cur+=map.get(i);
			maxnum = Math.max(cur, maxnum);
		}
		return maxnum;
		
	}

}