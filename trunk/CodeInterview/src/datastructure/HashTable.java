package datastructure;

import java.util.Iterator;
import java.util.LinkedList;

import utils.CreateUtils;

public class HashTable<K, V> {

	public class Pair<F, S> {
		public F first;
		public S second;

		public Pair(F first, S second) {
			this.first = first;
			this.second = second;
		}
	}

	static final int INIT_CAPACITY = 16;
	static final float LOAD_FACTOR = 0.75f;

	LinkedList<Pair<K, V>>[] lists;
	int resizeThreshold;
	int size;
	int capacity;

	public HashTable() {
		this(INIT_CAPACITY);
	}

	public HashTable(int initCapacity) {
		capacity = 1;
		while (capacity < initCapacity)
			capacity <<= 1;
		resizeThreshold = (int) LOAD_FACTOR * capacity;
		lists = new LinkedList[capacity];
		for (int i = 0; i < lists.length; i++) {
			lists[i] = new LinkedList<Pair<K, V>>();
		}
		size = 0;
	}

	public V get(K key) {
		if (key == null)
			return null;
		int hash = key.hashCode() % capacity;
		Iterator<Pair<K, V>> iter = lists[hash].iterator();
		while (iter.hasNext()) {
			Pair<K, V> p = iter.next();
			if (p.first == key)
				return p.second;
		}
		return null;
	}

	public V put(K key, V value) {
		if (key == null)
			return null;
		int hash = key.hashCode() % capacity;
		V old = null;
		Iterator<Pair<K, V>> iter = lists[hash].iterator();
		while (iter.hasNext()) {
			Pair<K, V> p = iter.next();
			if (p.first == key) {
				old = p.second;
				p.second = value;
				break;
			}
		}
		if (old == null) {
			lists[hash].offer(new Pair<K, V>(key, value));
			size++;
		}
		return old;
	}

	public boolean containsKey(K key) {
		if (key == null)
			return false;
		int hash = key.hashCode() % capacity;
		Iterator<Pair<K, V>> iter = lists[hash].iterator();
		while (iter.hasNext()) {
			Pair<K, V> p = iter.next();
			if (p.first == key) {
				return true;
			}
		}
		return false;
	}

	public int size() {
		return size;
	}

	public void checkForResizing() {
		if (size < resizeThreshold)
			return;
		capacity = capacity * 2;
		LinkedList<Pair<K, V>>[] newLists = new LinkedList[capacity];
		for (int i = 0; i < newLists.length; i++) {
			newLists[i] = new LinkedList<Pair<K, V>>();
		}
		for (int i = 0; i < lists.length; i++) {
			Iterator<Pair<K, V>> iter = lists[i].iterator();
			while (iter.hasNext()) {
				Pair<K, V> p = iter.next();
				int hash = p.first.hashCode() % capacity;
				newLists[hash].offer(new Pair<K, V>(p.first, p.second));
			}
		}
		lists = newLists;
		resizeThreshold = (int) LOAD_FACTOR * capacity;
	}

	public static void main(String[] args) {
		HashTable<String, Integer> h = new HashTable<String, Integer>();
		String[] keys = new String[1000];
		for (int i = 0; i < keys.length; i++) {
			keys[i] = "k-" + i;
		}
		for (int i = 0; i < 1000; i++) {
			String key = keys[CreateUtils.randNonNegInt(keys.length)];
			int value = CreateUtils.randInt(100);
			if (Math.random() > 0.5) {
				Integer old = h.put(key, value);
				System.out.println("put(" + key + "," + value + "), old: "
						+ old + ", size: " + h.size());
			} else {
				Integer v = h.get(key);
				System.out.println("get(" + key + ")=" + v + ", size: "
						+ h.size());
			}
		}
	}

}
