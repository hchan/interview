package com.henry.interview;

import java.util.*;
import java.util.stream.Collectors.*;
//https://leetcode.com/discuss/interview-question/893442/Amazon-or-OA-2020-or-Labeling-System
public class LabelingSystem {

	public static void main(String[] args) {
		LabelingSystem soln = new LabelingSystem();
		try {
			Object ans = soln.newLabel("bbbdbbaaaccc",2);
			soln.flexPrint("ans", ans);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	private String solve(String originalLabel, int charLimit) {
		char[] chars = originalLabel.toCharArray();
		Arrays.sort(chars);
		flexPrint(chars);
		
		int
		for (char c : chars) {
			
		}
		
		return "DONE";
	}
	*/
	
	public  String newLabel(String originalLabel, int limit) {
	    int n = originalLabel.length();
	    int[] charSet = new int[128];
	    for (int i = 0; i < n; i++) {
	        charSet[originalLabel.charAt(i)]++;
	    }
	    StringBuilder newLabel = new StringBuilder(n);
	    for (int i = charSet.length - 1; i >= 0; i--) {
	        int count = 0;
	        while (charSet[i] > 0) {
	            newLabel.append((char) i);
	            charSet[i]--;
	            count++;
	            if (charSet[i] > 0 && count == limit) {
	                Character next = nextCharInCharset(charSet, i);
	                if (next == null) return newLabel.toString();
	                newLabel.append(next);
	                count = 0;
	            }
	        }
	    }
	    return newLabel.toString();
	}

	private  Character nextCharInCharset(int[] charset, int start) {
	    for (int i = start - 1; i >= 0; i--) {
	        if (charset[i] > 0) {
	            charset[i]--;
	            return (char) i;
	        }
	    }
	    return null;
	}

	// Henry's helper methods for printing
	public void flexPrint(Object o) {
		flexPrint(null, o);
	}

	public void flexPrint(String tag, Object o) {
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
