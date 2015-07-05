package datastructure;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("somestring");
 * trie.search("key");
 *
 */
public class SimpleTrie {
	
	public static class TrieNode {
		Character value; // null for root only
		TrieNode[] children = new TrieNode[26]; // lowercase characters only
		boolean wordEndsHere;
		
	    // Initialize your data structure here.
	    public TrieNode() {
	        
	    }
	    
	    public TrieNode(char c) {
	    	value = c;
	    }
	    
	    public TrieNode getChild(char c) {
	    	int index = c - 'a';
	    	return children[index];
	    }
	    
	    public TrieNode setChild(char c) {
	    	int index = c - 'a';
	    	TrieNode n = new TrieNode(c);
	    	children[index] = n;
	    	return n;
	    }
	}

	private TrieNode root;

    public SimpleTrie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	TrieNode n = root;
    	for (int i = 0; i < word.length(); i++) {
    		char c = word.charAt(i);
    		TrieNode child = n.getChild(c);
    		if (child == null) {
    			child = n.setChild(c);
    		}
    		n = child;
    	}
    	n.wordEndsHere = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	TrieNode n = root;
    	int i = 0;
    	for (; i < word.length(); i++) {
    		char c = word.charAt(i);
    		n = n.getChild(c);
    	    if (n == null) break;
    	}
    	return i == word.length() && n.wordEndsHere;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode n = root;
    	int i = 0;
    	for (; i < prefix.length(); i++) {
    		char c = prefix.charAt(i);
    		n = n.getChild(c);
    		if (n == null) break;
    	}
    	return i == prefix.length();
    }

	public static void main(String[] args) {
		SimpleTrie trie = new SimpleTrie();
		trie.insert("somestring");
		System.out.println(trie.search("key"));
		System.out.println(trie.search("something"));
		System.out.println(trie.search("somestring"));
		System.out.println(trie.startsWith("somestring"));
		System.out.println(trie.startsWith("s"));		
		System.out.println(trie.startsWith("some"));
		System.out.println(trie.startsWith("somef"));

	}

}
