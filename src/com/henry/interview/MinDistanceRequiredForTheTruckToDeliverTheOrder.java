package com.henry.interview;

import java.util.*;
import java.util.stream.Collectors.*;
// https://leetcode.com/problems/unique-paths-ii/
// https://www.csestack.org/minimum-distance-truck-deliver-order-amazon/
public class MinDistanceRequiredForTheTruckToDeliverTheOrder {

	public static final int REPRESENTABLE = 1;
	public static final int BLOCKED = 0;
	public static final int DESTINATION = 1;
	public static void main(String[] args) {
		MinDistanceRequiredForTheTruckToDeliverTheOrder soln = new MinDistanceRequiredForTheTruckToDeliverTheOrder();
		/*
		 * 1 == representable
		 * 0 == blocked
		 * 9 == destination
		 */
		try {
			int[][] matrix = new int[][] {
				{1, 0, 0, 0, 0},
				{1, 1, 0, 0, 0},
				{1, 1, 1, 1, 1},
				{1, 1, 1, 0, 1},
				{1, 1, 1, 0, 1}
			};
			Object ans = soln.uniquePathsWithObstacles(matrix);
			soln.flexPrint("ans", ans);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public class Point {
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		int x;
		int y;
		int distance = 0;
		@Override
		public String toString() {
			return "[" + x + "," + y + "->" + distance + "]";
		}
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		flexPrint("obstacleGrid", obstacleGrid);
		List<Point>  retval = new ArrayList();
		
		int R = obstacleGrid.length;
		int C = obstacleGrid[0].length;
		int[][] memoizationGrid = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				memoizationGrid[i][j] = -1;
			}
		}

		// If the starting cell has an obstacle, then simply return as there would be
		// no paths to the destination.
		if (obstacleGrid[0][0] == BLOCKED) {
			return -1;
		}

		// Number of ways of reaching the starting cell = 1.
		memoizationGrid[0][0] = 0;

		// Filling the values for the first column
		for (int i = 1; i < R; i++) {
			if (obstacleGrid[i][0] >= 1 && obstacleGrid[i - 1][0] >= 1) {
				int newDistanceFound = memoizationGrid[i - 1][0] +1;
				if (memoizationGrid[i][0] == -1 ||newDistanceFound < memoizationGrid[i][0]) {
					memoizationGrid[i][0] = newDistanceFound;
				}
			} 
		}


		// Filling the values for the first row
		for (int i = 1; i < C; i++) {
			if (obstacleGrid[0][i] >= 1 && obstacleGrid[0][i - 1] >= 1) {
				int newDistanceFound = memoizationGrid[0][i-1] +1;
				if (memoizationGrid[0][i-1] == -1 ||newDistanceFound <memoizationGrid[0][i-1]) {
					memoizationGrid[0][i-1] = newDistanceFound;
				}
			}
		}

		// Starting from cell(1,1) fill up the values
		// No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
		// i.e. From above and left.
		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				if (obstacleGrid[i][j] >= 1) {
					if (memoizationGrid[i][j] == -1 ) {
						int newDistanceFound= memoizationGrid[i][j-1] + 1;
						memoizationGrid[i][j] = newDistanceFound;
						newDistanceFound= memoizationGrid[i-1][j] + 1;
					}					
				}
			}
		}
		flexPrint("memoizationGrid", memoizationGrid);

		// Return value stored in rightmost bottommost cell. That is the destination.
		//return obstacleGrid[R - 1][C - 1];
		return 0;
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
				try {
					int[][] intArrArr = (int[][]) o;
					System.out.println();
					for (int i = 0; i < intArrArr.length; i++) {
						for (int j = 0; j < intArrArr[0].length; j++) {
							System.out.print(intArrArr[i][j] + " ");
						}
						System.out.println();
					}
				} catch (Exception e) {
					try {
						Point[][] intArrArr = (Point[][]) o;
						System.out.println();
						for (int i = 0; i < intArrArr.length; i++) {
							for (int j = 0; j < intArrArr[0].length; j++) {
								System.out.print(intArrArr[i][j] + " ");
							}
							System.out.println();
						}
					} catch (Exception pointException) {
						System.out.println(Arrays.toString((Object[]) o));
					}
				}
			} catch (Exception e1) {
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
