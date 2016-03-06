package com.IntervalSum;

import java.util.ArrayList;

class Interval {
     int start, end;
     Interval(int start, int end) {
         this.start = start;
         this.end = end;
     }
 }
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Long> intervalSum(int[] A, ArrayList<Interval> queries) {
    	int len = A.length;
    	SegmentTreeNode root = build(A,0,len-1);
    	ArrayList<Long> solu = new ArrayList<Long>();
    	for(Interval curr : queries){
    		Long csolu = query(root,curr.start,curr.end);
    		solu.add(csolu);
    	}
    	return solu;
    	
    }
    public SegmentTreeNode build(int[] A , int start , int end){
		if(start > end) return null;
		SegmentTreeNode root = new SegmentTreeNode(start ,end);
		if(start == end){
			root.sum = A[start];
			return root;
		}
		int mid = (start + end) /2;
		root.left = build(A,start, mid);
		root.right = build(A,mid+1 , end);
		root.sum = root.left.sum+ root.right.sum;
		return root;
	}
	
	public long query(SegmentTreeNode root,int start , int end){
		if(root.start == start && root.end == end){
			return root.sum;
		}
		int mid = (root.start + root.end)/2;
		
		if(end <=mid){
			return query(root.left,start,end);
		}else if(start > mid){
			return query(root.right , start , end);
		}else{
			long lsum = query(root.left,start,mid);
			long rsum = query(root.right,mid+1,end);
			return lsum + rsum;
		}
	}
}


class SegmentTreeNode{
	SegmentTreeNode left ,right;
	int start , end;
	long sum;
	public SegmentTreeNode(int start , int end){
		this.start = start ; 
		this.end = end;
		this.left = null;
		this.right = null;
	}
}
