package com.TopologicalSorting;

import java.util.ArrayList;
import java.util.HashMap;
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
	public static void main(String[] args){
		DirectedGraphNode n1 = new DirectedGraphNode(1);
		DirectedGraphNode n2 = new DirectedGraphNode(2);
		n1.neighbors.add(n2);
		ArrayList<DirectedGraphNode> graph = new ArrayList<DirectedGraphNode>();
		graph.add(n1);
		graph.add(n2);
		ArrayList<DirectedGraphNode> solu = new Solution().topSort(graph);
		
				
		
		
	}
	/**
	 * @param graph
	 *            : A list of Directed graph node
	 * @return: Any topological order for the given graph.
	 */
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
		ArrayList<DirectedGraphNode> solu = new ArrayList<DirectedGraphNode>();
		HashMap<DirectedGraphNode,Integer> map = new HashMap<DirectedGraphNode,Integer>();
		
		

		for(DirectedGraphNode node : graph){ //对图中每一个节点
			for(DirectedGraphNode neighbor : node.neighbors){ //获取每个节点的neighbors，并对每个邻居进行处理
				//统计被人指向的次数
				if(map.containsKey(neighbor)){
					map.put(neighbor, map.get(neighbor)+1); 
				}else{ 
					map.put(neighbor,1);
				}
			}
		}
		
		Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
		for(DirectedGraphNode node : graph){
			//对图中每一个节点
			//如果map中不包含node,说明没有被任何人指向，可直接加入solu,并将该节点加入queue进行进一步处理
			if(!map.containsKey(node)){
				queue.offer(node);
				solu.add(node);
			}
		}
		//队列不为空
		while(!queue.isEmpty()){
			DirectedGraphNode node = queue.poll();
			for(DirectedGraphNode n :node.neighbors){ //获取节点的neighbors列表,对每个节点进行处理
				map.put(n, map.get(n)-1);
				if(map.get(n) == 0){ //如果该节点不被他人指向，则加入到solu，并且加入queue
					solu.add(n);
					queue.offer(n); 
				}
			}
		}
		return solu;
	}
}