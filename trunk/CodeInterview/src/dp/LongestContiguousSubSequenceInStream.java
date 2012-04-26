package dp;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
 * you are going to take some numbers as an input from a file. You need to 
 * witer a program to find longest increasing sequence. You should process it 
 * as soon as you are taking an input. After finishing the last input 
 * immediately you should be able to tell the sequence. Input: 1 5 3 4 6 4 
 * Output: 3 4 6
 */
public class LongestContiguousSubSequenceInStream {

	Queue<Integer> queue = new LinkedList<Integer>();
	int maxLength = 0;
	int currLength = 0;
	int prev = Integer.MIN_VALUE;

	public void addNumber(int n) {
		int size = queue.size();
		queue.add(n);
		if (n > prev) {
			currLength++;
			if (currLength > maxLength) {
				maxLength = currLength;
				for (int i = 0; i < size - maxLength + 1; i++)
					queue.poll();
			}
		} else {
			currLength = 1;
		}
		prev = n;
		Iterator<Integer> iter = queue.iterator();
		for (int i = 0; i < maxLength; i++)
			System.out.print(iter.next() + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] stream = { 1, 5, 3, 1, 0, 4, 6, 6, 4, 7, 8, 9, 10 };
		LongestContiguousSubSequenceInStream lis = new LongestContiguousSubSequenceInStream();
		for (int i = 0; i < stream.length; i++)
			lis.addNumber(stream[i]);
	}

}
