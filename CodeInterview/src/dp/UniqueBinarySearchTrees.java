package dp;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * 
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *   2     1         2                 3
 *
 */
public class UniqueBinarySearchTrees {
	// nums[i]: number of unique BST's constructed by 1..i
    // answer: nums[n]
    // nums[i] = sum(nums[j] * nums[i - j - 1]) for 0 <= j <= i - 1
    // http://fisherlei.blogspot.com/2013/03/leetcode-unique-binary-search-trees.html
    // https://en.wikipedia.org/wiki/Catalan_number#Applications_in_combinatorics
    public int numTrees(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        for (int i = 1; i <= n ;i++) {
            int sum = 0;
            for (int j = 0; j <= i - 1; j++)
                sum += nums[j] * nums[i - j - 1];
            nums[i] = sum;
        }
        return nums[n];
    }
}
