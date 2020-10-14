package com.henry.interview.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/unique-paths-ii/
public class UniquePath2 {

	public static void main(String[] args) {
		int[][] grid = { 
				{ 0, 0, 0, }, 
				{ 0, 0, 1,  },
				{ 0, 0, 0,  }
		};
				
		UniquePath2 soln = new UniquePath2();
		int ans = soln.solve(grid);

		System.out.println(ans);
	}

	public int solve(int[][] grid) {
		int[][] solution = new int[grid.length][grid[0].length];
		if (grid[0][0] == 1) {
			return 0;
		} else {
			solution[0][0] = 1;
		}

		// initial condition for FIRST column
		for (int r = 1; r < grid.length; r++) {
			if (grid[r][0] == 0 && solution[r - 1][0] == 1) {
				solution[r][0] = 1;
			}
		}

		// initial condition for FIRST ROW
		for (int c = 1; c < grid[0].length; c++) {
			if (grid[0][c] == 0 && solution[0][c - 1] == 1) {
				solution[0][c] = 1;
			}
		}

		for (int r = 1; r < grid.length; r++) {
			for (int c = 1; c < grid[0].length; c++) {
				if (grid[r][c] == 0) {
					solution[r][c] += solution[r][c - 1];
					solution[r][c] += solution[r - 1][c];
				}
			}
		}

		return solution[solution.length - 1][solution[0].length - 1];
	}

}
