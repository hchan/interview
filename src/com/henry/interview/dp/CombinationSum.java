package com.henry.interview.dp;

//https://leetcode.com/problems/combination-sum/
// https://leetcode.com/problems/combination-sum/
import java.util.*;

class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		findCandidates(candidates, 0, target, result, new Stack<>());
		return result;
	}

	void findCandidates(int[] candidates, int i, int target, List<List<Integer>> result, Stack<Integer> stack) {
		if (target <= 0) {
			if (target == 0) {
				result.add(new ArrayList<>(stack));
			}
			return;
		}
		for (int j = i; j < candidates.length; j++) {
			stack.push(candidates[j]);
			findCandidates(candidates, j, target - candidates[j], result, stack);
			stack.pop();
		}
	}
	
	
	public static void main(String[] args) {
		CombinationSum ans = new CombinationSum();
		flexPrint(ans.combinationSum(new int[] {2,3,6,7}, 7));
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