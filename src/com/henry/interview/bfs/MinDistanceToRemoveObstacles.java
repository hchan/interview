package com.henry.interview.bfs;

import java.util.*;
import java.util.stream.Collectors.*;
// https://leetcode.com/problems/unique-paths-ii/
// https://www.csestack.org/minimum-distance-truck-deliver-order-amazon/
import java.util.*;

// https://leetcode.com/discuss/interview-question/396858/amazon-oa-minimum-distance-to-remove-obstacle
public class MinDistanceToRemoveObstacles {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

	public static int traverse(int i, int j, int[][] grid, boolean[][] visited) {
		Queue<Point> q = collectSources(grid);
		for (int dist = 0; !q.isEmpty(); dist++) {
			for (int sz = q.size(); sz > 0; sz--) {
				Point p = q.poll();

				if (grid[p.r][p.c] == 9)
					return dist;
				if (grid[p.r][p.c] == 0) {
					continue;
				}
				if (visited[p.r][p.c]) {
					continue;
				}
				visited[p.r][p.c] = true; // mark as visited

				for (int[] dir : DIRS) {
					int r = p.r + dir[0];
					int c = p.c + dir[1];
					if (isSafe(grid, visited, r, c)) {
						q.add(new Point(r, c));
					}
				}

			}
		}
		return -1;
	}
    
    private static Queue<Point> collectSources(int[][] grid) {
        Queue<Point> sources = new ArrayDeque<>();
        sources.add(new Point(0,0));
        return sources;
    }
    
    private static boolean isSafe(int[][] grid, boolean[][] visited, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && !visited[r][c];
    }
    
    private static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {        
        int[][] grid = {
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
        	{0, 1, 0, 9, 1}}; 	
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        System.out.println(minDist(grid, visited));
    }

	private static int minDist(int[][] grid, boolean[][] visited) {
		int dist = traverse(-1, -1, grid, visited);
		return dist;
	}
    
  
}