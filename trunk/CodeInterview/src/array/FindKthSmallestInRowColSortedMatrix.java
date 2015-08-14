package array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthSmallestInRowColSortedMatrix {

	// O(nmlog(nm)): put all elements to 1-d array and sort
	
	public static class Cell {
		int x;
		int y;
		int value;
		
		public Cell(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}

		
	}

	// O(klogk)
	public static int findKth(int[][] m, int k) {
		int rows = m.length, cols = m[0].length;
		PriorityQueue<Cell> heap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
			@Override
			public int compare(Cell o1, Cell o2) {
				return new Integer(o1.value).compareTo(new Integer(o2.value));
			}
		});
		Cell c = new Cell(0, 0, m[0][0]);
		heap.add(c);
		boolean[][] visited = new boolean[rows][cols];
		for (int i = 1; i <= k - 1; i++) {
			Cell cell = heap.poll();
			int row = cell.x;
			int col = cell.y;
			if (row + 1 < rows && !visited[row + 1][col]) {
				heap.add(new Cell(row + 1, col, m[row + 1][col]));
				visited[row + 1][col] = true;
			}
			if (col + 1 < cols && !visited[row][col + 1]) {
				heap.add(new Cell(row, col + 1, m[row][col + 1]));
				visited[row][col + 1] = true;
			}
		}
		return heap.peek().value;
	}

	public static void main(String[] args) {
		int[][] m = { { 1, 3, 5, 6 }, { 2, 4, 8, 8 }, { 8, 10, 11, 12 } };
		for (int i = 1; i <= 12; i++) {
			System.out.println(findKth(m, i));
		}
	}

}
