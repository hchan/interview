package com.henry.interview;

import java.util.*;
import java.util.stream.Collectors.*;

public class ThreeSumBroken {

	public static void main(String[] args) {
		ThreeSumBroken soln = new ThreeSumBroken();
		try {
			/*
			 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]]
			 */
			List<List<Integer>> ans = soln.solve(new int[] {-1,0,1,2,-1,-4});
			soln.flexPrint("ans", ans);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List<List<Integer>> solve(int[] nums) {
		List<List<Integer>> retval = new ArrayList<List<Integer>>();
		
		int indexX=0;
		int indexY=0;
		int indexZ=0;
		
		for (int numX : nums) {
		
			for (int numY : nums) {
				
				for (int numZ : nums) {
					int sum = numX + numY + numZ;
					if (sum == 0 &&  (indexX != indexY) && (indexX != indexZ) && (indexY != indexZ)) {
						List<Integer> ansElement = Arrays.asList(numX, numY, numZ);
						Collections.sort(ansElement);


						retval.add(ansElement);
					}
					indexZ++;
				}
				indexY++;
			}
			indexX++;
		}
		//retval = removeDuplicates(retval);
		return retval;
	}

	private List<List<Integer>> removeDuplicates(List<List<Integer>> list) {
		 List listWithoutDuplicates = new ArrayList<>(
			      new HashSet<>(list));
		return listWithoutDuplicates;
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
