package combinatorics;

import utils.CreateUtils;

/*
 * Numbers are represented using letter as in phone keypad. 
 * For example 2->a,b,c 3->d,e,f till 9->w,x,y,z (0 and 1 are not 
 * represented by any letter). Print all the possible strings
 * that can be generated from the given 9 digit phone number. 
 * For example 23 would generate 9 strings
 * ad,ae,af,bd,be,bf,cd,ce,cf
 */
public class PringAllWordsByPhoneNumber {

	public static void print(char[] number, int start, String s, char[][] map) {
		if (start == number.length) {
			System.out.println(s);
			return;
		}
		char[] possibleLetters = map[number[start] - '0'];
		if (possibleLetters.length != 0) {
			for (int i = 0; i < possibleLetters.length; i++) {
				print(number, start + 1, s + possibleLetters[i], map);
			}
		} else {
			print(number, start + 1, s, map);
		}
	}

	public static void main(String[] args) {
		char[][] map = new char[][] { {}, {}, { 'a', 'b', 'c' },
				{ 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
				{ 'o', 'p', 'q' }, { 'r', 's', 't' }, { 'u', 'v', 'w' },
				{ 'w', 'x', 'y', 'z' } };
		int[] a = CreateUtils.randNonNegIntArray(5, 10);
		char[] number = new char[a.length];
		for (int i = 0; i < number.length; i++)
			number[i] = (char) ('0' + a[i]);
		System.out.println(number);
		print(number, 0, "", map);
	}

}
