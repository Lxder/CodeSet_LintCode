package com.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

class Interval {
     int start, end;
     Interval(int start, int end) {
         this.start = start;
         this.end = end;
    }
}

public class Solution {
	public static void main(String args[]){
		Interval i1 = new Interval(1,3);
		Interval i2 = new Interval(1,3);
		Interval i3 = new Interval(8,10);
		Interval i4 = new Interval(15,18);
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(i4);
		intervals.add(i3);
		intervals.add(i2);
		intervals.add(i1);
		List<Interval> solu = new Solution().merge(intervals);
		for(Interval i : solu){
			System.out.println(i.start + " " + i.end);
		}
	}
    /**
     * @param intervals: Sorted interval list.
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
    	if(intervals == null) return null;
    	int len = intervals.size();
    	mergeSort(intervals,0,len-1);
    	for(int i = 1 ; i < len ;){
    		if(intervals.get(i-1).end>=intervals.get(i).start){
    			intervals.get(i-1).end = Math.max(intervals.get(i-1).end, intervals.get(i).end);
    			intervals.remove(i);
    			len--;
    		}else{
    			i++;
    		}
    	}
    	return intervals;
    	
    }
    
    public void mergeSort(List<Interval> intervals, int st , int ed){
    	if(st>=ed) return ;
    	Interval pati = intervals.get(st);
    	int l = st;
    	int r = ed;
    	while(l<r){
    		while(l<r && intervals.get(r).start >= pati.start){
    			r--;
    		}
    		intervals.set(l, intervals.get(r));
    		while(l<r && intervals.get(l).start <= pati.start){
    			l++;
    		}
    		intervals.set(r, intervals.get(l));
    	}
    	intervals.set(l, pati);
    	mergeSort(intervals,st,l-1);
    	mergeSort(intervals,l+1,ed);
    }

}