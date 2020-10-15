package com.henry.interview;

import java.util.*;

// https://leetcode.com/problems/clone-graph/
public class CloneGraph {
	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	public Node cloneGraph(Node node) {
		// Iterate nodes
		List<Integer> nodes = new ArrayList<Integer>();
		HashMap<Integer, Node> cloneByValue = new HashMap<>();
		return doClone(node, cloneByValue);
	}

	public Node doClone(Node original, HashMap<Integer, Node> cloneByValue) {
		Node clone = null;
		if (original != null) {
			clone = new Node(original.val);
			cloneByValue.put(clone.val, clone);
			for (Node n : original.neighbors) {
				if (cloneByValue.containsKey(n.val)) {
					clone.neighbors.add(cloneByValue.get(n.val));
				} else {
					clone.neighbors.add(doClone(n, cloneByValue));
				}
			}
		}
		return clone;

	}
}
