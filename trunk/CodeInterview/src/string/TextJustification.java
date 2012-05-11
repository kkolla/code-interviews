package string;

import java.util.ArrayList;

import utils.PrintUtils;

/*
 * Given an array of words and a length L, format the text such that each line 
 * has exactly L characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words 
 * as you can in each line. Pad extra spaces ' ' when necessary so that each 
 * line has exactly L characters. Extra spaces between words should be distributed 
 * as evenly as possible. If the number of spaces on a line do not divide evenly
 * between words, the empty slots on the left will be assigned more spaces than 
 * the slots on the right. For the last line of text, it should be left justified 
 * and no extra space is inserted between words.
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * Return the formatted lines as:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * 
 */

// buggy for large input
public class TextJustification {

	public static ArrayList<String> justify(String[] words, int l) {
		ArrayList<String> output = new ArrayList<String>();
		if (words.length == 0 || l <= 0) {
			output.add("");
			return output;
		}
		int start = 0, end = 0;
		int length = words[0].length();
		for (int i = 1; i < words.length; i++) {
			String word = words[i];
			if (length + 1 + word.length() <= l) {
				length = length + 1 + word.length();
				end = i;
			} else {
				output.add(justifyLine(words, start, end, l, false));
				start = end = i;
				length = words[start].length();
			}
		}
		output.add(justifyLine(words, start, end, l, true));
		return output;
	}

	public static String justifyLine(String[] words, int start, int end, int l,
			boolean lastLine) {
		if (start == end)
			return words[start] + spaces(l - words[start].length());
		int totalLength = 0;
		for (int i = start; i <= end; i++)
			totalLength += words[i].length();
		if (lastLine) {
			String s = words[start];
			for (int i = start + 1; i <= end; i++)
				s += spaces(1) + words[i];
			s += spaces(l - totalLength - (end - start));
			return s;
		} else {
			boolean even = (l - totalLength) % (end - start) == 0;
			String s = words[start];
			for (int i = start + 1; i <= end; i++) {
				int ss = i == start + 1 && !even ? (l - totalLength)
						/ (end - start) + (l - totalLength) % (end - start)
						: (l - totalLength) / (end - start);
				s += spaces(ss) + words[i];
			}
			return s;
		}
	}

	public static String spaces(int n) {
		String s = "";
		for (int i = 0; i < n; i++)
			s += " ";
		return s;
	}

	public static void main(String[] args) {
		String[] words = { "This", "is", "an", "example", "of", "text",
				"justification." };
		int l = 16;
		PrintUtils.printList(justify(words, l));
	}

}
