package com.henry.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReorderLogs {

	public static void main(String[] args) {
		String[] logs = new String[] { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig",
				"let3 art zero" };
		ReorderLogs soln = new ReorderLogs();
		System.out.println(Arrays.deepToString( soln.reorderLogFiles(logs)));
		//		["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]

	}

	// https://medium.com/@akshay_ravindran/day-40-reorder-data-log-files-40abfc9a98e0
	
	public String[] reorderLogFiles(String[] logs) {
        
        Arrays.sort(logs, (a,b)->{
            int identA = a.indexOf(" ") + 1;
            int identB = b.indexOf(" ") + 1;

            boolean isLetterA = Character.isLetter(a.charAt(identA));
            boolean isLetterB = Character.isLetter(b.charAt(identB));
            if(isLetterA && isLetterB){
                int cmp = a.substring(identA).compareTo(b.substring(identB));
                if(cmp != 0) return cmp;
                
                return a.compareTo(b);
            }else if(isLetterA && !isLetterB){
                return -1;
            }else if(!isLetterA && isLetterB){
                return 1;
            }else return 0;
            
        });
        
        return logs;
    }

}
