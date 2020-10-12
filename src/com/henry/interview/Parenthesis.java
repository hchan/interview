package com.henry.interview;

import java.util.*;
import java.util.stream.Collectors.*;

public class Parenthesis {

	public static void main(String[] args) {
		Parenthesis soln = new Parenthesis();
		try {
			Object ans = null;
		
			ans = soln.solve("()");
			soln.flexPrint("ans", ans);
			ans = soln.solve("()[]{}");
			soln.flexPrint("ans", ans);
			ans = soln.solve("(]");
			soln.flexPrint("ans", ans);
			ans = soln.solve("([)]");
			soln.flexPrint("ans", ans);
			
			ans = soln.solve("{[]}");
			soln.flexPrint("ans", ans);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean solve(String str) {
		
		
		Stack<Character> openParenthesisStack = new Stack<Character>();
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if  (ch == '}'  || ch == ']' || ch == ')' ) {
				
				
				char lastPop = '\0';
				
				try {
					lastPop = openParenthesisStack.pop();
				} catch (EmptyStackException e) {
					return false;
				}
			
				if (lastPop == '{' && ch != '}') {
					return false;
				}
				if (lastPop == '[' && ch != ']') {
					return false;
				}
				if (lastPop == '(' && ch != ')') {
					return false;
				}
			}
			if  (ch == '{'  || ch == '[' || ch == '(' ) {
			
				openParenthesisStack.add(ch);
			}
		}
		return true;
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
				System.out.println(Arrays.toString((Object[]) o));
			} catch (Exception e) {
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
