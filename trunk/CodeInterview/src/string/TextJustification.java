package string;

import java.util.ArrayList;
import java.util.List;

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

public class TextJustification {


	public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        if (words.length == 0) return result;
        
        int lineTotalWordLength = words[0].length();
        int lineStartWordIndex = 0, lineEndWordIndex = 0;
        
        for (int i = 1; i < words.length; i++) {
        	String word = words[i];
        	// check if the word can be added to the current line
        	int numSpacesBetweenWords = lineEndWordIndex - lineStartWordIndex + 1;
        	int len = lineTotalWordLength + numSpacesBetweenWords + word.length();
        	if (len <= maxWidth) {
        		// the word can be added to the current line
        		// update the end index and total length
        		lineEndWordIndex = i;
        		lineTotalWordLength += word.length();
        	} else {
        		// the word cannot be added, so we can construct a line 
        		String line = createLine(words, maxWidth, lineStartWordIndex, lineEndWordIndex, lineTotalWordLength, false);
        		result.add(line);
        		// update the total length, start and end index
        		lineTotalWordLength = word.length();
        		lineStartWordIndex = i;
        		lineEndWordIndex = i;
        	}
        }
        
        // the last line hasn't been added yet
        result.add(createLine(words, maxWidth, lineStartWordIndex, lineEndWordIndex, lineTotalWordLength, true));
        
        return result;
    }
	
	private static String createLine(String[] words, int maxWidth, int lineStartWordIndex, int lineEndWordIndex, int lineTotalWordLength, boolean isLastLine) {
		StringBuilder sb = new StringBuilder(words[lineStartWordIndex]);
		
		int numWordsInLine = lineEndWordIndex - lineStartWordIndex + 1;
		if (numWordsInLine == 1 || isLastLine) {
			// if there's only one word in the line, or it's the last line,
			// there must be only one space between words
			for (int i = lineStartWordIndex + 1; i <= lineEndWordIndex; i++) {
				sb.append(" " + words[i]);
			}
			// we need to left justify the word by appending remaining spaces on the right
			int numSpacesBetweenWords = numWordsInLine - 1;
			int numRemainingSpaces = maxWidth - lineTotalWordLength - numSpacesBetweenWords;
			sb.append(spaces(numRemainingSpaces));
		} else {
			// justify a line, by computing the minimum number of spaces between words 
			// and the number of words needing one extra space
			int numSpaceSlots = numWordsInLine - 1;
			int minNumSpacesBetweenWords = (maxWidth - lineTotalWordLength) / numSpaceSlots;
			int numWordsWithExtraSpace = (maxWidth - lineTotalWordLength) % numSpaceSlots;
			for (int i = lineStartWordIndex + 1; i <= lineEndWordIndex; i++) {
				int numSpaces = i - lineStartWordIndex - 1 < numWordsWithExtraSpace ? minNumSpacesBetweenWords + 1 : minNumSpacesBetweenWords;
				sb.append(spaces(numSpaces));
				sb.append(words[i]);
			}
		}
		
		return sb.toString();
	}
	

	public static String spaces(int n) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < n; i++)
			sb.append(" ");
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] words = { "This", "is", "an", "example", "of", "text",
				"justification." };
		String[] words2 = {"a", "b", "c", "d"};
		int l = 16;
		for (String line : fullJustify(words, l))
			System.out.println(line);
	}

}
