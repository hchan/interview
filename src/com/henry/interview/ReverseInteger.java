package com.henry.interview;

import java.util.*;
import java.util.stream.Collectors.*;

public class ReverseInteger {

	public static void main(String[] args) {
		ReverseInteger soln = new ReverseInteger();
		try {
			Object ans = soln.solve(453489002);
			soln.flexPrint("ans", ans);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int solve(int num) {
		int retval = 0;
		int quotient = Integer.MAX_VALUE;
		int mod = 0;
		Stack<Integer> stack = new Stack<Integer>();
		while (quotient > 0) {
			quotient = num / 10;
			mod = num % 10;
			num = quotient;
			stack.push(mod);
		}
		flexPrint(stack);
		int multiplier = 1;
		while (stack.size() > 0) {
			int pop = stack.pop();
			int temp = pop*multiplier;
			multiplier*=10;
			retval += temp;
		}
		return retval;
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
