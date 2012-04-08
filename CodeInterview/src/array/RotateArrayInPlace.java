package array;

public class RotateArrayInPlace {

	public static void reverseSubArray(int[] a, int from, int to) {
		while (from <= to) {
			int temp = a[from];
			a[from] = a[to];
			a[to] = temp;
			from++;
			to--;
		}
	}

	public static int[] rotateKPlacesToRight(int[] a, int k) {
		if (k >= 0)
			k = k % a.length;
		else
			k = (-(-k) % a.length + a.length) % a.length;
		reverseSubArray(a, 0, a.length - 1);
		reverseSubArray(a, 0, k - 1);
		reverseSubArray(a, k, a.length - 1);
		return a;
	}

	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 3, 4, 5 };
		a = rotateKPlacesToRight(a, -4);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
	}

}
