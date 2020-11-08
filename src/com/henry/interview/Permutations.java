package com.henry.interview;
import java.util.*;


public class Permutations {
	static List<String> soln = new ArrayList<String>();
	public static void main(String[] args) {
		Permutations permutations = new Permutations();
		permutations.permute("ABCDE".toCharArray(), 0);
		System.out.println(soln.size());

		System.out.println(Arrays.toString(soln.toArray(new String[] {})));
	}

	private void permute(char[] chars, int fixed) {
		if (fixed == chars.length-1) {
			soln.add(new String(chars));
		}
		for (int i = fixed; i < chars.length; i++) {
			char[] tempArr = Arrays.copyOf(chars, chars.length);
			char left = tempArr[fixed];
			char right = tempArr[i];
			tempArr[fixed] = right;
			tempArr[i] = left;
					
		

			permute (tempArr, fixed+1);
		}
	}

}
