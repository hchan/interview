package com.henry.interview;
import java.util.*;
public class PriorityQueueDemo { 
    
    // Main Method 
  public static void main(String args[]) 
  { 
	  
	 // System.out.println( new Integer(5).compareTo(new Integer(4)));
	  
	//  System.out.println( "C".compareTo("B"));
	  
      // Creating empty priority queue 
      PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>( (o1,o2) -> {
    	 return - o1.compareTo(o2); 
      });

      // Adding items to the pQueue using add() 
      pQueue.add(10); 
      pQueue.add(20); 
      pQueue.add(15); 

      // Printing the top element of PriorityQueue 
      System.out.println(pQueue.peek()); 

      // Printing the top element and removing it 
      // from the PriorityQueue container 
      System.out.println(pQueue.poll()); 

      // Printing the top element again 
      System.out.println(pQueue.peek()); 
  } 
} 