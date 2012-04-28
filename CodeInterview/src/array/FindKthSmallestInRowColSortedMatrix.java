package array;

import java.util.PriorityQueue;

import datastructure.Pair;

public class FindKthSmallestInRowColSortedMatrix {

	// O(nmlog(nm)): put all elements to 1-d array and sort

	// O(klogk)
	public static int findKth(int[][] m, int k) {
		int rows = m.length, cols = m[0].length;
		PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> heap = new PriorityQueue<Pair<Integer, Pair<Integer, Integer>>>();
		heap.add(new Pair<Integer, Pair<Integer, Integer>>(m[0][0],
				new Pair<Integer, Integer>(0, 0)));
		boolean[][] visited = new boolean[rows][cols];
		for (int i = 1; i <= k - 1; i++) {
			Pair<Integer, Pair<Integer, Integer>> p = heap.poll();
			int row = p.second.first;
			int col = p.second.second;
			if (row + 1 < rows && !visited[row + 1][col]) {
				heap.add(new Pair<Integer, Pair<Integer, Integer>>(
						m[row + 1][col], new Pair<Integer, Integer>(row + 1,
								col)));
				visited[row + 1][col] = true;
			}
			if (col + 1 < cols && !visited[row][col + 1]) {
				heap.add(new Pair<Integer, Pair<Integer, Integer>>(
						m[row][col + 1], new Pair<Integer, Integer>(row,
								col + 1)));
				visited[row][col + 1] = true;
			}
		}
		return heap.peek().first;
	}

	public static void main(String[] args) {
		int[][] m = { { 1, 3, 5, 6 }, { 2, 4, 8, 8 }, { 8, 10, 11, 12 } };
		for (int i = 1; i <= 12; i++) {
			System.out.println(findKth(m, i));
		}
	}

}
