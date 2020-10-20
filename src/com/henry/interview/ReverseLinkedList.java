package com.henry.interview;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class ReverseLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/* Function to print linked list */
	static void print(Node node) {
		Node temp = node;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	static Node push(Node node, int data) {
		Node temp = new Node(data);
		node.next = temp;
		return temp;
	}

	/* Driver program to test above function */
	public static void main(String args[]) {
		/* Start with the empty list */
		Node root = new Node(5); // head of list
		Node temp = null;
		temp = push(root, 20);
		temp = push(temp, 4);
		temp = push(temp, 15);
		temp = push(temp, 85);
		temp = push(temp, 55);
		System.out.println("Given linked list");
		print(root);
		System.out.println("Reverse linked list");
		root = reverse(root);
		print(root);
	}

	private static Node reverse(Node node) {
		if (node == null) {
			return null;
			
		}
		Node curr = node;
		Node prev = null;
		Node next = node.next;
		
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	private static Node reverseOld(Node node) {
		if (node == null || node.next == null) {
			return null;
		}
		Node curr = node;
		Node prev = null;
		Node next = node.next;
	
		
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		
		
		return prev;
	}
}
