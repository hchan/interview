package com.henry.interview;

// https://www.educative.io/m/level-order-traversal-binary-tree
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LevelOrderTraversalBinaryTree {

	public static void main(String[] args) {
		LevelOrderTraversalBinaryTree soln = new LevelOrderTraversalBinaryTree();
		
		//Integer[] nums = new Integer[] {3,9,20,null,null,15,7};
		Integer[] nums = new Integer[] {3,9,3,1,null,15,7, 34, 22};
		//Integer[] nums = new Integer[] {3,9,20};
		TreeNode root = soln.createTreeNode(nums);
		
		flexPrint(soln.levelOrder(root));
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}
		
		
		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public TreeNode createTreeNode(Integer[] nums) {
		if (nums.length == 0 && nums[0] != null) {
			return null;
		}
		TreeNode root = new TreeNode(nums[0]);
		
		Queue<TreeNode> q = new LinkedList();
		q.add(root);
		
		int counter = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (counter < nums.length) {
					if (nums[counter] != null) {
						TreeNode left = new TreeNode(nums[counter]);
						node.left = left;
						q.add(node.left);
						
					} 
					counter++;
				}
				if (counter < nums.length ) {
					if (nums[counter] != null) {
						TreeNode right = new TreeNode(nums[counter]);
						node.right = right;
						q.add(node.right);
					}
					counter++;
				}
			}
		}
		return root;
	}

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> list = new ArrayList();
		if (root == null)
			return list;
		Queue<TreeNode> q = new LinkedList();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> l = new ArrayList();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				l.add(node.val);
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
			list.add(l);
		}
		return list;
	}

	// Henry's helper methods for printing
	public static void flexPrint(Object o) {
		flexPrint(null, o);
	}

	public static void flexPrint(String tag, Object o) {
		if (tag == null) {
			tag = "flexPrint ";
		}
		System.out.print(tag + " : ");
		if (o == null) {
			System.out.println("null");
			return;
		}
		if (o instanceof List) {
			List list = (List) o;
			System.out.println(Arrays.toString(list.toArray()));
		} else if (o.getClass().isArray()) {
			try {
				System.out.println(Arrays.toString((Object[]) o));
			} catch (Exception e) {
				try {
					int[] primitives = (int[]) o;
					Integer[] wrapped = Arrays.stream(primitives).boxed().toArray(Integer[]::new);
					System.out.println(Arrays.toString(wrapped));
				} catch (Exception e2) {
					try {
						char[] primitives = (char[]) o;
						System.out.println(Arrays.toString(primitives));
					} catch (Exception e3) {
						float[] primitives = (float[]) o;
						System.out.println(Arrays.toString(primitives));
					}
				}
			}
		} else {
			System.out.println(o);
		}
	}
}
