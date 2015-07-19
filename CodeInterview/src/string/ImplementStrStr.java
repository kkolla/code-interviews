package string;

/**
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, 
 * or -1 if needle is not part of haystack.
 *
 */
public class ImplementStrStr {

	public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        
        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length()) return -1;
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;   
            }
            if (j == needle.length()) return i;
        } 
        return -1;
    }

}
