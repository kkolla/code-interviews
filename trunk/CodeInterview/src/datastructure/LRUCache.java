package datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of 
 * the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. 
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 */
public class LRUCache {
	
	static class DoublyLinkedListNode {
		int key;
		int val;
		DoublyLinkedListNode prev;
		DoublyLinkedListNode next;
		
		public DoublyLinkedListNode (int key, int value) {
			this.key = key;
			this.val = value;
		}
	}
	
	int capacity;
	DoublyLinkedListNode head; // points to the most recently accessed element
	Map<Integer, DoublyLinkedListNode> map;
	
	public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.map = new HashMap<Integer, DoublyLinkedListNode>();
    }
    
	// O(1)
    public int get(int key) {
    	if (this.map.containsKey(key)) {
    		// cache hit
    		DoublyLinkedListNode node = this.map.get(key);
    		// move the node to the list head
    		this.removeNodeFromLinkedList(node);
    		this.addNodeToLinkedListHead(node);
    		return node.val;
    	} else {
    		// cache miss
    		return -1;
    	}
    }
    
    // O(1)
    public void set(int key, int value) {
    	if (this.get(key) != -1) {
    		// the key exists, update its value and move to head
    		DoublyLinkedListNode node = this.map.get(key);
    		this.removeNodeFromLinkedList(node);
    		this.addNodeToLinkedListHead(node);
    		node.val = value;
    	} else {
    		DoublyLinkedListNode node = new DoublyLinkedListNode(key, value);
    		if (this.map.size() == this.capacity) {
    			// if reached max capacity, remove the tail node
    			DoublyLinkedListNode tail = this.head.prev;
    			this.removeNodeFromLinkedList(tail);
    			// remove mapping
    			map.remove(tail.key);
    		}
    		this.addNodeToLinkedListHead(node);
    		// create mapping
    		this.map.put(key, node);
    	}
    }
	
    // O(1)
	private void removeNodeFromLinkedList(DoublyLinkedListNode node) {
		if (this.head == node) this.head = node.next;
		node.prev.next = node.next;  
	    node.next.prev = node.prev;
	}

	// O(1)
	private void addNodeToLinkedListHead(DoublyLinkedListNode node) {
		if (this.head != null) {
			DoublyLinkedListNode tail = head.prev;
			this.head.prev = node;
			node.next = this.head;
			tail.next = node;
			node.prev = tail;
		} else {
			// node is the head, just make it doubly linked
			node.next = node;
			node.prev = node;
		}
		
		// update head to the new node
		this.head = node;
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		System.out.println(cache.get(1));
		cache.set(1, 1);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		cache.set(2, 2);
		cache.set(3, 3);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		cache.set(4, 4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		
	}

}
