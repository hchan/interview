package com.henry.interview.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/unique-paths/
// Time : O(M*N)
// Space: O(M*N) ... needs to create a grid
public class UniquePaths {

	public int solve(int[][] grid) {
		grid[0][0] = 1;
		
		for (int r = 1; r < grid.length; r++) {
			grid[r][0] = 1;
		}

		for (int c = 1; c < grid[0].length; c++) {
			grid[0][c] = 1;
		}
		
		for (int r = 1; r < grid.length; r++) {
			for (int c = 1; c < grid[0].length; c++) {
				grid[r][c] += grid[r][c-1];
				grid[r][c] += grid[r-1][c];
			}
		}
		return grid[grid.length-1][grid[0].length-1];
	}
	public int uniquePaths(int m, int n) {
		int[][] grid = new int[m][n];
		return solve(grid);
	}
	public static void main(String[] args) {


		UniquePaths soln = new UniquePaths();
		int result = soln.uniquePaths(3,7);
		System.out.print(result);
	}

}
