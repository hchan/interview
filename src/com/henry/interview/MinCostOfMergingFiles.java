package com.henry.interview;

// https://www.csestack.org/minimum-cost-merging-files/
import java.util.*;
import java.util.stream.Collectors.*;

public class MinCostOfMergingFiles {

	public static void main(String[] args) {
		MinCostOfMergingFiles soln = new MinCostOfMergingFiles();
		try {
			Object ans = soln.solve(new Integer[] { 14, 25, 5, 8 });
			soln.flexPrint("ans", ans);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int solve(Integer[] files) {
		List<Integer> tempList = Arrays.asList(files);
		ArrayList<Integer> queue = new ArrayList<Integer>(tempList);
		Collections.sort(queue);
		return solve(queue, 0);
	}

	private int solve(ArrayList<Integer> queue, int sumSoFar) {
		int pop1 = queue.remove(0);
		int pop2 = queue.remove(0);
		int tempComp = pop1 + pop2;

		sumSoFar += tempComp;
		if (queue.size() == 0) {
			return sumSoFar;
		}
		flexPrint("before", queue);

		insertIntoSortedList(tempComp, queue); // O(n) operation
		flexPrint("after", queue);

		return solve(queue, sumSoFar);
	}

	public int insertIntoSortedList(int num, List<Integer> list) {
		if (list == null || list.isEmpty()) {
			return -1;
		}
		
		if (list.size() == 0) {
			list.add(0, num);
			return 0;
		}
		for (int i = 0; i < list.size(); i++) {
			if (i + 1 == list.size()) {
				list.add(num);
				return i;
			}
			if (i == 0 && num < list.get(0)) {
				list.add(0, num);
				return 0;
			}
			Integer current = list.get(i);
			Integer currentNext = list.get(i + 1);
		
			if (num > current && num <= currentNext) {
				list.add(i + 1, num);
				return i;
			}
		}
		return -1;
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
