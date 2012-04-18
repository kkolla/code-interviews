package probability;

import utils.CreateUtils;

/*
 * Design and implement a class to train from a input string 
 * like "ape apple ace" to generate new words based on 
 * conditional probability of P(c_i|c_j).
 * e.g., P(p|a), P(e|p), P(l|p).
 * class TokenGenerator {
 *     public void train(String t) {...}
 *     public String generate() {...}
 * }
 * How to optimize generate() method.
 */

// buggy, just an overview
public class BigramStringGenerator {

	// allow only 26 lower case letters and space
	final int characters = 27;

	int[][] bigramCounts = new int[characters][characters];
	int[] startCounts = new int[characters];
	double[][] conditionalProbs = new double[characters][characters];
	double[] startProbs = new double[characters];

	int trainedTimes = 0;

	public void train(String t) {
		updateCounters(t);
		calculateProbabilities();
	}

	private void calculateProbabilities() {
		for (int i = 0; i < characters; i++) {
			int total = 0;
			for (int j = 0; j < characters; j++)
				total += bigramCounts[i][j];
			for (int j = 0; j < characters; j++) {
				conditionalProbs[i][j] = (double) bigramCounts[i][j] / total;
			}
			startProbs[i] = (double) startCounts[i] / trainedTimes;
		}
	}

	private void updateCounters(String t) {
		char c = t.charAt(0);
		startCounts[charIndex(c)]++;
		for (int i = 1; i < t.length(); i++) {
			char curr = t.charAt(i);
			char prev = t.charAt(i - 1);
			bigramCounts[charIndex(prev)][charIndex(curr)]++;
		}
		trainedTimes++;
	}

	private int charIndex(char c) {
		if (c == ' ')
			return 26;
		else
			return c - 'a';
	}

	public String generate() {
		// generate start
		double prob = Math.random();
		double p = 0;
		int i = 0;
		while (i < characters) {
			p += startProbs[i];
			if (p > prob)
				break;
			i++;
		}
		char curr = i == characters ? ' ' : (char) ('a' + i);
		StringBuffer sb = new StringBuffer(curr);
		// generate the remaining depending on the conditional probabilities
		while (sb.length() < 100) {
			char prev = curr;
			prob = Math.random();
			p = 0;
			i = 0;
			while (i < characters) {
				p += conditionalProbs[charIndex(prev)][i];
				if (p >= prob)
					break;
				i++;
			}
			curr = i == characters ? ' ' : (char) ('a' + i);
			sb.append(curr);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		BigramStringGenerator gen = new BigramStringGenerator();
		String[] trains = CreateUtils.randStringArray(2, 100, true);
		if (trains.length == 1) {
			for (String train : trains) {
				System.out.println("train: " + train);
				gen.train(train);
			}
			System.out.println(gen.generate());
		}
	}

}
