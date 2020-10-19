package com.henry.interview;

import java.util.Arrays;
import java.util.List;

public class MaxSubArray {

	public static void main(String[] args) {
		MaxSubArray soln = new MaxSubArray();
		int[] nums = new int[] { 1, -3, 2, -5, 7, 6, -1, -4, 11, -23, 1,1,1,1};
		flexPrint(soln.maxSubArray(nums));
	}

	
	int maxSubArray(int[] nums) {
		int retval = Integer.MIN_VALUE;
		int maxHere = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			
			
			maxHere = Math.max(nums[i] + maxHere, nums[i]);
			retval = Math.max(maxHere, retval);
			
		}
		
		return retval;
	}
	
	int[] solve(int[] a) {
		int max_so_far = 0;
		int max_ending_here = 0;
		int max_start_index = 0;
		int startIndex = 0;
		int max_end_index = -1;

		for (int i = 0; i < a.length; i++) {
			if (0 > max_ending_here + a[i]) {
				startIndex = i + 1;
				max_ending_here = 0;
			} else {
				max_ending_here += a[i];
			}

			if (max_ending_here > max_so_far) {
				max_so_far = max_ending_here;
				max_start_index = startIndex;
				max_end_index = i;
			}
		}

		if (max_start_index <= max_end_index) {
			return Arrays.copyOfRange(a, max_start_index, max_end_index + 1);
		}

		return null;
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
