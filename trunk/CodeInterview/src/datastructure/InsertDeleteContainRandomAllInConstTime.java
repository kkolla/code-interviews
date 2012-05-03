package datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertDeleteContainRandomAllInConstTime<T> {
	List<T> a = new ArrayList<T>();
	Map<T, Integer> map = new HashMap<T, Integer>();

	public boolean insert(T obj) {
		if (contains(obj))
			return false;

		int index = a.size();
		a.add(obj);
		map.put(obj, index);

		return true;
	}

	public boolean contains(T obj) {
		return map.containsKey(obj);
	}

	public boolean delete(T obj) {
		if (!contains(obj))
			return false;

		int index = map.get(obj);
		map.remove(obj);
		T last = a.remove(a.size() - 1);
		a.set(index, last);
		map.put(last, index);

		return true;
	}

	public T getRandom() {
		if (a.size() == 0)
			return null;
		else
			return a.get((int) (Math.random() * a.size()));
	}
}
