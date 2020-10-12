package com.henry.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongPair {

	public static void main(String[] args) {
		Integer[] nums1 = { 37, 23, 60 };
		Integer[] nums2 = { 10, 50, 90, 30 };
		Integer[] nums3 = { 30, 20, 150, 100, 40 };
		Integer[] nums4 = { 60, 60, 60 };
		System.out.println(getSongPairCount(nums1)); //1
		System.out.println(getSongPairCount(nums2)); //2
		System.out.println(getSongPairCount(nums3)); //3
		System.out.println(getSongPairCount(nums4)); //3
	}

	private static long getSongPairCount(Integer[] nums) {
		return getSongPairCount(Arrays.asList(nums));
	}

	public static long getSongPairCount(List<Integer> songs) {
		int k = 60;
		int n = songs.size();
		int ans = 0;

		// sort the given list

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (((songs.get(i) + songs.get(j)) % k) == 0) {
					ans++;
				}
			}
		}

		return ans;
	}

	public static long getSongPairCountNotWork(List<Integer> songs) {
		if (songs.size() == 0) {
			return 0;
		}
		int durationSec = 60;
		int n = songs.size();
		int ans = 0;

		// sort the given list
		// Collections.sort(songs);
		/*
		 * for (int i = 0; i < n; i++) { for (int j = i + 1; j < n; j++) { if
		 * (((songs.get(i) + songs.get(j)) % k) == 0) { ans++; } } }
		 */
		Map<Integer, Integer> secToIndex = new HashMap<Integer, Integer>();
		Integer index = 0;
		for (Integer song : songs) {
			secToIndex.put(song, index++);
		}
		System.out.println(secToIndex);

		for (int i = 0; i < 3; i++) {
			 index = 0;
			for (Integer song : songs) {

				Integer complement = durationSec - song;
				// System.out.println("complement : " + complement );
				if (secToIndex.containsKey(complement) && !index.equals(secToIndex.get(complement))) {
					ans++;
					index++;
					break;
				}
				index++;
			}
			durationSec += 60;
		}
		return ans;
	}
}
