package com.henry.interview;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {

		System.out.println(longestPalindromicSubstring("baccfccad"));
	}

	public static String longestPalindromicSubstring (String input) {
		// base condition check
		if (input == null || input.length() == 0) return "";
		if (input.length() == 1) {
			return input;
		}
		// examples accccccccccccsfsdfasfadsfasdf
		
		char[] chars = input.toCharArray();
		// approach iterate thru each character in chars
		// 2 cases for a palidromic string
		// 1) string has even number of chars i.e. aa
		// 2) string has an odd number of chars i.e. aba
		
		List<Character> rightPalindromeTemp = new ArrayList<Character>();
		List<Character> rightPalindromeMax = new ArrayList<Character>();
		char prevChar = '\0';
		for (int i = 1; i < chars.length; i++) {
			for (int expand = 1; i - expand >= 0 && i+expand-1 < chars.length; expand++) {
				char nextCharExpandLeft =  chars[i-expand];
				char nextCharExpandRight =  chars[i+expand-1];
				
				if (nextCharExpandLeft == nextCharExpandRight) {
					rightPalindromeTemp.add(nextCharExpandRight);
				} else {
					break;
				}
			}

			if (rightPalindromeTemp.size() > rightPalindromeMax.size()) {
				rightPalindromeMax = new ArrayList<Character>();
				rightPalindromeMax.addAll(rightPalindromeTemp);
			}
			 rightPalindromeTemp = new ArrayList<Character>();

		}
		
		
		String right = getStringFromCharList(rightPalindromeMax);
		 StringBuilder reverse = new StringBuilder(right);
		return reverse.reverse() + right;
	}

	public static String getStringFromCharList(List<Character> list) {
		StringBuffer sb = new StringBuffer();
		for (Character ch : list) {
			sb.append(ch);
		}
		return sb.toString();
	}
}
