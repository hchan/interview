package com.henry.interview;
import java.util.*;
// https://leetcode.com/problems/min-stack/
// O(1)
// O(n)
public class MinStack {

	private Stack<Integer> stack;
	private Stack<Integer> time;
	
	public MinStack() {
		stack = new Stack<Integer>();
		time = new Stack<Integer>();
	}
	
	public void push(int num) {
		stack.push(num);
		int min = time.isEmpty() || num < time.peek() ? num : time.peek();
		time.push(min);
	}
	
	public void pop() {
		stack.pop();
		time.pop();
	}
	
	public int top() {
		return stack.peek();
	}
	
	public int getMin() {
		return time.peek();
	}
}
