package com.henry.interview;

public class IsPalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindromNumber(12521));

	}

	/**
	 * returns whether a number given is a palindrome
	 */
	private static boolean isPalindromNumber(int input) {
		// base condition checks
		if (input < 0) return false;
		
		int loopNumber = input;
		int reverseNumber = 0;
		while (loopNumber != 0) {
			reverseNumber *= 10;
			reverseNumber += loopNumber % 10;
			loopNumber /= 10;
		}
		return reverseNumber == input;
	}

}
