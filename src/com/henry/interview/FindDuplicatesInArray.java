package com.henry.interview;
import java.util.*;
// https://leetcode.com/problems/find-all-duplicates-in-an-array
// Time: O(n)
// Space: O(n)
public class FindDuplicatesInArray {

	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]);
			if (nums[index] < 0) {
				result.add(index+1);
			}
			nums[index] = -nums[index];
		}
		return result;
	}

}
