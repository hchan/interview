package com.henry.interview;
import java.util.*;


public class Permutations2 {
	static List<String> soln = new ArrayList<String>();
	  // Function to print all the permutations of str 
    static void permute(String left, String right) 
    { 
    	if (left.length() == 0) {
    		soln.add(right);
    		return;
    	}
    	
    	for (int i = 0; i < left.length(); i++) {
    		char curChar = left.charAt(i);
    		
    		String preLeft = left.substring(0,i);
    		String postLeft = left.substring(i+1);
    		String newLeft = preLeft + postLeft;
    		permute(newLeft,     right + curChar);
    	}
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
        String s = "abcd"; 
        permute(s, ""); 
    	System.out.println(Arrays.toString(soln.toArray(new String[] {})));
    } 

}
