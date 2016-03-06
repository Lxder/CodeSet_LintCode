package com.SegmentTreeBuildii;

class SegmentTreeNode {
	public int start, end, max;
	public SegmentTreeNode left, right;

	public SegmentTreeNode(int start, int end, int max) {
         this.start = start;
         this.end = end;
         this.max = max;
         this.left = this.right = null;
     }
}

public class Solution {

	public SegmentTreeNode build(int[] A) {
		// write your code here
		if(A==null)
			return null;
		return helper(A,0,A.length-1);
		
	}
	
	public SegmentTreeNode helper(int[] A , int st , int ed){
		if(st == ed){
			return new SegmentTreeNode(st,ed,A[st]);			
		}else if(st > ed) {
			return null;
		}else{
			SegmentTreeNode temp = new SegmentTreeNode(st,ed,0);
			int mid = (st+ed)/2;
			SegmentTreeNode lf = helper(A,st,mid);
			SegmentTreeNode rg = helper(A,mid+1,ed);
			temp.max = Math.max(lf.max, rg.max);
			temp.left = lf;
			temp.right = rg;
			return temp;
		}
	}
}