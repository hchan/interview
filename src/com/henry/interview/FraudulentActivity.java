package com.henry.interview;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FraudulentActivity {

	// Complete the activityNotifications function below.
	static int activityNotifications(int[] expenditure, int d) {
		int retval = 0;

		List<Integer> prior = new ArrayList<Integer>();
		for (int i = 0; i < d; i++) {
			prior.add(new Integer(i));
		}
		float median = getMedian(prior);
		for (int i = d; i < expenditure.length; i++) {
			if (expenditure[i] >= 2f * median) {
				retval++;
			}
			prior.remove(prior.get(0));
			addToSortedList(prior, expenditure[i]);
			// addToSortedList(expenditure[i], prior);
			// Collections.sort(prior);
			median = getMedian(prior);

		}
		return retval;
	}


	private static void addToSortedList(List<Integer> list, int toAdd) {
		list.add(toAdd);
		Collections.sort(list);
	}


	static float getMedian(List<Integer> list) {

		if (list.size() % 2 == 1) {
			return (list.get(list.size() / 2));
		} else {
			int left = list.get(list.size() / 2 - 1);
			int right = list.get(list.size() / 2);
			return ((float) ((left + right) / 2f));
		}

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("c:\\temp\\myout.txt"));

		String[] nd = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nd[0]);

		int d = Integer.parseInt(nd[1]);

		int[] expenditure = new int[n];

		String[] expenditureItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int expenditureItem = Integer.parseInt(expenditureItems[i]);
			expenditure[i] = expenditureItem;
		}

		int result = activityNotifications(expenditure, d);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
