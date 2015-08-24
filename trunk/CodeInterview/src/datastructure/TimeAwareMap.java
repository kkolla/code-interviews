package datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * company: Uber, stage: phone
 * 
 * http://www.mitbbs.com/article_t/JobHunting/33021795.html
 * 写一个class实现下面功能：
 * put(key, value, time)
 * get(key, time)
 * 要求get返回给定time前面的那个值
 *
 */
public class TimeAwareMap {
	// key: key, value: map from time milliseconds to value
	Map<Object, TreeMap<Long, Object>> map;
	
	public TimeAwareMap() {
		map = new HashMap<Object, TreeMap<Long, Object>>();
	}
	
	// O(n)
	// can binary search if TreeMap.keySet().toArray() is O(1)
	public Object get(Object key, long time) {
		if (!map.containsKey(key)) return null;
		
		TreeMap<Long, Object> timeToValue = map.get(key);
		
		Long latestSavedTimeBeforeGivenTime = null;
		for (long savedTime : timeToValue.keySet()) {
			if (savedTime < time) latestSavedTimeBeforeGivenTime = savedTime;
			else break;
		}

		return latestSavedTimeBeforeGivenTime != null ? 
				timeToValue.get(latestSavedTimeBeforeGivenTime) : null;
	}
	
	// O(log(n)) where n is the maximum number of timestamps for a key
	// can be O(1) by replacing TreeMap by HashMap, if put is a heavy operation
	public Object put(Object key, Object value, long time) {
		if (!map.containsKey(key)) {
			map.put(key, new TreeMap<Long, Object>());
		}
		return map.get(key).put(time, value);
	}
	
	public static void main(String[] s) {
		TimeAwareMap map = new TimeAwareMap();
		System.out.println("get('a', 100) = " + map.get('a', 100));
		map.put('a', 1, 100);
		map.put('a', 2, 200);
		System.out.println("get('a', 250) = " + map.get('a', 250));
		System.out.println("get('a', 101) = " + map.get('a', 101));
		System.out.println("get('a', 100) = " + map.get('a', 100));
		System.out.println("get('a', 99) = " + map.get('a', 99));
	}
}
