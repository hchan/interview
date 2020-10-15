package com.henry.interview;
// https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/896142/Java-Easy-to-Understand-Sliding-Window-Approach-98
public class LengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		int leftWindow = 0;
		int result = 0;
		int[] map = new int[128];

		for (int i = 0; i < s.length(); i++) {
			map[s.charAt(i)]++;
			while (map[s.charAt(i)] != 1) {
				map[s.charAt(leftWindow)]--;
				leftWindow++;
			}
			result = Math.max(i - leftWindow + 1, result);
		}
		return result;
	}
}
