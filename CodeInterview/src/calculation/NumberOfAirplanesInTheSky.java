package calculation;

import interval.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given an interval list which are flying and landing time of the flight. 
 * How many airplanes are on the sky at most?
 * Example
 * For interval list [[1,10],[2,3],[5,8],[4,7]], return 3
 * 
 * Note
 * If landing and flying happens at the same time, we consider landing should happen at first.
 *
 */
public class NumberOfAirplanesInTheSky {
	public static class Pair {
        int time;
        boolean isStart;
        public Pair(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    } 
     
    public int countOfAirplanes(List<Interval> airplanes) { 
        List<Pair> pairs = new ArrayList<Pair>();
        for (Interval airplane : airplanes) {
            pairs.add(new Pair(airplane.start, true));
            pairs.add(new Pair(airplane.end, false));
        }
        
        Collections.sort(pairs, new Comparator<Pair>() {
            @Override public int compare(Pair p1, Pair p2) {
                return p1.time == p2.time ? (p1.isStart ? 1 : -1) : p1.time - p2.time;
            }
        });
        
        int maxNests = 0, nests = 0;
        for (Pair pair : pairs) {
            if (pair.isStart) { 
                nests++;
                maxNests = Math.max(maxNests, nests);
            } else 
                nests--;
        }
        return maxNests;
    }
}
