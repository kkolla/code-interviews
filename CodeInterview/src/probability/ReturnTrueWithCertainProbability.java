package probability;

/*
 * given a function prob() with the same possibility 0.5 to 
 * return true or false, implement a function prob2(double p) 
 * which has probability p to return true, 1-p to return false
 * 
 * http://www.mitbbs.com/article/JobHunting/32055195_0.html
 */
public class ReturnTrueWithCertainProbability {

	// this is given
	public static boolean prob() {
		return Math.random() < 0.5 ? true : false;
	}

	public static boolean prob2(double p) {
		assert (p >= 0 && p <= 1);
		double low = 0, high = 1.0;
		while (true) {
			double mid = (low + high) / 2;
			// use true returned by prob() to indicate
			// we generate a number in the left half
			// use false to indicate the right half
			boolean isLeftHalf = prob();
			// if low <= p <= (low+high)/2, and the generated probability is on
			// the right, which surely is greater than p
			if (p <= mid && !isLeftHalf)
				return false;
			else if (p <= mid && isLeftHalf)
				high = mid;
			else if (p > mid && !isLeftHalf)
				low = mid;
			// if (low+high)/2 < p <= high, and the generated probability is one
			// the left, which surely is less than p
			else
				return true;
		}
	}

	public static void main(String[] args) {
		int count = 0;
		for (int i = 0; i < 10000; i++)
			if (prob2(0.33))
				count++;
		System.out.println(count);
	}
}
