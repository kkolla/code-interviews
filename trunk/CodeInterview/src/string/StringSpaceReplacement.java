package string;

/**
 * Write a method to replace all spaces in a string with %20. 
 * The string is given in a characters array, 
 * you can assume it has enough space for replacement and you are given the true length of the string.
 * Example
 * Given "Mr John Smith", length = 13.
 * The string after replacement should be "Mr%20John%20Smith".
 * Note
 * If you are using Java or Python，please use characters array instead of string.
 * Challenge
 * Do it in-place.
 *
 */
public class StringSpaceReplacement {
	/**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        int spaces = 0;
        for (int i = 0; i < length; i++)
            if (string[i] == ' ') spaces++;
        int newLength = length + spaces * 2;
        int last = newLength - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (string[i] == ' ') {
                string[last--] = '0';
                string[last--] = '2';
                string[last--] = '%';
            } else {
                string[last--] = string[i];
            }
        }
        return newLength;
    }
}
