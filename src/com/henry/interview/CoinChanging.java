package com.henry.interview;

import java.util.Arrays;

class CoinChanging{
	  static int solveCoinChange(int[] denominations, int amount) {
	    int[] solution = new int[amount + 1]; 
	    solution[0] = 1;
	  
	    for (int den: denominations) {
	      for (int i = den; i < (amount + 1); ++i) {
	        solution[i] += solution[i - den]; 
	      }
	    }
	    
	    
	    for (int i = 0; i < solution.length; i++) {
	    	
	    	System.out.println( i + "," + solution[i]);
	    }
	    return solution[solution.length - 1];
	  }
	  public static void main(String[] args) {

	    int[] denominations = new int[] {2, 3, 5};
	    int amount = 100;
	    int result = solveCoinChange(denominations, amount); 
	    System.out.print("SolveCoinChange(" + Arrays.toString(denominations) +  ", " + amount + ") = ");
	    System.out.print(result);
	  }
	}  