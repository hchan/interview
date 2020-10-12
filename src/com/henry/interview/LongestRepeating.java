package com.henry.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class LongestRepeating {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbbfast"));
		System.out.println(lengthOfLongestSubstring("bbb"));
		System.out.println(lengthOfLongestSubstring("pwwkefabcdefw"));
		
	}

	public static int lengthOfLongestSubstring(String s) {
		return lengthOfLongestSubstring(s, 0);
	}
	
	public static int lengthOfLongestSubstring(String s,  int maxLengthSoFar) {
		if (s.length() == 0) {
			return maxLengthSoFar;
		}
		ArrayList<Character> chars = new ArrayList<Character>();
		HashMap dict = new LinkedHashMap<Character, Character>();
		for (char c : s.toCharArray()) {
			chars.add(c);
		}
		int currentSearch = 0;
		for (Character ch : chars) {
			if (dict.get(ch) == null) {
				currentSearch++;
			
				dict.put(ch, ch);
			} else {
				if (currentSearch > maxLengthSoFar) {
					return Math.max(currentSearch, lengthOfLongestSubstring(s.substring(currentSearch) , maxLengthSoFar));
				}
			}
		} 
		return Math.max(currentSearch, maxLengthSoFar);
	}

}
