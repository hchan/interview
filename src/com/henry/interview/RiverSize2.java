package com.henry.interview;
import java.util.*;
// https://leetcode.com/discuss/interview-question/356150
public class RiverSize2 {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static int solve(int[][] grid,  int row, int col) {
    	if (grid[row][col] == 0) return 0;
        Queue<Point> q = collectSources(grid, row, col);
        int retval = 0;
        for (int dist = 0; !q.isEmpty(); dist++) {
            for (int sz = q.size(); sz > 0; sz--) {
                Point p = q.poll();
                grid[p.r][p.c] = 0; // mark as visited
                for (int[] dir : DIRS) {
                    int r = p.r + dir[0];
                    int c = p.c + dir[1];
                    if (isSafe(grid, r, c)) {
                        q.add(new Point(r, c));
                    }
                }
                
            }
           retval = dist;
        }
     
        return retval+1;
    }
    
    private static Queue<Point> collectSources(int[][] grid, int row, int col) {
        Queue<Point> sources = new ArrayDeque<>();
        
        /*
        for (int r = 0; r < grid.length; r++) {
        	
            for (int c = 0; c < grid[0].length; c++) {
              // if (grid[r][c] == 'S') {
                    sources.add(new Point(r, c));
             //   }
            }
        }
        */
        sources.add(new Point(row,col));
        return sources;
    }
    
    private static boolean isSafe(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != 0;
    }
    
    private static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public static int[][] deepClone (int[][] grid) {
    	if (grid == null) {
    		return null;
    	}
    	int[][] retval = new int[grid.length][grid[0].length];
    	for (int i = 0; i < grid.length; i++) {
    		for(int j = 0; j < grid[0].length; j++) {
    			retval[i][j] = grid[i][j];
    		}
    	}
    	return retval;
    }

    public static void main(String[] args) {        
        int[][] grid = {
            {1, 0, 0, 1, 0},
            {1, 0, 1, 0, 0},
            {0, 0, 1, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 0}}; 
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				int dist = solve(grid, i, j);
				if (dist > 0) {
					flexPrint(i + "," + j + ": dist", dist);
				}
			}
		}
    }
    
    public static List<Integer> riverSizes(int[][] matrix) {
    	List<Integer> retval = new ArrayList<Integer>();
    	for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {

				int dist = solve(matrix, i, j);
				if (dist > 0) {
					retval.add(dist);
				}
			}
		}
    	return retval;
    }
    
 // Henry's helper methods for printing
 	public static void flexPrint(Object o) {
 		flexPrint(null, o);
 	}

 	public static void flexPrint(String tag, Object o) {
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
					System.out.println(Arrays.toString((Object[]) o));
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