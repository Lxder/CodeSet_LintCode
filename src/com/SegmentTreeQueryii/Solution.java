package com.SegmentTreeQueryii;


class SegmentTreeNode {
	public int start, end, count;
	public SegmentTreeNode left, right;

	public SegmentTreeNode(int start, int end, int count) {
		this.start = start;
		this.end = end;
		this.count = count;
		this.left = this.right = null;
	}
}

public class Solution {
	public static void main(String args[]){
		Solution s = new Solution();
		int[] A = {1,0,1,0,0,0,0,0,0,0,0,0,0,0,1};
		int start = 0;
		int end = 14;
		SegmentTreeNode root = s.build(A,start , end);
		System.out.println(s.query(root,8,16));
	}
	
	/**
	 * @param root
	 *            , start, end: The root of segment tree and an segment /
	 *            interval
	 * @return: The count number in the interval [start, end]
	 */
	public int query(SegmentTreeNode root, int start, int end) {
		if(start <root.start) start = root.start;
		if(end > root.end) end = root.end;
		return helper(root,start,end);
	}
	public int helper(SegmentTreeNode root, int start, int end){
		if(root == null||start>end) return 0;
		if(root.start == start && root.end ==end){
			System.out.println("½á¹û"+root.start + " "+root.end);
			return root.count;
		}
		int mid = (root.start + root.end) / 2 ;
		System.out.print(mid+"\t");
		if(end <= mid){
			System.out.println("×ó²à");
			return query(root.left,start,end);
		}else if(start > mid){
			System.out.println("ÓÒ²à");
			return query(root.right , start , end);
		}else{
			System.out.println("¿çÔ½");
			int lcount = query(root.left , start ,mid);
			int rcount = query(root.right , mid+1,end);
			System.out.println(lcount+" "+rcount);
			return lcount + rcount;
		}
	}
	
	 public SegmentTreeNode build(int[] A , int start , int end){
			if(start > end) return null;
			SegmentTreeNode root = new SegmentTreeNode(start ,end,0);
			if(start == end){
				root.count = A[start];
				return root;
			}
			int mid = (start + end) /2;
			root.left = build(A,start, mid);
			root.right = build(A,mid+1 , end);
			root.count = root.left.count+ root.right.count;
			return root;
	}
}