package com.henry.interview;

import java.util.*;
import java.util.stream.Collectors;

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

		int[] nums = new int[] { 3, 5, 3 };
		arrayStuff.flexPrint("nums", nums);

		char[] chars = new char[] { 'c', 'o', 'o', 'l' };
		arrayStuff.flexPrint("chars", chars);

		float[] floatnums = new float[] { 3.1f, 4.2f, 37.9f };
		arrayStuff.flexPrint("floatnums", floatnums);

		List<String> listWithDups = Arrays.asList("a", "c", "a", "c", "b", "d", "a");
		arrayStuff.flexPrint("listWithDups", listWithDups);

		List<String> noDups = arrayStuff.removeDuplicates(listWithDups);
		arrayStuff.flexPrint("noDups", noDups);

		List copyList = new ArrayList(listWithDups);
		System.out.println(listWithDups.equals(copyList));
		listWithDups.set(0, "A");
		System.out.println(listWithDups.equals(copyList));

		List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
		Collections.sort(numList);
		arrayStuff.flexPrint("numList", numList);
		arrayStuff.insertIntoSortedList(9, numList);
		arrayStuff.insertIntoSortedList(2, numList);
		arrayStuff.insertIntoSortedList(4, numList);
		arrayStuff.insertIntoSortedList(3, numList);
		arrayStuff.insertIntoSortedList(6, numList);
		arrayStuff.flexPrint("numList", numList);

		List<Integer> addByIndex = new ArrayList<Integer>(10);
		for (int i = 0; i <= 10; i++) {
			addByIndex.add(0);
		}

		addByIndex.set(5,5);
		flexPrint(addByIndex);
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

	public List removeDuplicates(List list) {
		return (List) list.stream().distinct().collect(Collectors.toList());
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
}
