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
	}

}
