package com.IntervalMinimumNumber;

import java.util.ArrayList;

class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
}
public class Solution {
	public static void main(String args[]){
		int[] A ={1,2,7,8,5};
		Interval i1 = new Interval(1,2);
		Interval i2 = new Interval(0,4);
		Interval i3 = new Interval(2,4);
		ArrayList<Interval> queries = new ArrayList<Interval>();
		queries.add(i1);
		queries.add(i2);
		queries.add(i3);
		System.out.println(new Solution().intervalMinNumber(A, queries));
	}
	
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Integer> intervalMinNumber(int[] A,ArrayList<Interval> queries) {
    	int len = A.length;
    	SegmentTreeNode root = build(A,0,len-1);
    	ArrayList<Integer> solu = new ArrayList<Integer>();
    	for(Interval curr : queries){
    		int csolu = query(root,curr.start,curr.end);
    		solu.add(csolu);
    	}
    	return solu;
    }
    
    public SegmentTreeNode build(int[] A , int start , int end){
		if(start > end) return null;
		SegmentTreeNode root = new SegmentTreeNode(start ,end);
		if(start == end){
			root.min = A[start];
			return root;
		}
		int mid = (start + end) /2;
		root.left = build(A,start, mid);
		root.right = build(A,mid+1 , end);
		root.min = Math.min(root.left.min, root.right.min);
		return root;
	}
	
	public int query(SegmentTreeNode root,int start , int end){
		if(root.start == start && root.end == end){
			return root.min;
		}
		int mid = (root.start + root.end)/2;
		
		if(end <=mid){
			return query(root.left,start,end);
		}else if(start > mid){
			return query(root.right , start , end);
		}else{
			int lmin = query(root.left,start,mid);
			int rmin = query(root.right,mid+1,end);
			return Math.min(lmin, rmin);
		}
	}
}


class SegmentTreeNode{
	SegmentTreeNode left ,right;
	int start , end;
	int min;
	public SegmentTreeNode(int start , int end){
		this.start = start ; 
		this.end = end;
		this.left = null;
		this.right = null;
	}
}

