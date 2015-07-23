package calculation;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
	public int maxPoints(Point[] points) {
        if (points.length <= 1) return points.length;
        
        int max = 1;
        for (int i = 0; i < points.length - 1; i++) {
            Point p1 = points[i];
            Map<Double, Integer> slopes = new HashMap<Double, Integer>();
            int pointsWithSameXAndY = 1; // including p1 itself
            int pointsWithSameXAndDifferentY = 0;
            int maxCandidate = 0;
            for (int j = i + 1; j < points.length; j++) {
                Point p2 = points[j];
                if (p1.x == p2.x && p1.y == p2.y) {
                    ++pointsWithSameXAndY;
                } else if (p1.x == p2.x) {
                    maxCandidate = Math.max(maxCandidate, ++pointsWithSameXAndDifferentY);
                } else {
                    double slope = (double)(p2.y - p1.y) / (p2.x - p1.x);
                    if (slope == -0) slope = 0;
                    int count = 1 + (slopes.containsKey(slope) ? slopes.get(slope) : 0);
                    slopes.put(slope, count);
                    maxCandidate = Math.max(maxCandidate, count);
                }
                
            }
            max = Math.max(max, maxCandidate + pointsWithSameXAndY);
        }
        
        return max;
    }
}
