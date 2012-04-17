package utils;

import graph.Graph;
import graph.Vertex;
import interval.Interval;

import java.util.Arrays;

public class CreateUtils {

	public static tree.Node createBSTWithTenNodes() {
		tree.Node n1 = new tree.Node(1);
		tree.Node n3 = new tree.Node(3);
		tree.Node n2 = new tree.Node(2, n1, n3);
		n1.parent = n3.parent = n2;
		tree.Node n7 = new tree.Node(7);
		tree.Node n10 = new tree.Node(10);
		tree.Node n9 = new tree.Node(9, null, n10);
		n10.parent = n9;
		tree.Node n5 = new tree.Node(5);
		tree.Node n4 = new tree.Node(4, n2, n5);
		n2.parent = n5.parent = n4;
		tree.Node n8 = new tree.Node(8, n7, n9);
		n7.parent = n9.parent = n8;
		tree.Node root = new tree.Node(6, n4, n8);
		n4.parent = n8.parent = root;
		return root;
	}

	public static linkedlist.Node createSortedLinkedListFromOneToN(int n) {
		if (n < 1)
			return null;
		linkedlist.Node head = new linkedlist.Node(1);
		linkedlist.Node curr = head;
		linkedlist.Node prev = null;
		for (int i = 2; i <= n; i++) {
			curr.next = new linkedlist.Node(i);
			curr.prev = prev;
			prev = curr;
			curr = curr.next;
		}
		return head;
	}

	public static linkedlist.Node createRandomLinkedList(int maxLength,
			int maxValue) {
		int n = randomNonNegative(maxLength);
		if (n == 0)
			return null;
		linkedlist.Node head = new linkedlist.Node(randomNonNegative(maxValue));
		linkedlist.Node t = head;
		for (int i = 1; i < n; i++) {
			t.next = new linkedlist.Node(randomNonNegative(maxValue));
			t = t.next;
		}
		return head;
	}

	public static Interval[] createRandomIntIntervals(int maxLength,
			int maxValue) {
		int n = randomNonNegative(maxLength);
		Interval[] intervals = new Interval[n];
		for (int i = 0; i < n; i++) {
			double begin = randomNonNegative(maxValue);
			double end = begin;
			while (end <= begin)
				end = randomNonNegative(maxValue);
			intervals[i] = new Interval(begin, end);
		}
		return intervals;
	}

	public static int[] createRandomIntArray(int maxLength, int maxValue) {
		int n = randomNonNegative(maxLength);
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = randomNonNegative(maxValue);
		}
		return arr;
	}

	public static int[] createRandomSortedIntArray(int maxLength, int maxValue) {
		int[] arr = createRandomIntArray(maxLength, maxValue);
		Arrays.sort(arr);
		return arr;
	}

	public static double[] createRandomRealArray(int maxLength) {
		int n = randomNonNegative(maxLength);
		double[] arr = new double[n];
		for (int i = 0; i < n; i++) {
			arr[i] = (Math.random() > 0.5 ? -1 : 1) * randomNonNegative(10);
		}
		return arr;
	}

	public static String[] createRandomStringArray(int maxLength,
			int maxStringLength, boolean hasSpace) {
		int n = randomNonNegative(maxLength);
		String[] arr = new String[n];
		char[] alphabet = hasSpace ? "abcdefghijklmnopqrstuvwxyz "
				.toCharArray() : "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for (int i = 0; i < n; i++) {
			arr[i] = "";
			int size = randomNonNegative(maxStringLength);
			StringBuffer sb = new StringBuffer("");
			for (int j = 0; j < size; j++)
				sb.append(alphabet[randomNonNegative(alphabet.length)]);
			arr[i] = sb.toString();
		}
		return arr;
	}

	public static int randomNonNegative(int maxExclusive) {
		return (int) (Math.random() * maxExclusive);
	}

	public static int[][] createRandom2DIntArray(int maxLength, int maxValue,
			boolean isSquare) {
		int rows = randomNonNegative(maxLength);
		rows = rows == 0 ? 1 : rows;
		int cols = isSquare ? rows : randomNonNegative(maxLength);
		cols = cols == 0 ? 1 : cols;
		int[][] m = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++)
				m[i][j] = randomNonNegative(maxValue);
		}
		return m;
	}

	public static Vertex createDAGWithSevenVertices() {
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		Vertex v6 = new Vertex(6);
		Vertex v7 = new Vertex(7);
		v1.neighbors.add(v2);
		v1.neighbors.add(v3);
		v2.neighbors.add(v4);
		v2.neighbors.add(v5);
		v3.neighbors.add(v5);
		v4.neighbors.add(v6);
		v5.neighbors.add(v6);
		v6.neighbors.add(v7);
		return v1;
	}

	public static Graph createDAGWithEightVertices() {
		return new Graph(
				new String[] { "A", "B", "C", "D", "E", "F", "G", "H" },
				new int[][] { { 0, 1, 1, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 1, 1, 0 },
						{ 0, 0, 0, 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1 },
						{ 0, 0, 0, 0, 0, 0, 0, 0 } });
	}
}