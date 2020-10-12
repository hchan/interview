package com.henry.interview;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

	public static void main(String[] args) {
		TreeNode<String> root = new TreeNode<String>("root");
		TreeNode<String> aNode = new TreeNode<String>("A");
		TreeNode<String> aNode1 = new TreeNode<String>("A1");
		TreeNode<String> aNode2 = new TreeNode<String>("A2");
		TreeNode<String> aNode3 = new TreeNode<String>("A3");
		aNode.addChild(aNode1);
		aNode.addChild(aNode2);
		aNode.addChild(aNode3);
		root.addChild(aNode);
		TreeNode<String> bNode = new TreeNode<String>("B");
		TreeNode<String> bNode1 = new TreeNode<String>("B1");
		TreeNode<String> bNode2 = new TreeNode<String>("B2");
		TreeNode<String> bNode3 = new TreeNode<String>("B3");
		bNode.addChild(bNode1);
		bNode.addChild(bNode2);
		bNode.addChild(bNode3);
		root.addChild(bNode);
		
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		bfs.traverse(root);
		System.out.println("DONE");
	}
 
	public static class TreeNode<T> implements Iterable<TreeNode<T>>{
		T data;
		//TreeNode<T> parent;
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


	public void traverse(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.clear();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.println("data : " + node.data);
			// if(node.left != null) queue.add(node.left);
			// if(node.right != null) queue.add(node.right);
			if (node.children.size() != 0) {
				queue.addAll(node.children);
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
