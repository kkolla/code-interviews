package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.PrintUtils;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 *
 */
public class CourseScheduleII {
	
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        for (int[] p : prerequisites) {
            int courseRequiringPrerequisite = p[0];
            in[courseRequiringPrerequisite]++;
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < in.length; i++)
            if (in[i] == 0) q.offer(i); // this course can be taken the first
                
        
        int[] result = new int[numCourses];
        int j = 0;
        while (!q.isEmpty()) {
            int courseToTake = q.poll();
            result[j++] = courseToTake;
            for (int[] p : prerequisites) {
                // if course to take is the prerequisite of any courses, decrement its in degree
                int prerequisite = p[1];
                if (prerequisite == courseToTake) {
                    int course = p[0];
                    if (--in[course] == 0) q.offer(course);
                }
            }
        }
        
        return j == numCourses ? result : new int[0];
    }

	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = { {1, 0} };
		PrintUtils.printArray(findOrder(numCourses, prerequisites));

		int numCourses2 = 4;
		int[][] prerequisites2 = { {1,0}, {2,0}, {3,1}, {3,2} };
		PrintUtils.printArray(findOrder(numCourses2, prerequisites2));
	}

}
