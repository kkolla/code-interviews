package utils;

import graph.Vertex;

import java.util.List;
import java.util.Map;

import linkedlist.ListNode;
import tree.LevelByLevelTraversal;

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

	public static void printLinkedList(ListNode head) {
		if (head == null) {
			System.out.println("null linked list");
			return;
		}
		ListNode n = head;
		while (n != null) {
			System.out.print(n.val + " ");
			n = n.next;
		}
		System.out.println();
	}

	public static void printArray(int[] a) {
		if (a == null) {
			System.out.println("null array");
			return;
		}
		if (a.length == 0) {
			System.out.println("empty array");
			return;
		}
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	public static void printArray(double[] a) {
		if (a == null) {
			System.out.println("null array");
			return;
		}
		if (a.length == 0) {
			System.out.println("empty array");
			return;
		}
		for (int i = 0; i < a.length; i++)
			System.out.printf("%.2f" + " ", a[i]);
		System.out.println();
	}

	public static void printArray(Object[] a) {
		if (a == null) {
			System.out.println("null array");
			return;
		}
		if (a.length == 0) {
			System.out.println("empty array");
			return;
		}
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	public static void printMap(Map map) {
		for (Object entry : map.entrySet()) {
			Map.Entry<Object, Object> e = (Map.Entry<Object, Object>) entry;
			System.out.println("Key: " + e.getKey() + "\tValue: "
					+ e.getValue());
		}
	}

	public static void printBinaryTree(tree.TreeNode root) {
		if (root == null)
			System.out.println("null binary tree");
		else
			LevelByLevelTraversal.traverseByLevel(root);
	}

	public static void print2DArray(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			printArray(m[i]);
		}
	}

	public static void printGraphDepthFirst(Vertex v) {
		System.out.print(v.value + ", neighbors: ");
		for (Vertex n : v.neighbors) {
			System.out.print(n.value + " ");
		}
		System.out.println();
		for (Vertex n : v.neighbors) {
			printGraphDepthFirst(n);
		}

	}
}
