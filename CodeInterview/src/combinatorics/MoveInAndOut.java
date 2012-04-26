package combinatorics;

import java.util.HashSet;
import java.util.Set;

import utils.CreateUtils;

/*
 * Given n people, initially outside of a room, a function move(i) to move in/out the i-th person
 * Let the room contain every subset of the n people.
 */
public class MoveInAndOut {

	public static void subsets(Integer[] people, Set<Integer> peopleInTheRoom,
			int count, int n) {
		if (count == n) {
			for (Integer i : peopleInTheRoom)
				System.out.print(i + "");
			System.out.println();
			return;
		}
		subsets(people, peopleInTheRoom, count + 1, n);
		move(people[count], peopleInTheRoom);
		System.out.println("move(" + (count + 1) + ")");
		subsets(people, peopleInTheRoom, count + 1, n);
		// move(people[count], peopleInTheRoom); is this line optional?
	}

	public static void move(Integer person, Set<Integer> peopleInTheRoom) {
		if (peopleInTheRoom.contains(person))
			peopleInTheRoom.remove(person);
		else
			peopleInTheRoom.add(person);
	}

	public static void main(String[] args) {
		final int n = CreateUtils.randNonNegInt(5);
		System.out.println(n);
		final Integer[] people = new Integer[n];
		for (int i = 0; i < n; i++)
			people[i] = new Integer(i + 1);
		subsets(people, new HashSet<Integer>(), 0, n);
	}

}
