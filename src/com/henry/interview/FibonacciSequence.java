package com.henry.interview;

public class FibonacciSequence {

	public static void main(String[] args) {
		System.out.println(calcFibonnaciSequence(10));
	}
//  0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
	private static int calcFibonnaciSequence(int index) {
		if (index <= 1) {
			return index;
		}
		return calcFibonnaciSequence(index-1) + calcFibonnaciSequence(index-2); 
	}

}
