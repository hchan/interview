package com.henry.interview.bfs;

import java.util.*;
import java.util.stream.Collectors.*;
// https://leetcode.com/problems/unique-paths-ii/
// https://www.csestack.org/minimum-distance-truck-deliver-order-amazon/
import java.util.*;
// https://leetcode.com/discuss/interview-question/356150
public class MinDistanceRequiredForTheTruckToDeliverTheOrder {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static int minDist(char[][] grid) {
        Queue<Point> q = collectSources(grid);
        for (int dist = 0; !q.isEmpty(); dist++) {
            for (int sz = q.size(); sz > 0; sz--) {
                Point p = q.poll();
                
              if (grid[p.r][p.c] == '9') return dist;
                grid[p.r][p.c] = '1'; // mark as visited
                
                for (int[] dir : DIRS) {
                    int r = p.r + dir[0];
                    int c = p.c + dir[1];
                    if (isSafe(grid, r, c)) {
                        q.add(new Point(r, c));
                    }
                }
                
            }
        }
        return -1;
    }
    
    private static Queue<Point> collectSources(char[][] grid) {
        Queue<Point> sources = new ArrayDeque<>();
        /*
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 'S') {
                    sources.add(new Point(r, c));
                }
            }
        }
        */
        sources.add(new Point(0,0));
        return sources;
    }
    
    private static boolean isSafe(char[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != '0';
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
            {'1', '0', '0', '0', '0'},
            {'1', '0', '0', '0', '0'},
            {'1', '1', '1', '1', '1'},
            {'1', '1', '0', '0', '1'},
            {'1', '1', '0', '0', '1'},
        	{'1', '1', '0', '9', '1'}}; 	
        System.out.println(minDist(grid));
    }
    
  
}