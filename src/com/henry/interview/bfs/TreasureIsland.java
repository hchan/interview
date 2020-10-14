package com.henry.interview.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreasureIsland {
	
	public List<Integer> solve(char[][] matrix) {
		List<Integer> sizes = new ArrayList<Integer>();
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		
		/*
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (visited[i][j]) {
					continue;
				}
				traverseNode(i, j, matrix, visited, sizes);
			}
		}
		*/
		traverseNode(0, 0, matrix, visited, sizes);
		return sizes;
	}

	public void traverseNode(int i, int j, char[][] matrix, boolean[][] visited, List<Integer> sizes) {
		int shortestRoute = -1;

		Stack<Integer[]> nodesToExplore = new Stack<Integer[]>();
		
		nodesToExplore.push(new Integer[] { i, j });
		while (!nodesToExplore.empty()) {
			Integer[] currentNode = nodesToExplore.pop();
			
			i = currentNode[0];
			j = currentNode[1];
			if (visited[i][j]) {
				continue;
			}

			if (matrix[i][j] == 'D') {
				continue;
			}
			shortestRoute++;
			flexPrint("i : " + i + ", j : " +j, matrix[i][j]);

			
			if (matrix[i][j] == 'X') {
				sizes.add(shortestRoute);
				break;
			}
			
			
			visited[i][j] = true;
			
			List<Integer[]> unvisitedNeighbors = getUnvisitedNeighbors(i, j, matrix, visited);
			for (Integer[] neighbor : unvisitedNeighbors) {
				nodesToExplore.add(neighbor);
			}
		}

	
	}

	public List<Integer[]> getUnvisitedNeighbors(
			int i, int j, char[][] matrix, boolean[][] visited) {
		List<Integer[]> unvisitedNeighbors = new ArrayList<Integer[]>();
		if (i > 0 && !visited[i - 1][j]) {
			unvisitedNeighbors.add(new Integer[] { i - 1, j });
		}
		if (i < matrix.length - 1 && !visited[i + 1][j]) {
			unvisitedNeighbors.add(new Integer[] { i + 1, j });
		}
		if (j > 0 && !visited[i][j - 1]) {
			unvisitedNeighbors.add(new Integer[] { i, j - 1 });
		}
		if (j < matrix[0].length - 1 && !visited[i][j + 1]) {
			unvisitedNeighbors.add(new Integer[] { i, j + 1 });
		}
		return unvisitedNeighbors;
	}
	

	
	public static void main(String[] args) {
		char[][] island = new char[][]{
				{'0', 'O', 'O', 'O'},
				{'D', 'O', 'D', 'O'},
				{'O', 'O', 'O', 'O'},
				{'X', 'D', 'D', 'O'}
		};
		TreasureIsland soln = new TreasureIsland();
		soln.flexPrint(soln.solve(island));
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

