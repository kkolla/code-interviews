package sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

import utils.CreateUtils;
import utils.PrintUtils;
import datastructure.Pair;

// buggy!
public class ExternalSort {

	// suppose data is can be partially loaded into memory
	public static int[] externalSort(int[] data, int memoryLimit) {
		// use output stream in real case
		int[] output = new int[data.length];
		int o = 0;

		System.out.print("array to be sorted (" + data.length + "):\t");
		PrintUtils.printArray(data);
		// first, divide data into chunks
		// load each chunk into memory, sort and set them back
		int chunks = data.length % memoryLimit == 0 ? data.length / memoryLimit
				: data.length / memoryLimit + 1;
		for (int i = 0; i < chunks; i++) {
			int start = i * memoryLimit;
			int end = start + memoryLimit < data.length ? start + memoryLimit
					: data.length;
			// simulate data loading from memory to disk
			int[] memory = new int[end - start];
			for (int j = start; j < end; j++)
				memory[j - start] = data[j];
			Arrays.sort(memory);
			// simulate writing back
			for (int j = start; j < end; j++)
				data[j] = memory[j - start];
			System.out.print(i + "th chunk sorted:\t\t");
			PrintUtils.printArray(data);
		}
		// second, load initial values to a heap of size chunks
		PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<Pair<Integer, Integer>>();
		int[] indices = new int[chunks];
		// output buffer
		int limit = memoryLimit / (chunks + 1);
		int[] buffer = new int[limit];
		int finished = 0;
		for (int i = 0; i < chunks; i++) {
			int j = chunks * i;
			heap.add(new Pair<Integer, Integer>(data[j], i));
			indices[i] = j + 1;
		}
		// third, do multi-way merge
		int b = 0;
		while (finished < chunks) {
			Pair<Integer, Integer> p = heap.poll();
			buffer[b++] = p.first;
			if (b == buffer.length) {
				for (int i = 0; i < buffer.length; i++)
					output[o++] = buffer[i];
				b = 0;
			}
			int index = p.second;
			if (indices[index] < (index + 1) * chunks
					&& indices[index] < index * chunks + limit) {
				heap.add(new Pair<Integer, Integer>(data[indices[index]], index));
				indices[index]++;
			} else if (indices[index] == (index + 1) * chunks
					|| indices[index] == data.length) {
				finished++;
			}
		}
		return output;
	}

	public static void main(String[] args) {
		int memoryLimit = 10;
		int[] data = CreateUtils.createRandomIntArray(100, 100);
		int[] disk = externalSort(data, memoryLimit);
		PrintUtils.printArray(disk);
	}

}
