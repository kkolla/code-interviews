package calculation;

public class MultiplicationExcludeSelf {

	public static int[] multiply(int a[]) {
		int n = a.length;
		int[] output = new int[n];
		for (int i = 0; i < n; i++)
			output[i] = 1;
		int left = 1, right = 1;
		for (int i = 0; i < n; i++) {
			output[i] *= left;
			output[n - 1 - i] *= right;
			left *= a[i];
			right *= a[n - 1 - i];
		}
		return output;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = multiply(a);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}

}
