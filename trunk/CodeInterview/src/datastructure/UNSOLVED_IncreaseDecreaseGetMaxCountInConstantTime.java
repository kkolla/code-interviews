package datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * company: Uber, stage: phone
 * 
 * http://blog.csdn.net/whuwangyi/article/details/43112895
 * 
 * 设计一个数据结构，满足insert(int key)，remove(int key)和int getMostFrequentKey()。
 * 对于同一个key，每次被insert，计数加1；每次被remove，计数减1；然后需要取最大count的key。
 * 要求所有操作都是O(1)复杂度 *
 */

// WRONG AND INCOMPLETE!!!
public class UNSOLVED_IncreaseDecreaseGetMaxCountInConstantTime {
	
	class DoublyLinkedListNode {
		final int count;
		
		Set<Integer> keys;
		
		DoublyLinkedListNode prev;
		DoublyLinkedListNode next;
		
		public DoublyLinkedListNode(int count) {
			this.count = count;
		}
	}
	
	DoublyLinkedListNode head;
	Map<Integer, DoublyLinkedListNode> keyToNodeMap;
	Map<Integer, DoublyLinkedListNode> countToNodeMap;
	DoublyLinkedListNode maxNode;
	
	public UNSOLVED_IncreaseDecreaseGetMaxCountInConstantTime() {
		this.head = null;
		this.keyToNodeMap = new HashMap<Integer, DoublyLinkedListNode>();
		this.countToNodeMap = new HashMap<Integer, DoublyLinkedListNode>();
		this.maxNode = null;
	}
	
	public void insert(int key) {
		if (!keyToNodeMap.containsKey(key)) {
			
		}
	}
	
	public void remove(int key) {
		DoublyLinkedListNode node = this.keyToNodeMap.get(key);
		node.keys.remove(key);
		
		if (node.next == null) {
			DoublyLinkedListNode smallerNode = new DoublyLinkedListNode(node.count - 1);
			node.next = smallerNode;
			smallerNode.prev = node;
			head.prev = smallerNode;
			smallerNode.next = head;
		}
		
		node.next.keys.add(key);
		
		if (maxNode == node && node.keys.isEmpty())
			maxNode = node.prev;
	}
	
	public int getMostFrequentKey() {
		return maxNode != null ? maxNode.keys.iterator().next() : 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
