package array;

public class FindRotationTimes {

	public static int rotationTimes(int[] a) {
		int l = 0, r = a.length - 1;
		while (a[l] > a[r]) {
			int m = (r - l) / 2 + l;
			if (a[m] > a[r])
				l = m + 1;
			else
				r = m;
		}
		return l;
	}

	public static void main(String[] args) {
		System.out.println(rotationTimes(new int[] { 6, 1, 2, 3, 4, 5 }));
	}

}
