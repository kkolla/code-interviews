package array;

import java.util.Arrays;

import utils.CreateUtils;
import utils.PrintUtils;

/*
 * Given an input array of integers of size n, and a query array of 
 * integers, find the smallest window of input array that 
 * contains all the elements of query array and also in the same order
 */
public class FindSmallestWindowForQueryArray {

	public static void findWindow(int[] arr, int[] query) {
		int start = -1, end = -1;
		if (arr.length != 0 && query.length != 0 && arr.length >= query.length) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == query[0]) {
					int j = i;
					int k = 0;
					while (j < arr.length) {
						if (arr[j] == query[k])
							k++;
						if (k == query.length)
							break;
						j++;
					}
					if (k == query.length) {
						if (start == -1 || j - i < end - start) {
							start = i;
							end = j;
						}
					} else {
						break;
					}
				}
			}
		}
		if (start == -1) {
			System.out.println("query array is not a subarray");
		} else {
			PrintUtils.printArray(Arrays.copyOfRange(arr, start, end + 1));
		}
	}

	public static void main(String[] args) {
		int[] arr = CreateUtils.createRandomIntArray(20, 10);
		int[] query = CreateUtils.createRandomIntArray(5, 10);
		PrintUtils.printArray(arr);
		PrintUtils.printArray(query);
		findWindow(arr, query);
	}

}
