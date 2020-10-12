package com.henry.interview;

import java.util.*;
import java.util.stream.Collectors.*;

public class TwoSum {

	public static void main(String[] args) {
		TwoSum soln = new TwoSum();
		try {
			/**
			 * 
			 * Input: nums = [2,7,11,15], target = 9 Output: [0,1]
			 **/
			 List<Integer> ans = soln.solve(new int[] {2,7,11,15}, 9);
			soln.flexPrint("ans", ans);
			ans = soln.solve(new int[] { 3, 2, 4 }, 6);
			soln.flexPrint("ans", ans);
			ans = soln.solve(new int[] { 3, 3}, 6);
			soln.flexPrint("ans", ans);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List<Integer> solve(int[] nums, int target) {
		HashMap<Integer, Integer> valueToIndex = new HashMap<Integer, Integer>();
		int index = 0;
		for (int num : nums) {
			valueToIndex.put(num, index);
			index++;
		}
		for (int j = 0; j < nums.length; j++) {

			for (int i = j; i < nums.length; i++) {
				int num = nums[i];
				int complement = target - num;
				if (valueToIndex.get(complement) != null && i != valueToIndex.get(complement)) {
					flexPrint("complement",complement);
					return Arrays.asList(i, valueToIndex.get(complement));
				}
			}
		}

		return null;
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
		if (o instanceof List) {
			List list = (List) o;
			System.out.println(Arrays.toString(list.toArray()));
		} else if (o.getClass().isArray()) {
			try {
				System.out.println(Arrays.toString((Object[]) o));
			} catch (Exception e) {
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
