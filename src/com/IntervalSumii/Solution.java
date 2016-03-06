package com.IntervalSumii;

public class Solution {
	public static void main(String args[]){
		int[] A = {1,2,7,8,5};
		Solution s = new Solution(A);
		System.out.println(s.query(1, 2));
		
	}
	
	/* you may need to use some attributes here */
	SegmentTreeNode sgt ;

	/**
	 * @param A
	 *            : An integer array
	 */
	public Solution(int[] A) {
		// write your code here
		sgt = build(A,0,A.length-1);
	}
	public SegmentTreeNode build(int[] A , int start , int end){
		if(start > end) return null;
		SegmentTreeNode root = new SegmentTreeNode(start ,end);
		if(start == end){
			root.sum = A[start];
			return root;
		}
		int mid = (start + end) /2;
		root.left = build(A,start,mid);
		root.right = build(A,mid+1,end);
		root.sum = root.left.sum+ root.right.sum;
		return root;
	}

	/**
	 * @param start
	 *            , end: Indices
	 * @return: The sum from start to end
	 */
	public long query(int start, int end) {
		return queryHelper(sgt,start,end);
		
	}
	public long queryHelper(SegmentTreeNode root, int start, int end){
		if(root == null||start>end) return 0;
		if(start ==root.start && end == root.end){
			return root.sum;
		}
		int mid = (root.start+root.end)/2;
		if(end <= mid){
			return queryHelper(root.left,start,end);
		}else if(start > mid){
			return queryHelper(root.right,start,end);
		}else{
			long l = queryHelper(root.left,start,mid);
			long r = queryHelper(root.right,mid+1,end);
			return l+r;
		}
	}

	/**
	 * @param index
	 *            , value: modify A[index] to value.
	 */
	public void modify(int index, int value) {
		// write your code here
		modifyHelper(sgt,index,value);
	}
	
	public void modifyHelper(SegmentTreeNode root, int index, int value){
		if(root.start == index && root.end == index){
			root.sum = value;
		}else{
			int mid = (root.start + root.end)/2;
			if(index <= mid){
				modifyHelper(root.left,index,value);
			}else{
				modifyHelper(root.right,index,value);
			}
			root.sum = root.left.sum + root.right.sum;
		}
	}
}

class SegmentTreeNode {
	int start, end;
	SegmentTreeNode left, right;
	long sum;

	public SegmentTreeNode(int start, int end) {
		this.start = start;
		this.end = end;
		this.left = this.right = null;
	}
}
