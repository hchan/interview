package com.henry.interview;
import java.util.*;
public class CharStuff {

	public static void main(String[] args) {
		System.out.println(new Character('0').compareTo(new Character('9')));
		System.out.println(new Character('A').compareTo(new Character('0')));
		
		System.out.println("------------------");
		System.out.println((int) (new Character('0')));
		System.out.println((int) (new Character('A')));
		System.out.println((int) (new Character('a')));
		
		List<Character> myChars = new ArrayList<Character>();
		for (char ch = 'a'; ch <= 'z'; ch++) {
			myChars.add(ch);
		}
		
		System.out.println(Arrays.toString(myChars.toArray()));
		char ch = '9';
		int intValOfCh = ch - '0';
		System.out.println(intValOfCh);
		
		System.out.println('4' - '0' + 3);
		
		System.out.println('a');
		for (int i = 0; i < 26; i++) {
			char ch2 = 'a';
			ch2++;
			int ch2Int = (int)ch2 + i;
			ch = (char) ch2Int;
			String s = String.valueOf(ch);
			System.out.println(String.valueOf('z'));
			System.out.println(Character.toUpperCase('z'));
			System.out.println(s);
		}
		char[] x = String.valueOf(54321).toCharArray();
		Arrays.sort(x );
		System.out.println(String.valueOf(x));
		
		char c = 'c';
		c++;
		char d = c;
		System.out.println(d + "og");
	}

}
