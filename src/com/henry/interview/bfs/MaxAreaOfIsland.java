package com.henry.interview.bfs;

import java.util.*;
import java.util.stream.Collectors.*;


// https://leetcode.com/problems/unique-paths-ii/
// https://www.csestack.org/minimum-distance-truck-deliver-order-amazon/
import java.util.*;
// https://leetcode.com/problems/max-area-of-island/
public class MaxAreaOfIsland {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static int traverse(int i, int j, int[][] grid, boolean[][] visited) {
        Queue<Point> q = collectSources(grid, i, j);
        
        int area = 0;
        while ( !q.isEmpty() ) {
       
        	 Point p = q.poll();
        	 	if (grid[p.r][p.c] == 0) continue;
              	if (visited[p.r][p.c]) {
              		continue;
              	}
                visited[p.r][p.c] = true; // mark as visited
                if (grid[p.r][p.c] == 1) {
                	area++;
                }
                
                for (int[] dir : DIRS) {
                    int r = p.r + dir[0];
                    int c = p.c + dir[1];
                    if (isSafe(grid, visited, r, c)) {
                        q.add(new Point(r, c));
                    }
                }
          
        }
        return area;
    }
    
    private static Queue<Point> collectSources(int[][] grid, int i, int j) {
        Queue<Point> sources = new ArrayDeque<>();
        sources.add(new Point(i,j));
        return sources;
    }
    
    private static boolean isSafe(int[][] grid, boolean[][] visited, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && !visited[r][c] && grid[r][c] != 0;

    }
    
    private static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {        
        int[][] grid = new int[][] {
        		/*
        		{0,0,0,0,0,0,0,1,0,0,0,0,0},
        		 {0,0,0,0,0,0,0,1,1,1,0,0,0},
        		 {0,1,1,0,1,0,0,0,0,0,0,0,0},
        		 {0,1,0,0,1,1,0,0,1,0,1,0,0},
        		 {0,1,0,0,1,1,0,0,1,1,1,0,0},
        		 {0,0,0,0,0,0,0,0,0,0,1,0,0},
        		 {0,0,0,0,0,0,0,1,1,1,0,0,0},
        		 {0,0,0,0,0,0,0,1,1,0,0,0,0}
        		 */
        	{0,1},
        	{1,0}
        		 
        		 };	
        MaxAreaOfIsland soln = new MaxAreaOfIsland();
      
        System.out.println(soln.maxAreaOfIsland(grid));
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return solve(grid, visited);
    }

	private static int solve(int[][] grid, boolean[][] visited) {
		int maxSoFar = -1;
		for (int i = 0; i < grid.length; i++) {
			
			for (int j = 0; j < grid[0].length; j++) {
				int dist = traverse(i, j, grid, visited);
				if (dist > maxSoFar) {
					maxSoFar = dist;
				}
			}
		}
		return maxSoFar;
	}
    
  
}