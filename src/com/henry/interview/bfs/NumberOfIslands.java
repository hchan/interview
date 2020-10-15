package com.henry.interview.bfs;

import java.util.*;
import java.util.stream.Collectors.*;
// https://leetcode.com/problems/unique-paths-ii/
// https://www.csestack.org/minimum-distance-truck-deliver-order-amazon/
import java.util.*;
// https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

	public static int traverse(int i, int j, char[][] grid) {
		Queue<Point> q = collectSources(grid, i, j);
		int islandArea = 0;
		while (!q.isEmpty()) {
			for (int sz = q.size(); sz > 0; sz--) {
				Point p = q.poll();
				if (grid[p.r][p.c] == '0') {
					continue;
				}
				grid[p.r][p.c] = '0';			
				islandArea++;			
				for (int[] dir : DIRS) {
					int r = p.r + dir[0];
					int c = p.c + dir[1];
					if (isSafe(grid, r, c)) {
						q.add(new Point(r, c));
					}
				}
			}
		}
		return islandArea;
	}
    
    private static Queue<Point> collectSources(char[][] grid, int x, int y) {
        Queue<Point> sources = new ArrayDeque<>();
        sources.add(new Point(x,y));
        return sources;
    }
    
    private static boolean isSafe(char[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != '0';// !visited[r][c];
    }
    
    private static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {        
        char[][] grid = {
        		  {'1','1','0','0','0'},
        		  {'1','1','0','0','0'},
        		  {'0','0','1','0','0'},
        		  {'0','0','0','1','1'}
        }; 	
      //  boolean[][] visited = new boolean[grid.length][grid[0].length];
        NumberOfIslands soln = new NumberOfIslands();
        System.out.println(soln.solve(grid));
    }

	private static int solve(char[][] grid) {
		int count = 0;
		
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c  < grid[0].length; c++) {
				int area = traverse(r, c, grid);
				if (area > 0) {
					count++;
				}
			}
		}
		return count;
	}
    
	 public int numIslands(char[][] grid) {
	       return solve(grid); 
	 }
	
}