package sorting;

public class SelectionSort {

	public static void selectionSortRecursive(int[] a, int start) {
		if (start == a.length)
			return;
		// find index of minimum value
		int min = start;
		for (int i = start; i < a.length; i++)
			if (a[i] < a[min])
				min = i;
		// swap minimum with current start
		int temp = a[start];
		a[start] = a[min];
		a[min] = temp;
		// do recursively with start one step further
		selectionSortRecursive(a, start + 1);
	}

	public static void main(String[] args) {
		int[] a = { 3, 2, 1, 5, 2, 3, 4, 2, 1, 4, 5 };
		selectionSortRecursive(a, 0);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
	}

}
