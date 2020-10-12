package com.henry.interview;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentlyMentionedKeywords {

	public static void main(String[] args) {
		TopKFrequentlyMentionedKeywords soln = new TopKFrequentlyMentionedKeywords();
		/*
		List<String> obj = soln.solve(2, new String[] {"anacell", "cetracular", "betacellular"}, new String[] { "Anacell provides the best services in the city",
				  "betacellular has awesome services",
				  "Best services provided by anacell, everyone should use anacell"});
				  */
		List<String> obj = soln.solve(2, new String[] {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"}, new String[] { "I love anacell Best services; Best services provided by anacell",
				  "betacellular has great services",
				  "deltacellular provides much better services than betacellular",
				  "cetracular is worse than anacell",
				  "Betacellular is better than deltacellular."});
		System.out.println(Arrays.toString(obj.toArray()));
	}

	private List<String> solve(int k, String[] keywords, String[] reviews) {
		HashMap<String, Integer> keywordToCount = new HashMap<String, Integer>();
		for (String keyword : keywords) {
			keywordToCount.put(keyword, 0);
		}
		
		for (String review : reviews) {
			String[] reviewWords = review.split(" ");
			for (String reviewWord : reviewWords) {
				reviewWord = reviewWord.toLowerCase();
				if (Arrays.stream(keywords).anyMatch(reviewWord::equals)) {
					int curCount = keywordToCount.get(reviewWord);
					curCount++;
				
					keywordToCount.put(reviewWord, curCount);
					break;
				}
			}
		}
		keywordToCount = sortByValues(keywordToCount);
		System.out.println(keywordToCount);
		return keywordToCount.keySet().stream().collect(Collectors.toList()).subList(0, k);
	}

	
	 private HashMap sortByValues(HashMap map) { 
	       List list = new LinkedList(map.entrySet());
	       // Defined Custom Comparator here
	       Collections.sort(list, new Comparator() {
	            public int compare(Object o1, Object o2) {
	               int retval = - ((Comparable) ((Map.Entry) (o1)).getValue())
	                  .compareTo(((Map.Entry) (o2)).getValue());
	               
	               if (retval == 0) {
	            	   retval =  -((Comparable) ((Map.Entry) (o1)).getKey())
	     	                  .compareTo(((Map.Entry) (o2)).getKey());
	               }
	               return retval;
	            }
	       });

	       // Here I am copying the sorted list in HashMap
	       // using LinkedHashMap to preserve the insertion order
	       HashMap sortedHashMap = new LinkedHashMap();
	       for (Iterator it = list.iterator(); it.hasNext();) {
	              Map.Entry entry = (Map.Entry) it.next();
	              sortedHashMap.put(entry.getKey(), entry.getValue());
	       } 
	       return sortedHashMap;
	  }
}
