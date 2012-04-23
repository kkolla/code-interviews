package array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import utils.CreateUtils;
import utils.PrintUtils;
import datastructure.Pair;

public class MergeKSortedArrays {

	// suppose each of the k arrays contains n elements
	// so there are kn elements in total
	// we do kn times of heapify, each heapify taking log(k)
	// so the total time complexity is O(knlog(k))
	// without heap it is gonna be O(kkn)?
	public static List<Integer> merge(int[][] a) {
		List<Integer> l = new ArrayList<Integer>();
		PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<Pair<Integer, Integer>>();
		int k = a.length;
		int[] indices = new int[k];
		int finished = 0;
		for (int i = 0; i < k; i++) {
			if (a[i].length != 0) {
				heap.add(new Pair<Integer, Integer>(a[i][0], i));
				indices[i]++;
			} else {
				finished++;
			}
		}
		while (finished < k) {
			Pair<Integer, Integer> p = heap.poll();
			l.add(p.first);
			int index = p.second;
			if (indices[index] < a[index].length) {
				heap.add(new Pair<Integer, Integer>(a[index][indices[index]],
						index));
				indices[index]++;
			} else {
				finished++;
			}
		}
		return l;
	}

	public static void main(String[] args) {
		int k = 5;
		int[][] a = new int[k][];
		for (int i = 0; i < k; i++) {
			a[i] = CreateUtils.randSortedNonNegIntArray(10, 10);
			PrintUtils.printArray(a[i]);
		}
		PrintUtils.printList(merge(a));
	}
}
