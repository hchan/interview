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

public class TraverseBinaryTree {

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode(100);
		TreeNode<Integer> fifty = new TreeNode(50);
		TreeNode<Integer> twoHundred = new TreeNode(200);
		TreeNode<Integer> twentyFive = new TreeNode(25);
		TreeNode<Integer> seventyFive = new TreeNode(75);
		TreeNode<Integer> threeHundredFifty = new TreeNode(350);
		root.children.add(fifty);
		root.children.add(twoHundred);
		fifty.children.add(twentyFive);
		fifty.children.add(seventyFive);
		twoHundred.children.add(threeHundredFifty);

		TraverseBinaryTree bfs = new TraverseBinaryTree();
		bfs.traverse(root);
		bfs.mapLevelToList.forEach((k, v) -> {
		
			for (TreeNode node : v) {
				System.out.print(node.data + " ");
			}
			System.out.println();
		});
		bfs.flexPrint(bfs.mapLevelToList);
		System.out.println("DONE");
	}

	public static class TreeNode<T> implements Iterable<TreeNode<T>> {
		T data;
		// TreeNode<T> parent;
		List<TreeNode<T>> children;

		public TreeNode(T data) {
			this.data = data;
			this.children = new LinkedList<TreeNode<T>>();
		}

		public void addChild(TreeNode<T> child) {
			this.children.add(child);
		}

		@Override
		public Iterator<TreeNode<T>> iterator() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	Map<Integer, List<TreeNode>> mapLevelToList = new LinkedHashMap<Integer, List<TreeNode>>();

	public void traverse(TreeNode treeNode) {
		traverse(treeNode, 0);
	}

	public void traverse(TreeNode treeNode, int level) {
		if (treeNode == null)
			return;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.clear();
		queue.add(treeNode);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();

			List nodesOnLevel = mapLevelToList.get(level);
			if (nodesOnLevel == null) {
				nodesOnLevel = new ArrayList();
				mapLevelToList.put(level, nodesOnLevel);
			}
			nodesOnLevel.add(node);

			/*
			 * if (levelToNodeCount.get(level) == null) { levelToNodeCount.put(level,
			 * (int)treeNode.data); } else { int sum = levelToNodeCount.get(level);
			 * levelToNodeCount.put(level, sum + (int)treeNode.data); }
			 */
			// if(node.left != null) queue.add(node.left);
			// if(node.right != null) queue.add(node.right);
			/*
			 * if (node.children.size() != 0) { queue.addAll(node.children);
			 * 
			 * level++; }
			 */

			for (Object child : node.children) {
				traverse((TreeNode) child, level + 1);
			}
		}
	}

	// Henry's helper methods for printing
	public void flexPrint(Object o) {
		flexPrint(null, o);
	}

	public void flexPrint(String tag, Object o) {
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
