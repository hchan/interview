package com.henry.interview;

import java.util.ArrayList;
import java.util.List;

public class Factorial {



	public static long factorialUsingForLoop(int n) {
		long fact = 1;
		for (int i = 2; i <= n; i++) {
			fact = fact * i;
		}
		return fact;
	}

	public static int factorial(int n) {
		if (n == 0 || n == 1)
			return 1;
		return n * factorial(n - 1);
	}
	
	public static List<Character> convertStringToCharList(String str) {

		// Create an empty List of character
		List<Character> chars = new ArrayList<>();

		// For each character in the String
		// add it to the List
		for (char ch : str.toCharArray()) {

			chars.add(ch);
		}

		// return the List
		return chars;
	}
	
	public static int factorial2(int n) {
		if (n <= 1) {
			return n;
		}
		return n* factorial2(n-1);
	}
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + ":" + factorial2(i));
		}
	}
}
