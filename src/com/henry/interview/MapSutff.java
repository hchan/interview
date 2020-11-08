package com.henry.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MapSutff {

	public static void main(String[] args) {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("hi", map.containsKey("hi") ? map.get("hi") + 1 : 1);
		map.put("hi", map.containsKey("hi") ? map.get("hi") + 1 : 1);
		map.put("hi", map.containsKey("hi") ? map.get("hi") + 1 : 1);

		map.merge("bye", 1, (k, v) -> v + 1);
		map.put("hi", map.containsKey("hi") ? map.get("hi") + 1 : 1);

		map.merge("apple", 1, (k, v) -> v + 1);
		flexPrint(map);
		Set<String> keys = map.keySet();
		
		List<String> keysAsList = new ArrayList();
		keysAsList.addAll(keys);
		
		for (String key : keysAsList) {
			System.out.println(key + "->" + map.get(key));
		}
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
