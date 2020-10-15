package com.henry.interview;

import java.util.*;


// https://leetcode.com/problems/reverse-vowels-of-a-string/
// O(n)
// O(n)
public class ReverseVowels {

	public static void main(String[] args) {
		ReverseVowels soln = new ReverseVowels();
		try {
			Object ans = soln.solve("leetcode");
			soln.flexPrint("ans", ans);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 public String reverseVowels(String s) {
		 return solve(s);
	 }

	private String solve(String str) {
		int left = 0;
		int right = str.length()-1;
		
		char[] chars = str.toCharArray();
		while (left < right) {
			char leftCh = chars[left];
			char rightCh = chars[right];
			if (isVowel(leftCh) && isVowel(rightCh)) {
				swap(left, right, chars);
				left++;
				right--;
				//continue;
			}
			if (isVowel(leftCh) && !isVowel(rightCh)) {
				right--;
				//continue;
			}
			if (!isVowel(leftCh) && isVowel(rightCh)) {
				left++;
				//continue;
			}
			
			if (!isVowel(leftCh) && !isVowel(rightCh)) {
				left++;
				right--;
				//continue;
			}
		}
		
		return new String(chars);
	}
	
	private void swap(int x, int y, char[] chars) {
		char temp = chars[x];
		chars[x] = chars[y];
		chars[y] = temp;
	}
	
	private boolean isVowel(char ch) {
		ch = Character.toLowerCase(ch);
		return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
	}


	// Henry's helper methods for printing
	public static void flexPrint(Object o) {
		flexPrint(null, o);
	}

	public static void flexPrint(String tag, Object o) {
		if (tag == null) {
			tag = "flexPrint ";
		}
		System.out.print(tag + " : ");
		if (o == null) {
			System.out.println("null");
			return;
		}
		if (o instanceof List) {
			List list = (List) o;
			System.out.println(Arrays.toString(list.toArray()));
		} else if (o.getClass().isArray()) {
			try {
				try {
					int[][] intArrArr = (int[][]) o;
					System.out.println();
					for (int i = 0; i < intArrArr.length; i++) {
						for (int j = 0; j < intArrArr[0].length; j++) {
							System.out.print(intArrArr[i][j] + " ");
						}
						System.out.println();
					}
				} catch (Exception e) {
					System.out.println(Arrays.toString((Object[]) o));
				}
			} catch (Exception e1) {
				try {
					int[] primitives = (int[]) o;
					Integer[] wrapped = Arrays.stream(primitives).boxed().toArray(Integer[]::new);
					System.out.println(Arrays.toString(wrapped));
				} catch (Exception e2) {
					try {
						char[] primitives = (char[]) o;
						System.out.println(Arrays.toString(primitives));
					} catch (Exception e3) {
						float[] primitives = (float[]) o;
						System.out.println(Arrays.toString(primitives));
					}
				}
			}
		} else {
			System.out.println(o);
		}
	}

}
