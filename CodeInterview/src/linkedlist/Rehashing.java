package linkedlist;

/**
 * here we have three numbers, 9, 14 and 21, 
 * where 21 and 9 share the same position as they 
 * all have the same hashcode 1 (21 % 4 = 9 % 4 = 1). 
 * We store them in the hash table by linked list.
 * rehashing this hash table, double the capacity, you will get:
 * size=3, capacity=8
 * index:   0    1    2    3     4    5    6   7
 * hash : [null, 9, null, null, null, 21, 14, null]
 * Given the original hash table, return the new hash table after rehashing .
 *
 */
public class Rehashing {
	public static ListNode[] rehashing(ListNode[] hashTable) {
        int oldCapacity = hashTable.length;
        int newCapacity = 2 * oldCapacity;
        ListNode[] newHashTable = new ListNode[newCapacity];
        for (ListNode head : hashTable) {
            ListNode node = head;
            while (node != null) {
            	ListNode next = node.next;
                int hash = node.val >= 0 ? node.val % newCapacity : (node.val % newCapacity + newCapacity) % newCapacity;
                ListNode tail = newHashTable[hash];
                if (tail == null) {
                    newHashTable[hash] = node;
                } else {
                    while (tail.next != null) tail = tail.next;
                    tail.next = node;
                }
                node.next = null; // important!
                node = next;
            }
        }
        return newHashTable;
    }
	
	public static void main(String[] s) {
		ListNode[] hashtable = { null, null, new ListNode(29, new ListNode(5)) };
		rehashing(hashtable);
	}
}
