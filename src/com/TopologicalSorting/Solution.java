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
		
		

		for(DirectedGraphNode node : graph){ //��ͼ��ÿһ���ڵ�
			for(DirectedGraphNode neighbor : node.neighbors){ //��ȡÿ���ڵ��neighbors������ÿ���ھӽ��д���
				//ͳ�Ʊ���ָ��Ĵ���
				if(map.containsKey(neighbor)){
					map.put(neighbor, map.get(neighbor)+1); 
				}else{ 
					map.put(neighbor,1);
				}
			}
		}
		
		Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
		for(DirectedGraphNode node : graph){
			//��ͼ��ÿһ���ڵ�
			//���map�в�����node,˵��û�б��κ���ָ�򣬿�ֱ�Ӽ���solu,�����ýڵ����queue���н�һ������
			if(!map.containsKey(node)){
				queue.offer(node);
				solu.add(node);
			}
		}
		//���в�Ϊ��
		while(!queue.isEmpty()){
			DirectedGraphNode node = queue.poll();
			for(DirectedGraphNode n :node.neighbors){ //��ȡ�ڵ��neighbors�б�,��ÿ���ڵ���д���
				map.put(n, map.get(n)-1);
				if(map.get(n) == 0){ //����ýڵ㲻������ָ������뵽solu�����Ҽ���queue
					solu.add(n);
					queue.offer(n); 
				}
			}
		}
		return solu;
	}
}