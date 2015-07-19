package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, 
 * for example: "ACGAATTCCG". When studying DNA, 
 * it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) 
 * that occur more than once in a DNA molecule.
 * For example,
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 *
 */
public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.isEmpty()) return result;
        
        Set<Integer> found = new HashSet<Integer>();
        Set<Integer> added = new HashSet<Integer>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String sequence = s.substring(i, i + 10);
            int d = compress(sequence);
            if (found.contains(d)) {
                if (!added.contains(d)) {
                    result.add(sequence);
                    added.add(d);
                }
            } else {
                found.add(d);
            }
        }
        return result;
    }
    
    // there're 4 possible characters in total
    // so 2 bits are enough to represent them
    // for 10-length substring, 20 bits are enough
    // we can use a 32-bit integer to compress the substring
    private int compress(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0); map.put('C', 1); map.put('G', 2); map.put('T', 3);
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result << 2) + map.get(s.charAt(i));
        }
        return result;
    }
}
