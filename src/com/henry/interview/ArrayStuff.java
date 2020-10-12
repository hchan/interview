package com.henry.interview;

import java.util.*;

public class ArrayStuff {

	public static void main(String[] args) {
		String[] reviews = new String[] { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
		System.out.println(Arrays.toString(reviews));

		List<String> reviewList = Arrays.asList(reviews.clone());
		System.out.println(Arrays.toString(reviewList.toArray()));

		String[] reviews2 = reviewList.toArray(new String[] {});
		System.out.println(Arrays.toString(reviews2));

		ArrayStuff arrayStuff = new ArrayStuff();
		arrayStuff.flexPrint(reviews);

		arrayStuff.flexPrint(reviewList);

		int[] nums = new int[] { 3, 4, 3 };
		arrayStuff.flexPrint("nums", nums);

		char[] chars = new char[] { 'c', 'o', 'o', 'l' };
		arrayStuff.flexPrint("chars", chars);
		
		float[] floatnums = new float[] { 3.1f, 4.2f, 37.9f };
		arrayStuff.flexPrint("floatnums", floatnums);
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
