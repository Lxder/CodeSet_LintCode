package com.RouteBetweenTwoNodesInGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class DirectedGraphNode {
	int label;
	ArrayList<DirectedGraphNode> neighbors;

	DirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<DirectedGraphNode>();
	}
};

public class Solution {
	public static void main(String args[]){
		//{0,1,2,3,4#1,3,4#2,1,4#3,4#4}, 4, 1
	}
	/**
	 * @param graph
	 *            : A list of Directed graph node
	 * @param s
	 *            : the starting Directed graph node
	 * @param t
	 *            : the terminal Directed graph node
	 * @return: a boolean value
	 */
	public boolean hasRoute(ArrayList<DirectedGraphNode> graph,
			DirectedGraphNode s, DirectedGraphNode t) {
		
		Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
		HashSet<DirectedGraphNode> set = new HashSet<DirectedGraphNode>();
		
		queue.add(s);
		while(!queue.isEmpty()){
			DirectedGraphNode curr = queue.poll(); //获取队头元素
			if(curr == t) return true;
			ArrayList<DirectedGraphNode> neighb_list = curr.neighbors;
			
			for(DirectedGraphNode neigb : neighb_list){ 
				if(!set.contains(neigb)){ //将没有处理过的邻居加入队尾
					queue.add(neigb);
				}
			}
		}
		return false;
	}
}