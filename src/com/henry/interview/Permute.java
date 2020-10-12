package com.henry.interview;

import java.util.ArrayList;
import java.util.List;

public class Permute {

	public static void main(String[] args) {
		Permute permute = new Permute();
		
		System.out.println (permute.permute(new int[] {1,2,3}).get(5));
	}
	public List<List<Integer>> permute(int[] nums) {
	    List<List<Integer>> result = new ArrayList<>();
	    helper(0, nums, result);
	    return result;
	}
	 
	private void helper(int start, int[] nums, List<List<Integer>> result){
	    if(start==nums.length-1){
	        ArrayList<Integer> list = new ArrayList<>();
	        for(int num: nums){
	            list.add(num);
	        }
	        result.add(list);
	        return;
	    }
	 
	    for(int i=start; i<nums.length; i++){
	        swap(nums, i, start);
	        helper(start+1, nums, result);
	        swap(nums, i, start);
	    }
	}
	 
	private void swap(int[] nums, int i, int j){
	    int temp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = temp;
	}
}
