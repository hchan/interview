package com.henry.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReorderLogs {

	public static void main(String[] args) {
		String[] logs = new String[] { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig",
				"let3 art zero" };

		System.out.println(Arrays.toString(logs));
		System.out.println(Arrays.toString(reorderLogFiles(logs)));
		//		["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]

	}

	// https://medium.com/@akshay_ravindran/day-40-reorder-data-log-files-40abfc9a98e0
	
	public static String[] reorderLogFiles(String[] logs) {
	
		String [] retval = new String [logs.length];
		List<String> letterLogs = new ArrayList<String>();
		List<String> numberLogs = new ArrayList();
		for (String log : logs) {
			if (isDigitLog(log)) {
				numberLogs.add(log);
			} else {
				letterLogs.add(log);
			}
		}
		Collections.sort(letterLogs, (o1, o2) -> {
			String[] s1 = o1.split(" ");
			String[] s2 = o2.split(" ");
			int len1 = s1.length;
			int len2 = s2.length;
			for (int i = 1; i < Math.min(len1, len2); i++) {
				if (!s1[i].equals(s2[i])) {
					return s1[i].compareTo(s2[i]);
				}
			}
			return s1[0].compareTo(s2[0]);
		});

		int index = 0;
		for (String log : letterLogs) {
			retval[index] = log;
			index++;
		}
		for (String log : numberLogs) {
			retval[index] = log;
			index++;
		}
		return retval;
	}

	private static boolean isDigitLog(String log) {
		for (int i = 0; i < log.length(); i++) {
			if (log.charAt(i) == ' ') {
				if (log.charAt(i+1) >= '0' && log.charAt(i+1) <= '9') { 
					// Character.isDigit(ch)
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

}
