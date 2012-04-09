package utils;

import java.util.List;
import java.util.Map;

import linkedlist.Node;

public class PrintUtils {

	public static void printList(List list) {
		for (Object obj : list) {
			System.out.print(obj + " ");
		}
		System.out.println();
	}

	public static void printLinkedList(Node head) {
		Node n = head;
		while (n != null) {
			System.out.print(n.value + " ");
			n = n.next;
		}
		System.out.println();
	}

	public static void printArray(Object[] arr) {
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
