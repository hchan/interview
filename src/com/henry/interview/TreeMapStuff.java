package com.henry.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class TreeMapStuff {

	public static void main(String[] args) {
		TreeMap<Integer, String> treeMap = new TreeMap<>();
		
		treeMap.put(30, "thirty");
		treeMap.put(50, "fifty");
		treeMap.put(20, "twenty");
		treeMap.put(10, "ten");
		treeMap.put(90, "ninety");
		
		System.out.println(treeMap);
		System.out.println( treeMap.keySet());
		List<Integer> list = new ArrayList<Integer>(treeMap.keySet());
		System.out.println(Arrays.toString ( list.toArray(new Integer[] {})));
		System.out.println(treeMap.floorKey(21));
		System.out.println(treeMap.ceilingKey(21));


	}

}
