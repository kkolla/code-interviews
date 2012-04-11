package utils;

import java.util.List;
import java.util.Map;

import linkedlist.Node;

public class PrintUtils {

	public static void printList(List list) {
		if (list == null) {
			System.out.println("null list");
			return;
		}
		if (list.size() == 0) {
			System.out.println("empty list");
			return;
		}
		for (Object obj : list) {
			System.out.print(obj + " ");
		}
		System.out.println();
	}

	public static void printLinkedList(Node head) {
		if (head == null) {
			System.out.println("null linked list");
			return;
		}
		Node n = head;
		while (n != null) {
			System.out.print(n.value + " ");
			n = n.next;
		}
		System.out.println();
	}

	public static void printArray(int[] arr) {
		if (arr == null) {
			System.out.println("null array");
			return;
		}
		if (arr.length == 0) {
			System.out.println("empty array");
			return;
		}
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void printArray(Object[] arr) {
		if (arr == null) {
			System.out.println("null array");
			return;
		}
		if (arr.length == 0) {
			System.out.println("empty array");
			return;
		}
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void printMap(Map map) {
		for (Object entry : map.entrySet()) {
			Map.Entry<Object, Object> e = (Map.Entry<Object, Object>) entry;
			System.out.println("Key: " + e.getKey() + "\tValue: "
					+ e.getValue());
		}
	}
}
