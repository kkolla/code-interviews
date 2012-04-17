package probability;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * http://blogs.msdn.com/b/spt/archive/2008/02/05/reservoir-sampling.aspx
 */
public class ReservoirSampling {

	public static int[] sample(int n, Iterator<Integer> stream)
			throws Exception {
		int[] values = new int[n];
		int k = 0;
		while (k < n) {
			if (!stream.hasNext())
				throw new Exception("the stream has less than " + n
						+ " values!");
			values[k] = stream.next();
			k++;
		}
		while (stream.hasNext()) {
			k++;
			int next = stream.next();
			// select next with the probability n/k
			if (k * Math.random() < n) {
				// next selected
				// swap with any value in the array with the probability 1/n
				int i = (int) (n * Math.random());
				System.out.println(next + " is selected to replace "
						+ values[i]);
				values[i] = next;
			}
			// for values not in the original array, the probability of
			// being chosen is n/k, for the values in the original array,
			// the probability is 1-(n/k)*(1/n)=(k-1)/k
		}
		return values;
	}

	public static void main(String[] args) throws Exception {
		int[] a = CreateUtils.createRandomIntArray(20, 10);
		PrintUtils.printArray(a);
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++)
			l.add(a[i]);
		PrintUtils.printArray(sample(5, l.iterator()));
	}

}
