package com.henry.interview;
// O n*n
// O(1)
public class Palindrome {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("aaccccc"));
	}
	
	public static String longestPalindrome(String s) {
	    if (s == null || s.length() < 1) return "";
	    int start = 0, end = 0;
	    for (int i = 0; i < s.length(); i++) {
	        int len1 = expandAroundCenter(s, i, i);
	        int len2 = expandAroundCenter(s, i, i + 1);
	        int len = Math.max(len1, len2);
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2;
	        }
	    }
	    return s.substring(start, end + 1);
	}

	private static int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    return R - L - 1;
	}

	public boolean isPalindrome(String text) {
	    String clean = text.toLowerCase();
	    StringBuffer plain = new StringBuffer(clean);
	    StringBuffer reverse = plain.reverse();
	    return (reverse.toString()).equals(clean);
	}
}
