package com.henry.interview.problem1;

import java.util.*;
import java.util.stream.Collectors.*;

public class Solution {

	public static void main(String[] args) {
		Solution soln = new Solution();
		try {
			Object ans = soln.solve(2, new String[] {}, new String[] {});
			soln.flexPrint("ans", ans);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List<String> solve(int k, String[] keywords, String[] reviews) {
		return new ArrayList<String>(Arrays.asList("a", "b"));
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
