package com.henry.interview;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Collectors.*;

public class ThreeSum {

	public static void main(String[] args) {
		ThreeSum soln = new ThreeSum();
		try {
			Object ans = soln.solve(new int[] { -1, 0, 1, 2, -1, -4 });
			System.out.println(ans);
			ans = soln.solve(new int[] { });
			System.out.println(ans);
			ans = soln.solve(new int[] {0 });
			System.out.println(ans);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List<List<Integer>> solve(int[] nums) {
		List<List<Integer>> retval = new ArrayList<List<Integer>>();
		int index = 0;
		for (int num : nums) {
			int target = 0 - num;
			// int[] twoSumNums = new int[nums.length-1];
			// System.arraycopy(nums, 1, twoSumNums, 0, nums.length-1);
			// flexPrint("target", target);
			// flexPrint("twoSumNums", twoSumNums);
			List<Integer> twoSumSoln = solveTwoSum(nums, target);
			// flexPrint("solveTwoSum " + num + "->", twoSumNums);
			if (twoSumSoln != null) {
				if (index != twoSumSoln.get(0) && index != twoSumSoln.get(1)
						&& twoSumSoln.get(0) != twoSumSoln.get(1)) {
					List<Integer> childList = Arrays.asList(nums[index], nums[twoSumSoln.get(0)],
							nums[twoSumSoln.get(1)]);
					Collections.sort(childList);
					retval.add(childList);
				}
			}
			index++;
		}

		retval = retval.stream().distinct().collect(Collectors.toList());
		return retval;
	}

	private List<Integer> solveTwoSum(int[] nums, int target) {
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
		if (o == null) {
			System.out.println("null");
		}
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
