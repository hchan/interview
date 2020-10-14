package com.henry.interview;

import java.util.ArrayList;
// https://leetcode.com/problems/combination-sum/
import java.util.Arrays;
import java.util.*;

class CombinationSum {
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> result = new ArrayList<>();
	        combinationSum(0, target, 0, candidates, new Stack<>(), result);
	        
	        return result;
	    }
	    
	    private void combinationSum(int index, int target, int sum, int[] candidates, 
	                                Stack<Integer> current, List<List<Integer>> result) {
	        if (index == candidates.length ) {
	            return;
	        }
	        
	        if (sum + candidates[index] > target) {
	            combinationSum(index + 1, target, sum, candidates, current, result);
	            return;
	        }
	        
	        current.add(candidates[index]);
	        sum += candidates[index];
	        
	        if (sum == target) {
	            result.add(new ArrayList<>(current));
	            current.pop();
	            combinationSum(index + 1, target, sum - candidates[index], candidates, current, result);
	            return;
	        }
	        
	        combinationSum(index, target, sum, candidates, current, result);
	        current.pop();
	        combinationSum(index + 1, target, sum - candidates[index], candidates, current, result);
	    }
}