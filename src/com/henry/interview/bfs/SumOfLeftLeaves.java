package com.henry.interview.bfs;

import java.util.*;

import com.henry.interview.bfs.BreadthFirstSearch.TreeNode;

// https://leetcode.com/problems/sum-of-left-leaves/
// Runtime: O(n);
// Space  : O(n) worst case have to add all to the queue
public class SumOfLeftLeaves {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode() {
		}

		public TreeNode(int val) {
			this.val = val;
		}

		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		SumOfLeftLeaves soln = new SumOfLeftLeaves();
		TreeNode root = new TreeNode(3);
		TreeNode nine = new TreeNode(9);
		TreeNode twenty = new TreeNode(20);
		TreeNode fifteen = new TreeNode(15);
		TreeNode seven = new TreeNode(7);
		root.left = nine;
		root.right = twenty;
		twenty.left = fifteen;
		twenty.right = seven;

		System.out.println(soln.sumOfLeftLeaves(root));
	}

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;
		int retval = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.clear();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			// System.out.println("data : " + node.data);
			// if(node.left != null) queue.add(node.left);
			// if(node.right != null) queue.add(node.right);
			if (node.left != null && isLeaf(node.left)) {
				retval += node.left.val;
			
			}
			
			if (node.left != null) {
				queue.add(node.left);
			}
			
			if (node.right != null) {
				queue.add(node.right);
			}
		}
		return retval;
	}
	
	public boolean isLeaf(TreeNode node) {
		if (node == null) return false;
		return (node.left == null && node.right == null);
	}
}
