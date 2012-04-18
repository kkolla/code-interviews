package calculation;

import java.util.HashMap;
import java.util.Map;

import utils.CreateUtils;

public class LineCrossingMostPoints {

	public static class Point {
		public double x;
		public double y;
	}

	public static class Line {
		public boolean isVertical;
		public double slope;
		public double intercept;
	}

	public static Line findLine(Point[] points) {
		Line line = new Line();
		int maxPoints = 0;
		for (int i = 0; i < points.length - 1; i++) {
			Point p1 = points[i];
			int verticalPoints = 0;
			Map<Double, Integer> slopes = new HashMap<Double, Integer>();
			for (int j = i + 1; j < points.length; j++) {
				Point p2 = points[j];
				if (p1.x == p2.x) {
					verticalPoints++;
					if (verticalPoints > maxPoints) {
						maxPoints = verticalPoints;
						line.isVertical = true;
						line.slope = Double.NaN;
						line.intercept = p1.x;
					}
				} else {
					double slope = (p1.y - p2.y) / (p1.x - p2.x);
					if (slopes.containsKey(slope)) {
						slopes.put(slope, slopes.get(slope) + 1);
					} else {
						slopes.put(slope, 1);
					}
					if (slopes.get(slope) > maxPoints) {
						maxPoints = slopes.get(slope);
						line.isVertical = false;
						line.slope = slope;
						line.intercept = p1.y - slope * p1.x;
					}
				}
			}
		}

		return line;
	}

	public static void main(String[] args) {
		int n = CreateUtils.randNonNegInt(100);
		Point[] points = new Point[n];
		for (int i = 0; i < n; i++) {
			points[i] = new Point();
			points[i].x = CreateUtils.randReal(100);
			points[i].y = CreateUtils.randReal(100);
			System.out.print("(" + points[i].x + "," + points[i].y + ") ");
		}
		Line l = findLine(points);
		System.out.println("\nline slope: " + l.slope + " intercept: "
				+ l.intercept);
	}

}
