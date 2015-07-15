package graph;

import java.util.LinkedList;
import java.util.Queue;

import utils.PrintUtils;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, 
 * for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, 
 * and to take course 0 you should also have finished course 1. So it is impossible.
 *
 */
public class CourseSchedule {
	
	public static boolean canFinishDFS(int numCourses, int[][] prerequisites) {
		boolean[][] hasEdge = new boolean[numCourses][numCourses];
		for (int[] prerequisite : prerequisites) {
			int curr = prerequisite[0];
			int prer = prerequisite[1];
			hasEdge[curr][prer] = true;
		}
		
		// 0: unvisited, 1: visited in previous dfs, -1: visited in the same dfs
		int[] visited = new int[numCourses];
		for (int i = 0; i < numCourses; i++)
			if (!canFinishDFS(i, hasEdge, visited)) return false;
		return true;
	}
	
	public static boolean canFinishDFS(int i, boolean[][] hasEdge, int[] visited) {
		if (visited[i] == -1) return false;
		if (visited[i] == 1) return true;
		
		visited[i] = -1;
		for (int j = 0; j < hasEdge.length; j++) {
			if (hasEdge[i][j]) 
				if (!canFinishDFS(j, hasEdge, visited)) return false;
		}
		visited[i] = 1;
		return true;
	}
	
	public static boolean canFinishBFS(int numCourses, int[][] prerequisites) {
		// inDegrees[i]: # of prerequisites for taking i-th course
		int[] inDegrees = new int[numCourses];
		
		for (int i = 0; i < prerequisites.length; i++)
			inDegrees[prerequisites[i][0]]++;
		
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++)
			if (inDegrees[i] == 0)
				q.offer(i);

		while (!q.isEmpty()) {
			int p = q.poll();
			for (int i = 0; i < prerequisites.length; i++) {
			    int prerequisite = prerequisites[i][1], curr = prerequisites[i][0];
				if (prerequisite == p)
					if (--inDegrees[curr] == 0) q.offer(curr);
			}
		}

		for (int degrees : inDegrees)
			if (degrees > 0) return false;
		return true;
    }

	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = { {1, 0} };
		System.out.println(canFinishBFS(numCourses, prerequisites));
	}

}
